package pl.abeczkowska.project.servlet.project;

import pl.ttpsc.javaupdate.project.model.Role;
import pl.abeczkowska.project.repository.SqlProjectRepository;
import pl.abeczkowska.project.service.ProjectService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import pl.abeczkowska.project.service.interfaces.iProjectService;

@WebServlet(name = "deleteProject", value = "/delete-project")
public class DeleteProject extends HttpServlet {
    private iProjectService iprojectService;

    public void init() {
        iprojectService = new ProjectService(new SqlProjectRepository());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String projectName = request.getParameter("name");
        Role userRole = (Role) request.getSession().getAttribute("userRole");

        if (userRole != null && userRole == Role.ADMINISTRATOR || userRole == Role.MANAGER) {
            try {
            iprojectService.deleteProject(projectName);
            request.setAttribute("successMessage", "PROJECT DELETED SUCCESSFULLY.");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "AN ERROR OCCURRED DURING DELETING PROJECT.");
        }} else {
            request.setAttribute("errorMessage", "YOUR ROLE HAS NOT PERMISSION TO PERFORM THIS ACTION");
            request.getRequestDispatcher("/notAllowed.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/deleteProject.jsp").forward(request, response);
    }
    }

