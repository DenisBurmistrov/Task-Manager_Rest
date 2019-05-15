package ru.burmistrov.restClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.burmistrov.restClient.configuration.SpringConfiguration;
import ru.burmistrov.restClient.controller.AuthController;
import ru.burmistrov.restClient.controller.ProjectController;
import ru.burmistrov.restClient.entity.Project;

import java.text.ParseException;

public class AppClient {

    private static String cookie;

    public static void main(String[] args) throws ParseException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AuthController authController = context.getBean(AuthController.class);
        ProjectController projectController = context.getBean(ProjectController.class);

        cookie = authController.auth("admin", "admin");

        //Project
        //System.out.println(projectController.getProject("f6224e62-b160-463b-8fa4-e7d3103daf1a", cookie));
        //System.out.println(projectController.createProject(new Project("test", "test"), cookie));
        //System.out.println(projectController.getProjectList(cookie));
        //Project project = new Project("test123", "test123");
        //project.setId("cd67bce6-6e1b-4959-abd3-23c945cc408b");
        //System.out.println(projectController.updateProject(project, cookie));
        //projectController.deleteProject("cd67bce6-6e1b-4959-abd3-23c945cc408b", cookie);
    }
}
