package pl.abeczkowska.project.service;

import pl.abeczkowska.project.repository.UsersRepository;
import pl.abeczkowska.project.service.interfaces.iUsersService;
import pl.abeczkowska.project.dto.LoginDTO;
import pl.abeczkowska.project.model.UserProjectRelation;
import pl.abeczkowska.project.model.Users;

import java.sql.SQLException;
import java.util.Optional;

public class UsersService implements iUsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void createUser(Users users) throws SQLException {
        usersRepository.createUser(users);
    }

    @Override
    public Optional<UserProjectRelation> authenticateUser(LoginDTO loginDTO) throws SQLException {
        return usersRepository.authenticateUsers(loginDTO);
    }
}
