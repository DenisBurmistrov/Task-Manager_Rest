package ru.burmistrov.restTM.client;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import ru.burmistrov.restTM.entity.dto.ProjectDto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ProjectControllerClient {

    private static void getList(RestTemplate restTemplate) {
        auth();
        final String url = "http://localhost:8080/project/{id}";

        Map<String, String> params = new HashMap<>();
        params.put("id", "f6224e62-b160-463b-8fa4-e7d3103daf1a");
        System.out.println(restTemplate.getForObject(url, String.class, params));
    }

    private static String auth(){
        final String url = "http://localhost:8080/login";

        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        map.add("username", "admin");
        map.add("password", "admin");
        RestTemplate restTemplate = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        System.out.println(response);
        HttpHeaders headersResponse = response.getHeaders();
        String set_cookie = headersResponse.getFirst(HttpHeaders.SET_COOKIE);
        System.out.println(set_cookie);
        String session = set_cookie.replaceFirst(".*?SESSION=(.+).*?", "$1");

        System.out.println(session);
        return set_cookie;
    }

    public static void main(String[] args) {
        auth();
    }
}
