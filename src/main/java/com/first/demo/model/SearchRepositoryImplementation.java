package com.first.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;




@Component
public class SearchRepositoryImplementation implements SearchRepository{
	@Autowired
	MongoClient client;

    @Autowired
    MongoConverter converter;
	  @Override
	    public List<Posti> findtext(String text) {
	        final List<Posti> posts = new ArrayList<>();
	        
	        MongoDatabase database = client.getDatabase("Test");
	        MongoCollection<Document> collection = database.getCollection("Job_Posting");
	        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
	            new Document("index", "default")
	                    .append("text", 
	                    		new Document("query", text)
	                            .append("path", Arrays.asList("desc", "techstack")))),  
	            new Document("$sort", 
	            new Document("exp", 1L)), 
	            new Document("$limit", 4L)));
	        result.forEach(doc -> posts.add(converter.read(Posti.class,doc)));

	        return posts;
	  }


}
