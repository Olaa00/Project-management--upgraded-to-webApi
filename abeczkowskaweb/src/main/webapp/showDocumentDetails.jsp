<%@ page import="pl.abeczkowska.project.model.UserProjectRelation" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document Details</title>
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

        .container p {
            color: #555;
            margin: 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Document Details</h2>
    <% UserProjectRelation documentDetails = (UserProjectRelation) request.getAttribute("documentDetails");
        if (documentDetails != null) { %>
    <p><strong>User ID:</strong> <%= documentDetails.getUserId() %></p>
    <% } else { %>
    <p>No details found. Document has no details.</p>
    <% } %>
</div>
</body>
</html>
