package pl.abeczkowska.project.servlet.document;

import pl.abeczkowska.project.model.Document;
import pl.ttpsc.javaupdate.project.model.Role;
import pl.abeczkowska.project.repository.SqlDocumentRepository;
import pl.abeczkowska.project.service.DocumentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.abeczkowska.project.service.interfaces.iDocumentService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "createDocument", value = "/create-document")
public class CreateDocument extends HttpServlet {
    private iDocumentService idocumentService;

    public void init() {
        idocumentService = new DocumentService(new SqlDocumentRepository());
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String creator = request.getParameter("creator");
        String topic = request.getParameter("topic");
        String content = request.getParameter("content");
        String projectIDParam = request.getParameter("project_id");
        int projectID = Integer.parseInt(projectIDParam);

        Document newDocument = new Document(title, description, creator, topic, content, projectID);
        Role userRole = (Role) request.getSession().getAttribute("userRole");
        if (userRole != null && userRole == Role.MANAGER || userRole == Role.ENGINEER) {
            try {
                idocumentService.createDocument(newDocument);
                request.setAttribute("successMessage", "DOCUMENT ADDED SUCCESSFULLY.");
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "AN ERROR OCCURRED DURING ADDING DOCUMENT.");
            }  } else {
            request.setAttribute("errorMessage", "YOUR ROLE HAS NOT PERMISSION TO PERFORM THIS ACTION");
            request.getRequestDispatcher("/notAllowed.jsp").forward(request, response);
        }
            request.getRequestDispatcher("/addDocument.jsp").forward(request, response);
        }
    }
