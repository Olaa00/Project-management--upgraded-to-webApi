package pl.abeczkowska.project.servlet.userprojectrelation;

import pl.abeczkowska.project.repository.SqlUserProjectRepository;
import pl.ttpsc.javaupdate.project.model.Role;
import pl.abeczkowska.project.model.UserProjectRelation;
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

@WebServlet(name = "getProjectDetails", value = "/get-project-details")
public class GetProjectDetails extends HttpServlet {
    private iUserProjectService iuserProjectService;

    public void init() {
        iuserProjectService = new UserProjectService(new SqlUserProjectRepository());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/getProjectDetails.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String projectName = request.getParameter("projectName");
        Role userRole = (Role) request.getSession().getAttribute("userRole");

        if (userRole != null && userRole == Role.ADMINISTRATOR || userRole == Role.MANAGER) {
            try {
            List<UserProjectRelation> projectDetails = iuserProjectService.getProjectDetails(projectName);
            request.setAttribute("projectDetails", projectDetails);
            request.getRequestDispatcher("/showProjectDetails.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    } else {
        request.setAttribute("errorMessage", "YOUR ROLE HAS NOT PERMISSION TO PERFORM THIS ACTION.");
        request.getRequestDispatcher("/notAllowed.jsp").forward(request, response);
    }
}}

