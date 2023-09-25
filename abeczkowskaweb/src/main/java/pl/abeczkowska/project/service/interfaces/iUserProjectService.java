package pl.abeczkowska.project.service.interfaces;

import pl.abeczkowska.project.model.Project;
import pl.abeczkowska.project.model.UserProjectRelation;

import java.sql.SQLException;
import java.util.List;

public interface iUserProjectService {
    void assignUserRole( UserProjectRelation userProjectRelation) throws SQLException;
    List<Project> getProjectsForUserByUsername(String username) throws SQLException;
    List<UserProjectRelation> getProjectDetails(String projectName) throws SQLException;
    UserProjectRelation getDocumentDetails(String documentName) throws SQLException;
}
