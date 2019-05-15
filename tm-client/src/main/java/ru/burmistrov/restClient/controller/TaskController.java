package ru.burmistrov.restClient.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.burmistrov.restClient.entity.Project;
import ru.burmistrov.restClient.entity.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TaskController {

    @Nullable
    public List<Task> getTaskList(String projectId, String cookie) {
        final String url = "http://localhost:8080/task/list/{projectId}";
        @NotNull final HttpHeaders headers = new HttpHeaders();
        @NotNull final RestTemplate restTemplate = new RestTemplate();
        @NotNull final Map<String, String> param = new HashMap<>();

        headers.add("Cookie", cookie);
        param.put("projectId", projectId);

        @NotNull final HttpEntity requestEntity = new HttpEntity(null, headers);
        @NotNull final ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, List.class, param);
        return (List<Task>) response.getBody();
    }

    @Nullable
    public Task getTask(String id, String cookie) {
        final String url = "http://localhost:8080/task/{id}";
        @NotNull final HttpHeaders headers = new HttpHeaders();
        @NotNull final RestTemplate restTemplate = new RestTemplate();
        @NotNull final Map<String, String> param = new HashMap<>();

        headers.add("Cookie", cookie);
        param.put("id", id);

        @NotNull final HttpEntity requestEntity = new HttpEntity(null, headers);
        @NotNull final ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Task.class, param);
        return (Task) response.getBody();
    }

    @Nullable
    public Task createTask(@NotNull final Task task, @NotNull final String cookie) {
        @NotNull final String url = "http://localhost:8080/task";
        @NotNull final HttpHeaders headers = new HttpHeaders();
        @NotNull final RestTemplate restTemplate = new RestTemplate();

        headers.add("Cookie", cookie);

        @NotNull final HttpEntity<Task> request = new HttpEntity<>(task, headers);
        @NotNull final ResponseEntity<Task> response = restTemplate.exchange(url, HttpMethod.POST, request, Task.class);

        return response.getBody();
    }

    @Nullable
    public Task updateTask(@NotNull final Task task, @NotNull final String cookie) {
        @NotNull final String url = "http://localhost:8080/task";
        @NotNull final HttpHeaders headers = new HttpHeaders();
        @NotNull final RestTemplate restTemplate = new RestTemplate();

        headers.add("Cookie", cookie);

        @NotNull final HttpEntity<Task> request = new HttpEntity<>(task, headers);
        @NotNull final ResponseEntity<Task> response = restTemplate.exchange(url, HttpMethod.PUT, request, Task.class);

        return response.getBody();
    }

    @Nullable
    public void deleteTask(String id, String cookie) {
        final String url = "http://localhost:8080/task/remove/{id}";
        @NotNull final HttpHeaders headers = new HttpHeaders();
        @NotNull final RestTemplate restTemplate = new RestTemplate();
        @NotNull final Map<String, String> param = new HashMap<>();

        headers.add("Cookie", cookie);
        param.put("id", id);

        @NotNull final HttpEntity requestEntity = new HttpEntity(null, headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class, param);
    }
}
