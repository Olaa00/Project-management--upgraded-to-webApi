package pl.abeczkowska.project.repository;

import pl.abeczkowska.project.dto.LoginDTO;
import pl.abeczkowska.project.model.UserProjectRelation;
import pl.abeczkowska.project.model.Users;

import java.sql.SQLException;
import java.util.Optional;

public interface UsersRepository {
    void createUser(Users users) throws SQLException;
    Optional<UserProjectRelation> authenticateUsers(LoginDTO loginDTO) throws SQLException;

}
