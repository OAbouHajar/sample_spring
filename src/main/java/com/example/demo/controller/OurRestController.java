package com.example.demo.controller;

import com.example.demo.model.Car;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.http.HttpClient;

@RestController
public class OurRestController {


    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Audi") String name) {
        return "Hello + " + name;
    }

    @GetMapping("/mycar")
    public Car mycar(@RequestParam(value = "name", defaultValue = "Audi") String name){
        return new Car(2011, name);
    }

    @GetMapping("/moto")
    public ResponseEntity moto(){
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                .body("{age:28}");
    }

    @GetMapping("/redirect")
    public ResponseEntity redirect(){
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).contentType(MediaType.TEXT_HTML)
                .body("https://reflectoring.io/spring-boot-health-check/");
    }

//    @GetMapping("/all")
//    public ResponseEntity all() throws IOException {
//        URL url = new URL("http://localhost:8080/moto");
//        HttpURLConnection http = (HttpURLConnection)url.openConnection();
//        http.setRequestProperty("Accept", "application/json");
//        JSONParser parse = new JSONParser();
//        JSONObject data_obj = (JSONObject) parse.parse(http.getContent().toString());
//
//        System.out.println(http.getResponseCode() + " " + http.getContent());
//
//        http.disconnect();
//
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
//                .body("test");
//
//    }

}
