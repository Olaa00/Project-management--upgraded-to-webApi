<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .form-container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 400px;
            margin: 0 auto;
        }

        .form-heading {
            color: #333;
            margin-bottom: 10px;
        }

        .form {
            margin-bottom: 20px;
        }

        .form label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        .form input[type="text"],
        .form input[type="email"],
        .form input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 14px;
        }

        .form button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form button[type="submit"]:hover {
            background-color: #0056b3;
        }

        .message-container {
            text-align: center;
            color: #555;
        }

        .success-message {
            color: #28a745;
            margin-top: 10px;
        }

        .error-message {
            color: #dc3545;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2 class="form-heading">Add User</h2>
    <form class="form" action="create-user" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <button type="submit">ADD NEW USER</button>
    </form>
    <form action="initPage.jsp">
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
</body>
</html>
