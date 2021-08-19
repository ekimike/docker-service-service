package com.example.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.net.UnknownHostException;

@SpringBootApplication
@RestController
@Slf4j
public class FrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontendApplication.class, args);
	}

  @GetMapping("/")
  public String helloWorld() throws UnknownHostException {
    log.info("calling frontend controller ");
    RestTemplate rt = null;new RestTemplate();
    ResponseEntity<String> response = null;
    
    try {
      rt = new RestTemplate();
      //String resource = "http://backend-service:8080";
      String resource = "http://host.docker.internal:8080";
      response = rt.getForEntity(resource, String.class);
    } catch (Exception e) {
      System.out.println("Error pe: " + e.getMessage());
    }
    return "MESSAGE: " + response.getBody();
  }
}
