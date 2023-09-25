package pl.abeczkowska.project.servlet.document;

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

@WebServlet(name = "deleteDocument", value = "/delete-document")
public class DeleteDocument extends HttpServlet {
    private iDocumentService idocumentService;

    public void init() {
        idocumentService = new DocumentService(new SqlDocumentRepository());
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        Role userRole = (Role) request.getSession().getAttribute("userRole");
        if (userRole != null && userRole == Role.MANAGER) {
            try {
            idocumentService.deleteDocument(title);
            request.setAttribute("successMessage", "DOCUMENT DELETED SUCCESSFULLY.");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "AN ERROR OCCURRED DURING DELETING DOCUMENT.");
        }} else {
            request.setAttribute("errorMessage", "YOUR ROLE HAS NOT PERMISSION TO PERFORM THIS ACTION");
            request.getRequestDispatcher("/notAllowed.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/deleteDocument.jsp").forward(request, response);
    }
}

