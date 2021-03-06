package com.externalapi.app.ws.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import com.externalapi.app.ws.dbutil.DBUtil;
import com.externalapi.app.ws.model.Merchant;
import com.externalapi.app.ws.model.Product;
import com.externalapi.app.ws.repository.MerchantRepository;
import com.externalapi.app.ws.repository.ProductRepository;

@RestController
public class ApiController {
	
	@Autowired
	MerchantRepository merchantRepository;
	
	 private final RestTemplate restTemplate;
	 
	 public ApiController(RestTemplateBuilder restTemplateBuilder) {
	        this.restTemplate = restTemplateBuilder.build();
	    }
	 
	 
	 @PostMapping(value="/createProduct")
		public String createPost() {
		    //String url = "https://reqres.in/api/users/";
		    String url = "https://shoppingcontent.googleapis.com/content/v2.1/{merchantId}/products";

		    // create headers
		    HttpHeaders headers = new HttpHeaders();
		    // set `content-type` header
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    // set `accept` header
		    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		    // create a map for post parameters
		    Map<String, Object> map = new HashMap<>();
		    // build the request
		    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		    System.out.println(entity);
		    // send POST request
		    ResponseEntity<String> response = this.restTemplate.postForEntity(url, entity, String.class, MerchantRepository.findId());
		    System.out.println(response);
		    System.out.println(response.getBody());
		    // check response status code
		    //if (response.getStatusCode() == HttpStatus.CREATED) {
		      //  return response.getBody();
		    //} else {
		     //   return null;
		    //}
		    //return response.getBody();
		    return response.getBody();
		    
		}
	 
		@GetMapping(value="/getProduct")
		private String getmerchant() {
			String url = "https://shoppingcontent.googleapis.com/content/v2.1/{merchantId}/products/{productId}";
			//String url = "https://reqres.in/api/users/{id}";
			String response = null;
			RestTemplate restTemplate = new RestTemplate();
			response = restTemplate.getForObject(url, String.class,MerchantRepository.findId());
			return response;
		}
		
		 @PatchMapping(value="/updateProduct")
		 public String update() {
			 //String url = "https://reqres.in/api/users/{id}";
			 String url = "https://shoppingcontent.googleapis.com/content/v2.1/{merchantId}/products/{productId}";
			 HttpHeaders headers = new HttpHeaders();
			 headers.setContentType(MediaType.APPLICATION_JSON);
			 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			 Map<String, Object> map = new HashMap<>();
			 HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
			 String response = restTemplate.patchForObject(url, entity, String.class, MerchantRepository.findId(), ProductRepository.findId());
			 return response;
		 }
		 
		 @DeleteMapping(value="/deleteProduct")
		 public void delete() {
			 //String url = "https://reqres.in/api/users/{id}";
			 String url = "https://shoppingcontent.googleapis.com/content/v2.1/{merchantId}/products/{productId}";
			 HttpHeaders headers = new HttpHeaders();
			 headers.setContentType(MediaType.APPLICATION_JSON);
			 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			 Map<String, Object> map = new HashMap<>();
			 HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
			 restTemplate.delete(url, MerchantRepository.findId(), ProductRepository.findId());
		 }

}
