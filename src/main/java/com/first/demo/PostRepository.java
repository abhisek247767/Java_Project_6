package com.first.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.first.demo.model.Posti;

public interface PostRepository extends MongoRepository<Posti,String>
{

}
