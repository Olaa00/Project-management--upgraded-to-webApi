<%@ page import="pl.abeczkowska.project.model.UserProjectRelation" %>
<%@ page import="java.util.List" %>
<%@ page import="pl.abeczkowska.project.model.Document" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User's documents</title>
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

        .container ul {
            list-style-type: none;
            padding: 0;
        }

        .container li {
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
            padding: 10px;
        }

        .container li strong {
            color: #555;
        }

        .container p {
            color: #555;
            margin: 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>User's documents</h2>
    <% List<Document> documents = (List<Document>) request.getAttribute("documents");
        if (documents != null && !documents.isEmpty()) { %>
    <ul>
        <% for (Document document : documents) { %>
        <li>
            <strong>Title:</strong> <%= document.getTitle() %>,<br>
            <strong>Description:</strong> <%= document.getDescription() %>,<br>
            <strong>Creator:</strong> <%= document.getCreator() %>,<br>
            <strong>Topic:</strong> <%= document.getTopic() %>,<br>
            <strong>Project ID:</strong> <%= document.getProjectId() %>
        </li>
        <% } %>
    </ul>
    <% } else { %>
    <p>0 documents found for this user.</p>
    <% } %>
</div>
</body>
</html>
