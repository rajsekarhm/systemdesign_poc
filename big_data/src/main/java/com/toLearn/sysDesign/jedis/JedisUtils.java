package com.toLearn.sysDesign.jedis;

import redis.clients.jedis.Jedis;

public class JedisUtils implements  IJedis{
    public  JedisUtils(){}
    public  static Jedis  makeConnection() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("Connection to server sucessfully");
        System.out.println("Server is running: "+jedis.ping());
        return jedis;
    }

    @Override
    public void set() {

    }

    @Override
    public void get() {

    }

}
