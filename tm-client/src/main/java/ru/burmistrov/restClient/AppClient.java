package ru.burmistrov.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.burmistrov.restClient.configuration.SpringConfiguration;
import ru.burmistrov.restClient.controller.AuthController;
import ru.burmistrov.restClient.controller.ProjectController;

public class AppClient {

    private static String cookie;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AuthController authController = context.getBean(AuthController.class);
        ProjectController projectController = context.getBean(ProjectController.class);

        cookie = authController.auth("admin", "admin");

        System.out.println(projectController.getProject("f6224e62-b160-463b-8fa4-e7d3103daf1a", cookie));
    }
}
