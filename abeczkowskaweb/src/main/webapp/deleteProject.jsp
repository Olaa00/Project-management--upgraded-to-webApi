<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Project</title>
</head>
<body>
<h2>Delete Project</h2>
<form action="delete-project" method="post">
    <label for="name">Project name:</label>
    <input type="text" id="name" name="name" required><br><br>
    <input type="SUBMIT" value="DELETE SELECTED PROJECT">
</form>
<form action="initPage.jsp">
    <button style="margin-top: 5px" type="submit">BACK</button>
</form>
<div class="message-container">
    <% if (request.getAttribute("successMessage") != null) { %>
    <p class="success-message"><%= request.getAttribute("successMessage") %></p>
    <% } else if (request.getAttribute("errorMessage") != null) { %>
    <p class="error-message"><%= request.getAttribute("errorMessage") %></p>
    <% } %>
</div>

</body>
</html>