package com.mongodb;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldFreemarkerstyle {

 public static void main(String[] args) {
	
	 Configuration config = new Configuration();
	 
	 config.setClassForTemplateLoading(HelloWorldFreemarkerstyle.class, "/");
	 
	 Map<String,Object> paramMap = new HashMap<String,Object>();
	 
	 try {
		Template temp = config.getTemplate("home.ftl");
		StringWriter writer  = new StringWriter();
		paramMap.put("name", "srikanth");
		temp.process(paramMap, writer);
		System.out.println(writer);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
