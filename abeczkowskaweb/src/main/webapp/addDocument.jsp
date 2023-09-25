<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Document</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .document-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .document-form {
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 350px;
        }

        .document-heading {
            margin-bottom: 20px;
            text-align: center;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-group input[type="text"],
        .form-group input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .document-button {
            text-align: center;
            margin-top: 20px;
        }

        .document-button input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .document-button input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .back-button {
            text-align: center;
            margin-top: 10px;
        }

        .back-button button {
            background-color: #ccc;
            border: none;
            border-radius: 3px;
            padding: 5px 10px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .back-button button:hover {
            background-color: #999;
        }

        .message-container {
            text-align: center;
            color: #555;
            margin-top: 10px;
        }

        .success-message {
            color: #28a745;
        }

        .error-message {
            color: #dc3545;
        }
    </style>
</head>
<body>
<div class="document-container">
    <form class="document-form" action="create-document" method="post">
        <h2 class="document-heading">Add Document</h2>
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" id="description" name="description" required>
        </div>
        <div class="form-group">
            <label for="creator">Creator:</label>
            <input type="text" id="creator" name="creator" required>
        </div>
        <div class="form-group">
            <label for="topic">Topic:</label>
            <input type="text" id="topic" name="topic" required>
        </div>
        <div class="form-group">
            <label for="content">Content:</label>
            <input type="text" id="content" name="content" required>
        </div>
        <div class="form-group">
            <label for="project_id">Project ID:</label>
            <input type="number" id="project_id" name="project_id" required>
        </div>
        <div class="document-button">
            <input type="submit" value="ADD DOCUMENT">
        </div>
    </form>
    <form class="back-button" action="initPage.jsp">
        <button type="submit">Back</button>
    </form>
    <div class="message-container">
        <% if (request.getAttribute("successMessage") != null) { %>
        <p class="success-message"><%= request.getAttribute("successMessage") %></p>
        <% } else if (request.getAttribute("errorMessage") != null) { %>
        <p class="error-message"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
    </div>
</div>
