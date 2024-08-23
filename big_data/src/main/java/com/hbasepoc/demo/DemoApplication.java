package com.hbasepoc.demo;

import com.hbasepoc.demo.hbase.HBaseUtils;
import com.hbasepoc.demo.jedis.JedisUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) throws Exception {
			SpringApplication.run(DemoApplication.class, args);
//			if(true){
//				HBaseUtils _hbase = new HBaseUtils("ExceptionMetrics");
//				_hbase.put("4","testing4","exemption","architecturerule");
//
//			}
//			var _jedis = JedisUtils.makeConnection();
//			_jedis.set("rajaseakr","{ \"file\": \"" + "/Users/raja-17710/hooks_lib/pre_commit_hook" + "\" }");

	}
}
