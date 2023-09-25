package pl.abeczkowska.project.servlet.document;

import pl.abeczkowska.project.model.Document;
import pl.ttpsc.javaupdate.project.model.Role;
import pl.abeczkowska.project.repository.SqlDocumentRepository;
import pl.abeczkowska.project.service.DocumentService;
import pl.abeczkowska.project.service.interfaces.iDocumentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "editDocumentServlet", value = "/edit-document")
public class EditDocumentServlet extends HttpServlet {
    private iDocumentService idocumentService;

    public void init() {
        idocumentService = new DocumentService(new SqlDocumentRepository());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");

        try {
            Document document = idocumentService.getDocumentByTitle(title);
            if (document != null) {
                request.setAttribute("document", document);
                request.getRequestDispatcher("/editDocument.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/chooseDocument.jsp?error=DOCUMENT NOT FOUND");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/chooseDocument.jsp?error=DATABASE ERROR!");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String creator = request.getParameter("creator");
        String topic = request.getParameter("topic");
        String content = request.getParameter("content");
        int projectId = Integer.parseInt(request.getParameter("project_id"));

        Document updatedDocument = new Document(title, description, creator, topic, content, projectId);

        Role userRole = (Role) request.getSession().getAttribute("userRole");

        if (userRole != null && userRole == Role.MANAGER || userRole == Role.ENGINEER) {
            try {
                idocumentService.editDocument(updatedDocument);
                request.setAttribute("successMessage", "DOCUMENT EDITED SUCCESSFULLY.");
            } catch (SQLException e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "AN ERROR OCCURRED DURING EDITING DOCUMENT.");
            }} else {
            request.setAttribute("errorMessage", "YOUR ROLE HAS NOT PERMISSION TO PERFORM THIS ACTION");
            request.getRequestDispatcher("/notAllowed.jsp").forward(request, response);
        }
            request.getRequestDispatcher("/editDocument.jsp").forward(request, response);
        }
    }



