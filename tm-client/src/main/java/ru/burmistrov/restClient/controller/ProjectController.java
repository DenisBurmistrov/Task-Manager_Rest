package ru.burmistrov.restClient.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ru.burmistrov.restClient.entity.Project;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProjectController {

    public Project getProject(String id, String cookie) {
        final String url = "http://localhost:8080/project/{id}";
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> param = new HashMap<>();

        headers.add("Cookie", cookie);
        param.put("id", id);

        HttpEntity requestEntity = new HttpEntity(null, headers);
        ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Project.class, param);
        return (Project) response.getBody();

    }
}
