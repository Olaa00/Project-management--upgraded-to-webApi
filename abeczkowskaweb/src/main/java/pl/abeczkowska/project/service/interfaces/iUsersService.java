package pl.abeczkowska.project.service.interfaces;

import pl.abeczkowska.project.dto.LoginDTO;
import pl.abeczkowska.project.model.UserProjectRelation;
import pl.abeczkowska.project.model.Users;

import java.sql.SQLException;
import java.util.Optional;

public interface iUsersService {
    void createUser(Users users) throws SQLException;
    Optional<UserProjectRelation> authenticateUser(LoginDTO loginDTO) throws SQLException;
}
