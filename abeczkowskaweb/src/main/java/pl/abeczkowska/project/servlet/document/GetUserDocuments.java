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
import java.util.List;

@WebServlet(name = "getUserDocuments", value = "/get-user-documents")
public class GetUserDocuments extends HttpServlet {
    private iDocumentService idocumentService;

    public void init() {
        idocumentService = new DocumentService(new SqlDocumentRepository());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/getUserDocuments.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Role userRole = (Role) request.getSession().getAttribute("userRole");

        if (userRole == Role.MANAGER || userRole == Role.ENGINEER || userRole == Role.HR) {
            try {
                List<Document> documents = idocumentService.showDocumentsForUser(username);
                request.setAttribute("documents", documents);
                request.getRequestDispatcher("/showDocumentsForUser.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            request.setAttribute("errorMessage", "YOUR ROLE HAS NOT PERMISSION TO PERFORM THIS ACTION");
            request.getRequestDispatcher("/notAllowed.jsp").forward(request, response);
        }
    }
}
