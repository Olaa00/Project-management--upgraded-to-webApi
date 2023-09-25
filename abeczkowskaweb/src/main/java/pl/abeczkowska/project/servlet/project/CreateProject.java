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
import pl.abeczkowska.project.service.interfaces.iProjectService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "createProject", value = "/create-project")
public class CreateProject extends HttpServlet {
    private iProjectService iprojectService;

    public void init() {
        iprojectService = new ProjectService(new SqlProjectRepository());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String creator = request.getParameter("creator");
        Project newProject = new Project(name, description, creator);
        Role userRole = (Role) request.getSession().getAttribute("userRole");

        if (userRole != null && userRole == Role.ADMINISTRATOR) {
            try {
                iprojectService.createProject(newProject);
                request.setAttribute("successMessage", "PROJECTS ADDED SUCCESSFULLY..");
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "AN ERROR OCCURRED DURING ADDING NEW PROJECT.");
            }} else {
            request.setAttribute("errorMessage", "YOUR ROLE HAS NOT PERMISSION TO PERFORM THIS ACTION");
            request.getRequestDispatcher("/notAllowed.jsp").forward(request, response);
        }
            request.getRequestDispatcher("/addProject.jsp").forward(request, response);
        }
    }

