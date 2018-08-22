package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/search/client")
public class HolaResource {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	@RequestMapping("/{id}")
	public String search(@PathVariable("id") String id) {
		System.out.println("hola: " + id);
		String url ="http://BASTARRACHEACJAVA-SERVER/rest/search/server/" + id;
		//String url ="http://localhost:8071/rest/hola/server";
		return restTemplate.getForObject(url,String.class);
	}
}
