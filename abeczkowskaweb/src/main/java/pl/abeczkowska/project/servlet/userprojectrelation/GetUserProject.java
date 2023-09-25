package pl.abeczkowska.project.servlet.userprojectrelation;

import pl.abeczkowska.project.model.Project;
import pl.ttpsc.javaupdate.project.model.Role;
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
import java.util.List;

@WebServlet(name = "getUserProjects", value = "/get-user-project")
public class GetUserProject extends HttpServlet {
    private iUserProjectService iuserProjectService;

    public void init() {
        iuserProjectService = new UserProjectService(new SqlUserProjectRepository());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/getProjectsForUser.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Role userRole = (Role) request.getSession().getAttribute("userRole");

        if (userRole != null && userRole == Role.ADMINISTRATOR || userRole == Role.MANAGER ||
                userRole == Role.ENGINEER || userRole == Role.HR) {
            try {
                List<Project> projects = iuserProjectService.getProjectsForUserByUsername(username);
                request.setAttribute("projects", projects);
                request.getRequestDispatcher("/showProjectsForUser.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
        request.setAttribute("errorMessage", "YOUR ROLE HAS NOT PERMISSION TO PERFORM THIS ACTION.");
        request.getRequestDispatcher("/notAllowed.jsp").forward(request, response);
    }
    }}
