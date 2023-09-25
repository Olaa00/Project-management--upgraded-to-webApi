package pl.abeczkowska.project.service;

import pl.abeczkowska.project.repository.ProjectRepository;
import pl.abeczkowska.project.service.interfaces.iProjectService;
import pl.abeczkowska.project.model.Project;

import java.sql.SQLException;
import java.util.List;

public class ProjectService implements iProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void createProject(Project project) throws SQLException {
        projectRepository.createProject(project);
    }

    @Override
    public void deleteProject(String projectName) throws SQLException {
        projectRepository.deleteProject(projectName);
    }

    @Override
    public List<Project> getAllProjects() throws SQLException {
        return projectRepository.getAllProjects();
    }
}
