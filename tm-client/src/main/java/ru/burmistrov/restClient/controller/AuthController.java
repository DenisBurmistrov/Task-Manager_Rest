package ru.burmistrov.restClient.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthController {

    public String auth(@NotNull final String username, @NotNull final String password){
        final String url = "http://localhost:8080/login";
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        map.add("username", username);
        map.add("password", password);

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        HttpHeaders headersResponse = response.getHeaders();
        return headersResponse.getFirst(HttpHeaders.SET_COOKIE);
    }
}
