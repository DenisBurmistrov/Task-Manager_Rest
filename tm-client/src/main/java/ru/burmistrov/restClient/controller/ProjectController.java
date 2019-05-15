package ru.burmistrov.restClient.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.burmistrov.restClient.entity.Project;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Component
public class ProjectController {

    @Nullable
    public List<Project> getProjectList(String cookie) {
        final String url = "http://localhost:8080/project/list";
        @NotNull final HttpHeaders headers = new HttpHeaders();
        @NotNull final RestTemplate restTemplate = new RestTemplate();

        headers.add("Cookie", cookie);

        @NotNull final HttpEntity requestEntity = new HttpEntity(null, headers);
        @NotNull final ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, List.class);
        return (List<Project>) response.getBody();
    }

    @Nullable
    public Project getProject(String id, String cookie) {
        final String url = "http://localhost:8080/project/{id}";
        @NotNull final HttpHeaders headers = new HttpHeaders();
        @NotNull final RestTemplate restTemplate = new RestTemplate();
        @NotNull final Map<String, String> param = new HashMap<>();

        headers.add("Cookie", cookie);
        param.put("id", id);

        @NotNull final HttpEntity requestEntity = new HttpEntity(null, headers);
        @NotNull final ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Project.class, param);
        return (Project) response.getBody();
    }

    @Nullable
    public Project createProject(@NotNull final Project project, @NotNull final String cookie) {
        @NotNull final String url = "http://localhost:8080/project";
        @NotNull final HttpHeaders headers = new HttpHeaders();
        @NotNull final RestTemplate restTemplate = new RestTemplate();

        headers.add("Cookie", cookie);

        @NotNull final HttpEntity<Project> request = new HttpEntity<>(project, headers);
        @NotNull final ResponseEntity<Project> response = restTemplate.exchange(url, HttpMethod.POST, request, Project.class);

        return response.getBody();
    }

    @Nullable
    public Project updateProject(@NotNull final Project project, @NotNull final String cookie) {
        @NotNull final String url = "http://localhost:8080/project";
        @NotNull final HttpHeaders headers = new HttpHeaders();
        @NotNull final RestTemplate restTemplate = new RestTemplate();

        headers.add("Cookie", cookie);

        @NotNull final HttpEntity<Project> request = new HttpEntity<>(project, headers);
        @NotNull final ResponseEntity<Project> response = restTemplate.exchange(url, HttpMethod.PUT, request, Project.class);

        return response.getBody();
    }

    @Nullable
    public void deleteProject(String id, String cookie) {
        final String url = "http://localhost:8080/project/remove/{id}";
        @NotNull final HttpHeaders headers = new HttpHeaders();
        @NotNull final RestTemplate restTemplate = new RestTemplate();
        @NotNull final Map<String, String> param = new HashMap<>();

        headers.add("Cookie", cookie);
        param.put("id", id);

        @NotNull final HttpEntity requestEntity = new HttpEntity(null, headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class, param);
    }
}
