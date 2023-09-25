<%@ page import="pl.abeczkowska.project.model.Project" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Projects by User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .container h2 {
            color: #333;
            margin-bottom: 10px;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            margin-bottom: 10px;
        }

        .back-button {
            margin-top: 20px;
        }

        .back-button button {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .back-button button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Projects for User</h2>
    <% List<Project> projects = (List<Project>) request.getAttribute("projects");
        if (projects != null && !projects.isEmpty()) { %>
    <ul>
        <% for (Project project : projects) { %>
        <li><strong>Name:</strong> <%= project.getName() %>, <strong>Description:</strong> <%= project.getDescription() %>, <strong>Creator:</strong> <%= project.getCreator() %></li>
        <% } %>
    </ul>
    <% } else { %>
    <p>No projects found.</p>
    <% } %>
    <form class="back-button" action="initPage.jsp">
        <button type="submit">Back</button>
    </form>
</div>
</body>
</html>
