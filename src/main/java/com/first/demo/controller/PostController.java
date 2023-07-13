package com.first.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.demo.PostRepository;
import com.first.demo.model.Posti;
import com.first.demo.model.SearchRepository;

import springfox.documentation.annotations.ApiIgnore;
@RestController

public class PostController {
	  @Autowired
	    PostRepository repo;
	  @Autowired
	  	SearchRepository srepo;
		@ApiIgnore
	    @RequestMapping(value="/")
	    public void redirect(HttpServletResponse response) throws IOException {
	        response.sendRedirect("/swagger-ui.html");
	    }
		 @GetMapping("/Posts")
		    public List<Posti> getAllPosts(){
		        return repo.findAll();
		    }
		 @GetMapping("/Search/{text}")
		 public List<Posti> search(@PathVariable String text){
			 return srepo.findtext(text);
		 }
		 
		 
		 @PostMapping("/add")
		 public Posti addPost(@RequestBody Posti post)
		    {
		        return repo.save(post);
		    }
		 
		 @DeleteMapping("/posts/{id}")
		 public ResponseEntity<?> deletePostById(@PathVariable String id) {
		     try {
		         repo.deleteById(id);
		         return ResponseEntity.noContent().build();
		     } catch (Exception e) {
		         return ResponseEntity.notFound().build();
		     }
		 }
		 
		
}
