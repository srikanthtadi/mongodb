package com.mongodb;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.http.matching.Halt;

public class HelloWorldSparkFreemarkerstyle {
public static void main(String[] args) {
	
	
	final Configuration config = new Configuration();
	 
	 config.setClassForTemplateLoading(HelloWorldSparkFreemarkerstyle.class, "/");
	 
	 
	 
	Spark.get("/", new Route() {
		
		public Object handle(Request arg0, Response arg1) throws Exception {
			// TODO Auto-generated method stub
			
			 Map<String,Object> paramMap = new HashMap<String,Object>();
				StringWriter writer  = new StringWriter();
				
			 try {
				Template temp = config.getTemplate("home.ftl");
				paramMap.put("name", "srikanth");
				
				temp.process(paramMap, writer);
				System.out.println(writer);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
			return writer;
		}
	});
}
}
