package ru.burmistrov.restClient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.burmistrov.restClient.configuration.SpringConfiguration;
import ru.burmistrov.restClient.controller.AuthController;
import ru.burmistrov.restClient.controller.ProjectController;
import ru.burmistrov.restClient.controller.TaskController;
import ru.burmistrov.restClient.entity.Task;

import java.text.ParseException;

public class AppClient {

    public static void main(String[] args) throws ParseException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AuthController authController = context.getBean(AuthController.class);
        ProjectController projectController = context.getBean(ProjectController.class);
        TaskController taskController = context.getBean(TaskController.class);

        String cookie = authController.auth("admin", "admin");

        //Project
        //Project projectForTest = new Project("test1", "test1");
        //System.out.println(projectController.getProject("f6224e62-b160-463b-8fa4-e7d3103daf1a", cookie));
        //System.out.println(projectController.createProject(projectForTest, cookie));
        //System.out.println(projectController.getTaskList(cookie));
        //Project project = new Project("test123", "test123");
        //project.setId(projectForTest.getId());
        //System.out.println(projectController.updateProject(project, cookie));
        //projectController.deleteProject(projectForTest.getId(), cookie);

        //Task
        //Task taskForCreate = new Task("f6224e62-b160-463b-8fa4-e7d3103daf1a","test1", "test1");
        //System.out.println(taskController.getTaskList("44186ac4-f11a-4c8b-b8fe-1c3e2f03eed0", cookie));
        //System.out.println(taskController.getTask("9ee3e057-c876-4e02-86be-79fc67daa303", cookie));
        //System.out.println(taskController.createTask(taskForCreate, cookie));
        //System.out.println(taskController.updateTask(task, cookie));
        //taskController.deleteTask("2b943b4c-118b-45a2-a044-e00404b872b7", cookie);
    }
}