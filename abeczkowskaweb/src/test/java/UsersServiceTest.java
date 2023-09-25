import pl.abeczkowska.project.dto.LoginDTO;
import pl.abeczkowska.project.model.UserProjectRelation;
import pl.abeczkowska.project.model.Users;
import pl.abeczkowska.project.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.abeczkowska.project.service.UsersService;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class UsersServiceTest {

    private UsersRepository usersRepository;
    private UsersService usersService;

    @BeforeEach
    public void setUp() {
        usersRepository = mock(UsersRepository.class);
        usersService = new UsersService(usersRepository);
    }

    @Test
    void shouldCreateUser() throws SQLException {
        Users user = new Users();
        user.setUsername("user123");
        user.setEmail("test@o2.pl");
        user.setPassword("pass");

        usersService.createUser(user);

        verify(usersRepository).createUser(user);
    }

    @Test
    void shouldAuthenticateUser() throws SQLException {
       LoginDTO LoginDTO = new LoginDTO("user123", "password123");
        UserProjectRelation expectedUserRelation = new UserProjectRelation();
        expectedUserRelation.setUserId(1);
        expectedUserRelation.setProjectId(2);
        expectedUserRelation.setRoleId(3);

        when(usersRepository.authenticateUsers(LoginDTO)).thenReturn(Optional.of(expectedUserRelation));

        Optional<UserProjectRelation> authenticatedUser = usersService.authenticateUser(LoginDTO);

        assertTrue(authenticatedUser.isPresent());
        assertEquals(expectedUserRelation, authenticatedUser.get());
    }
}