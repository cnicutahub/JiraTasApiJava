package app.controllers;

import com.sun.deploy.net.HttpResponse;
import com.sun.xml.internal.messaging.saaj.util.Base64;
import org.springframework.http.*;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

    @PostMapping("/rest/auth/1/session")
    public String welcome(@RequestHeader(value = "Authorization") String authorization){

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://uatjira.endava.com/rest/auth/1/session";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", authorization);
        httpHeaders.add("Content-Type", "application/json");

//        String credentials = username + ":" + password;
//        String auth = (String)Base64.encode(credentials.getBytes());

        HttpEntity<String> request = new HttpEntity<String>(httpHeaders);
        //String resp = restTemplate.exchange(url, HttpMethod.POST, request, String.class).getBody();

        restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        return "wasd";
    }
}