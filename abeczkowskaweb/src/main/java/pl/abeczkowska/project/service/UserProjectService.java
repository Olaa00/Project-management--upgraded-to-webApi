package pl.abeczkowska.project.service;

import pl.abeczkowska.project.repository.UserProjectRepository;
import pl.abeczkowska.project.service.interfaces.iUserProjectService;
import pl.abeczkowska.project.model.Project;
import pl.abeczkowska.project.model.UserProjectRelation;

import java.sql.SQLException;
import java.util.List;

public class UserProjectService implements iUserProjectService {
    private final UserProjectRepository userProjectRepository;

    public UserProjectService(UserProjectRepository userProjectRepository) {
        this.userProjectRepository = userProjectRepository;
    }

    @Override
    public void assignUserRole(UserProjectRelation userProjectRelation) throws SQLException {
        userProjectRepository.assignUserRole(userProjectRelation);
    }

    @Override
    public List<Project> getProjectsForUserByUsername(String username) throws SQLException {
        return userProjectRepository.getProjectsForUserByUsername(username);
    }

    @Override
    public List<UserProjectRelation> getProjectDetails(String projectName) throws SQLException {
        return userProjectRepository.getProjectDetails(projectName);
    }

    @Override
    public UserProjectRelation getDocumentDetails(String documentName) throws SQLException {
        return userProjectRepository.getDocumentDetails(documentName);
    }
}
