package com.spring.boom.credit.homework.employee;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RandomData {
	
	// @Value("${random.user.data.url}")
	private static String randomUrl = "https://randomuser.me/api/";
	
	private static String buildFullName(JsonNode jsonData) {
		return jsonData.get("title").textValue() + " " 
				+ jsonData.get("first").textValue() + " " 
				+ jsonData.get("last").textValue(); 
	}
	
	public static DummyData getRandomData(String seed) {
		DummyData dummyData = null;
		RestTemplate restTemplate = new RestTemplate();
		String randomUserUrl = RandomData.randomUrl + "/?seed=" + seed + "&nat=us,es,fr,gb&inc=name,gender,email";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(randomUserUrl, String.class);
		if (response.getStatusCode().equals(HttpStatus.OK)) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				JsonNode root = mapper.readTree(response.getBody());
				dummyData = new DummyData(
						RandomData.buildFullName(root.get("results").get(0).get("name")),
						root.get("results").get(0).get("gender").textValue(),
						root.get("results").get(0).get("email").textValue(),
						seed);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return dummyData;
	}

	public static void main(String[] args) {
		DummyData dummyData = RandomData.getRandomData("boom");
		dummyData.debugData();
	}
}
