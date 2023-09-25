package pl.abeczkowska.project.servlet.project;

import pl.abeczkowska.project.model.Project;
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
import java.util.List;
import pl.abeczkowska.project.service.interfaces.iProjectService;

@WebServlet(name = "getAllProjects", value = "/get-all-projects")
public class GetAllProjects extends HttpServlet {
    private iProjectService iprojectService;

    public void init() {
        iprojectService = new ProjectService(new SqlProjectRepository());
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Role userRole = (Role) request.getSession().getAttribute("userRole");

        if ( userRole == Role.ADMINISTRATOR) {
            try {
                List<Project> projects = iprojectService.getAllProjects();
                request.setAttribute("projects", projects);
                request.getRequestDispatcher("getAllProjects.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            request.setAttribute("errorMessage", "YOUR ROLE HAS NOT PERMISSION TO PERFORM THIS ACTION");
            request.getRequestDispatcher("/notAllowed.jsp").forward(request, response);
        }


    }}