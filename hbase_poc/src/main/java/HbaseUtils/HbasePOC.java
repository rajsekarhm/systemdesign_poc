package HbaseUtils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.util.Bytes;

import java.sql.Connection;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class HbasePOC {
    private static Connection connection = null;
    private final static String TABLE = "ExceptionMetrics";
    private final static String COLUMNFAMILY = "exemption";
    private final static String COLUMNKEY = "data";
    private final static int SCAN_LIMIT = 3;

    public static void main(String[] args) throws Exception{
        Logger.getLogger("org.apache.zookeeper").setLevel(Level.ALL);
        Logger.getLogger("org.apache.hadoop.hbase.zookeeper").setLevel(Level.ALL);
        Logger.getLogger("org.apache.hadoop.hbase.client").setLevel(Level.ALL);
        getConnection();
        put("rk4", "dbwfkjdskjf" , "data");

    }

    public static void getConnection() throws Exception{
        Configuration configuration  = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.property.clientPort", "2189");
        configuration.set("hbase.zookeeper.quorum", "127.0.0.1");
        connection = ConnectionFactory.createConnection(configuration);
    }

    public static Table getTable() throws Exception{
        if(connection!=null){
            return connection.getTable(TableName.valueOf(TABLE));
        }
        return null;
    }

    public static List<String> getZGIDList(){
        List<String> zgidList = new ArrayList<>();
        //zgidList.add("12345");
        zgidList.add("12346");
        zgidList.add("12347");
//        zgidList.add("12348");
//        zgidList.add("12349");
//        zgidList.add("26349");
//        zgidList.add("28349");
//        zgidList.add("29349");
//        zgidList.add("21349");
//        zgidList.add("31349");
//        zgidList.add("30349");
        //zgidList.add("909090");
        return zgidList;
    }

    public static void initiateDeletion(List<String> zgids) {
        for (String zgid : zgids) {
            try {
                Long startTime = System.currentTimeMillis();
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Started for ZGID: " + zgid + " at " + startTime);
                performDeletion(zgid);
                Long stopTime = System.currentTimeMillis();
                System.out.println("Ended for ZGID: " + zgid + " at " + stopTime);
                System.out.println("TimeTaken is : " + (stopTime - startTime));
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            }catch (Exception e){
                System.out.println("Exception while deleting threads for ZGID : "+zgid);
                e.printStackTrace();
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }
    }

    private static void performDeletion(String zgid) throws Exception{
        populateData(zgid);
//        long deletedCount = 0;
//        List<Delete> deleteList = performScan(zgid);
//        while(deleteList!=null && deleteList.size()>0) {
//            deletedCount = deletedCount + deleteList.size();
//            Table table = getTable();
//            table.delete(deleteList);
//            System.out.println("Deleted " + deletedCount + " threads....");
//            deleteList = performScan(zgid);
//        }
    }

    private static List<Delete> performScan(String zgid) throws Exception{
        List<Delete> deleteList = new ArrayList<>();
        Scan scan = new Scan();
//        scan.setLimit(SCAN_LIMIT);
        scan.setRowPrefixFilter(Bytes.toBytes(zgid+"_"));
        scan.addColumn(Bytes.toBytes(COLUMNFAMILY), Bytes.toBytes(COLUMNKEY));
        Table table = getTable();
        ResultScanner scanner = table.getScanner(scan);
        for (Result result : scanner) {
            String key = Bytes.toString(result.getRow());
            deleteList.add(new Delete(Bytes.toBytes(key)));
        }
        return deleteList;
    }

    private static void populateData(String zgid) throws Exception{
        for(int i=0;i<10;i++){
            Random random = new Random();
            put(zgid+"_"+random.nextInt(900000000-100000000)+100000000,"content for the put value");
        }
    }

    public static void put(String rowKey, String value) throws Exception {
        put(rowKey, value, COLUMNKEY);
    }

    public static void put(String rowKey, String value, String column) throws Exception{
    Put put = new Put(Bytes.toBytes(rowKey));
    put.addColumn(Bytes.toBytes(COLUMNFAMILY), Bytes.toBytes(column), value.getBytes());

    Table table = getTable();
    if(table!=null){
        System.out.println("Going to put");
        table.put(put);
        table.close();
        System.out.println("Done put");
    }
    }

    public static Map<String, byte[]> get(Connection connection, String columnFamily, String rowKey, String... columnKeys) throws Exception {
        Map<String, byte[]> retMap = new LinkedHashMap<>();
        Get get = new Get(Bytes.toBytes(rowKey));

        if (columnKeys != null && columnKeys.length > 0) {
            for (String columnKey : columnKeys) {
                get.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(columnKey));
            }
        } else {
            get.addFamily(Bytes.toBytes(columnFamily));
        }
        Result res;
        Table tableObj = connection.getTable(TableName.valueOf(TABLE));
        try {
            res = tableObj.get(get);
        } finally {
            tableObj.close();
        }

        NavigableMap<byte[], byte[]> scanner = res.getFamilyMap(Bytes.toBytes(columnFamily));
        if (scanner != null) {
            if (columnKeys != null && columnKeys.length > 0) {
                for (String columKey : columnKeys) {
                    byte[] ck = Bytes.toBytes(columKey);
                    retMap.put(columKey, scanner.get(ck));
                }
            } else {
                for (byte[] ck : scanner.keySet()) {
                    retMap.put(Bytes.toString(ck), scanner.get(ck));
                }
            }
        }

        for(Map.Entry ret : retMap.entrySet()){
            System.out.print("Key: "+ret.getKey());
            System.out.println(" value: "+ret.getValue());
        }
        return retMap;

    }
}

