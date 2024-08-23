package com.hbasepoc.demo.exemption;

import com.hbasepoc.demo.jedis.JedisUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController @RequestMapping("/api/v1")

public class ExemptionImplDAO {
    Jedis createJedis;
    public  ExemptionImplDAO(){
         this.createJedis = JedisUtils.makeConnection();
    }
    @RequestMapping(value =  "/createExemption", consumes = "application/json")
    public String   createExemption(@RequestBody ExemptionDAO.Builder _create){
        this.createJedis.set(_create.developerUsername,_create.toString());
        return "accepted";
    }

    @RequestMapping(value =  "/getExemption", consumes = "application/json")
    public  String getExemption(@RequestBody String _get){
        this.createJedis.get(_get);
        return "accepted";
    }

    @RequestMapping(value =  "/updateExemption", consumes = "application/json")
    public  String updateExemption(@RequestBody ExemptionDAO.Builder _update){
        this.createJedis.set(_update.developerUsername,_update.toString());
        return "accepted";
    }

}
