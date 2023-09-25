package pl.abeczkowska.project.service.interfaces;

import pl.abeczkowska.project.model.Project;

import java.sql.SQLException;
import java.util.List;

public interface iProjectService {
    void createProject(Project project) throws SQLException;
    void deleteProject(String projectName) throws SQLException;
    List<Project> getAllProjects() throws SQLException;
}
