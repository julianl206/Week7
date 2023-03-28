package projects.service;

import java.util.List;

import projects.dao.ProjectDao;
import projects.entity.Project;

public class ProjectService {
    private static ProjectDao projectDao = new ProjectDao();

    public static Project addProject(Project project) {
        return projectDao.insertProject(project);
    }

    public List<Project> fetchAllProjects() {
        return projectDao.fetchAllProjects();
    }

    public Project fetchProjectById(Integer projectId) {
        return projectDao.fetchProjectById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
    }
}

