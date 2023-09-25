<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Choose Document to Edit</title>
</head>
<body>
<h2>Choose Document to Edit</h2>
<% String error = request.getParameter("error");
    if (error != null) { %>
<p style="color: red;"><%= error %></p>
<% } %>
<form action="edit-document" method="get">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br><br>
    <input type="SUBMIT" value="EDIT DOCUMENT">
</form>
</body>
</html>
