package com.mongodb.crud;

import static com.mongodb.client.model.Projections.include;

import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class DocumentTest {

	
	public static void main(String[] args) {
		
		MongoClient cl = new MongoClient();
		MongoDatabase db = cl.getDatabase("test");
		MongoCollection<Document> c = db.getCollection("test");
		
		Document d = new Document("date",new Date());
		c.insertOne(d);
		cl.close();
		
	}
	
	static void assment3_1()
	{

		
		
		MongoClient cl = new MongoClient();
		MongoDatabase db = cl.getDatabase("school");
		MongoCollection<Document> c = db.getCollection("students");
		

	ArrayList<Document> fi = c.find().projection(include("scores")).into(new ArrayList<Document>());



	for(Document d: fi)
	{
		ArrayList<Document> ai = d.get("scores", ArrayList.class);
		double min=0 ;
		int minIndex= -1;
		for(int i = 0;i<ai.size();i++)
		{
			Document di = ai.get(i);
			if(di.getString("type").equals("homework"))
			{
				if(minIndex== -1) {
					min = di.getDouble("score");
					minIndex = i;
				}
				else if(min > di.getDouble("score"))
				{
					min = di.getDouble("score");
					minIndex = i;
				}
				
				
			}
			
		}
		System.out.println("minimum index found at place "+minIndex);
		System.out.println("minimum score is "+ai.get(minIndex).getDouble("score"));
		ai.remove(minIndex);
		c.updateOne(Filters.eq("_id",d.get("_id")), Updates.set("scores", ai));
	}

	/*MongoCursor<Document> cursor = fi.iterator();
		while(cursor.hasNext())
		{
			System.out.println(cursor.next());
		}
		cursor.close();
	*/	cl.close();
		
			
		
	}
}
