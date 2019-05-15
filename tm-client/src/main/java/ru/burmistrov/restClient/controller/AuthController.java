package ru.burmistrov.restClient.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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

    @Nullable
    public String auth(@NotNull final String username, @NotNull final String password){
        @NotNull final String url = "http://localhost:8080/login";
        @NotNull final HttpHeaders headers = new HttpHeaders();
        @NotNull final RestTemplate restTemplate = new RestTemplate();
        @NotNull final MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        @NotNull final HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        map.add("username", username);
        map.add("password", password);

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        @NotNull final ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        HttpHeaders headersResponse = response.getHeaders();
        return headersResponse.getFirst(HttpHeaders.SET_COOKIE);
    }
}
