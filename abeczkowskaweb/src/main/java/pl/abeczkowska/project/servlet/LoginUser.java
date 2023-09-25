package pl.abeczkowska.project.servlet;

import pl.abeczkowska.project.dto.LoginDTO;
import pl.abeczkowska.project.model.UserProjectRelation;
import pl.abeczkowska.project.repository.SqlUsersRepository;
import pl.abeczkowska.project.service.UsersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.abeczkowska.project.service.interfaces.iUsersService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginUser extends HttpServlet {
    private iUsersService iusersService;
    public void init() {
        iusersService = new UsersService(new SqlUsersRepository());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginDTO loginDTO = new LoginDTO(username, password);
        try {
            Optional<UserProjectRelation> user = iusersService.authenticateUser(loginDTO);

            if (user.isPresent()) {
                request.getSession().setAttribute("userRole", user.get().getRoles().get(0));
                response.sendRedirect(request.getContextPath() + "/initPage.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } catch (SQLException e) {

            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
    public void destroy() {

    }
}
