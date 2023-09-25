package pl.abeczkowska.project.repository;

import pl.abeczkowska.project.dto.LoginDTO;
import pl.ttpsc.javaupdate.project.model.Role;
import pl.abeczkowska.project.model.UserProjectRelation;
import pl.abeczkowska.project.model.Users;
import pl.abeczkowska.project.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Optional;

public class SqlUsersRepository implements UsersRepository{

    public SqlUsersRepository() {
    }

    @Override
    public void createUser(Users users) throws SQLException {
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, users.getUsername());
            preparedStatement.setString(2, users.getEmail());
            preparedStatement.setString(3, users.getPassword());

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Optional<UserProjectRelation> authenticateUsers(LoginDTO LoginDTO) throws SQLException {
        String query = "SELECT upr.user_id, upr.project_id, upr.role_id " +
                "FROM userprojectrelation upr " +
                "JOIN users u ON u.id = upr.user_id " +
                "WHERE u.username = ? AND u.password = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, LoginDTO.username());
            preparedStatement.setString(2, LoginDTO.password());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    UserProjectRelation userProjectRelation = new UserProjectRelation();
                    userProjectRelation.setUserId(resultSet.getInt("user_id"));
                    userProjectRelation.setProjectId(resultSet.getInt("project_id"));
                    userProjectRelation.setRoles(Collections.singletonList(Role.values()[resultSet.getInt("role_id") - 1]));

                    return Optional.of(userProjectRelation);
                }
            }
        }
        return Optional.empty();
    }
}
