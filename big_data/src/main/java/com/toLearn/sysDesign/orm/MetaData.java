package com.toLearn.sysDesign.orm;
public class MetaData {
    String assetType;
    long assetId;
    String walletAddress;
    Boolean isApproved;
    long assetInUsd;

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public void setAssetInUsd(long assetInUsd) {
        this.assetInUsd = assetInUsd;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public String getAssetType() {
        return assetType;
    }

    public long getAssetId() {
        return assetId;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public long getAssetInUsd() {
        return assetInUsd;
    }

    public String getWalletAddress() {
        return walletAddress;
    }


    public  static  void main(String [] args) throws Exception {
       QueryBuilder<MetaData> _query = new QueryBuilder<>();
       System.out.println(_query.createQueryBuilder(MetaData.class).toString());
       System.out.println(_query.getByQueryBuilder(MetaData.class,"assetId","x","y","z"));
       System.out.println(       _query.updateQueryBuilder(MetaData.class,"MetaData","assetId","a","b","c","d"));
       System.out.println(_query.deleteQueryBuilder(MetaData.class,"assetId"));
    }
}
