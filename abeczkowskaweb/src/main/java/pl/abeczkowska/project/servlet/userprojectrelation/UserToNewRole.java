package pl.abeczkowska.project.servlet.userprojectrelation;

import pl.ttpsc.javaupdate.project.model.Role;
import pl.abeczkowska.project.model.UserProjectRelation;
import pl.abeczkowska.project.repository.SqlUserProjectRepository;
import pl.abeczkowska.project.service.UserProjectService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.abeczkowska.project.service.interfaces.iUserProjectService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddUserToNewRole", value = "/new-role")
public class UserToNewRole extends HttpServlet {
    private iUserProjectService iuserProjectRelationService;

    public void init() {
        iuserProjectRelationService =
                new UserProjectService(new SqlUserProjectRepository());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        int projectId = Integer.parseInt(request.getParameter("project_id"));
        int roleId = Integer.parseInt(request.getParameter("role_id"));

        UserProjectRelation newUserProjectRelation = new UserProjectRelation(userId, projectId, roleId);
        Role userRole = (Role) request.getSession().getAttribute("userRole");

        if (userRole != null && userRole == Role.ADMINISTRATOR || userRole == Role.MANAGER) {
            try {
                iuserProjectRelationService.assignUserRole(newUserProjectRelation);
                request.setAttribute("successMessage", "NEW ROLE ADDED SUCCESSFULLY.");
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "AN ERROR OCCURRED DURING ADDING NEW ROLE.");
            } } else {
            request.setAttribute("errorMessage", "YOUR ROLE HAS NOT PERMISSION TO PERFORM THIS ACTION.");
            request.getRequestDispatcher("/notAllowed.jsp").forward(request, response);
        }
            request.getRequestDispatcher("/assignNewRole.jsp").forward(request, response);
        }
    }

