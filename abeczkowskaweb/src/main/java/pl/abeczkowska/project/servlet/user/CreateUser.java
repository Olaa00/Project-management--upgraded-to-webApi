package pl.abeczkowska.project.servlet.user;

import pl.ttpsc.javaupdate.project.model.Role;
import pl.abeczkowska.project.model.Users;
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

@WebServlet(name = "createUser", value = "/create-user")
public class CreateUser extends HttpServlet {
    private iUsersService iusersService;
    public void init() {
        iusersService = new UsersService(new SqlUsersRepository());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Users newUsers = new Users(username, email, password);
        Role userRole = (Role) request.getSession().getAttribute("userRole");

        if (userRole == Role.ADMINISTRATOR) {
            try {
            iusersService.createUser(newUsers);
            request.setAttribute("successMessage", "USER ADDED SUCCESSFULLY.");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "AN ERROR OCCURRED DURING ADDING USER.");
        }} else {
            request.setAttribute("errorMessage", "YOUR ROLE HAS NOT PERMISSION TO PERFORM THIS ACTION");
            request.getRequestDispatcher("/notAllowed.jsp").forward(request, response);
        }

        request.getRequestDispatcher("/addUser.jsp").forward(request, response);
    }
}
