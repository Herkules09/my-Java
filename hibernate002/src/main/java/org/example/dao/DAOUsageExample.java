package org.example.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class DAOUsageExample {
    public static void main(String[] args) {

        ProjectService projectService = new ProjectService(new ProjectDAODB());

        int randId = (new Random()).nextInt(99);
        Project project = new Project("Project Java #"+randId, new Date());
        projectService.persist(project);

        List<Project> projectList = projectService.findAll();
        projectList.stream().forEach(p-> System.out.println(p));

        Project projectFromDB= projectService.findById(projectList.get(0).getId());
        System.out.println("\nProject form DB: "+projectFromDB);

        projectService.delete(projectList.get(0));


    }
}
