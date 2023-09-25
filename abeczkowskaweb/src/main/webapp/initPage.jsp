<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WELCOME! PROJECT MANAGEMENT SPACE</title>
    <link rel="stylesheet" href="styles.css"> <!-- Dodaj link do swojego arkusza stylów CSS -->
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

        .success-container {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .logout-button {
            margin-bottom: 20px;
        }

        .logout-button button {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .logout-button button:hover {
            background-color: #0056b3;
        }

        .success-heading {
            color: #333;
            margin-bottom: 10px;
        }

        .success-message {
            color: #555;
            margin-bottom: 20px;
        }

        .success-links {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }

        .operation-button {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 10px 20px;
            margin: 10px;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .operation-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="success-container">
    <div class="logout-button">
        <form action="logout" method="post">
            <button type="submit">LOG OUT</button>
        </form>
    </div>
    <h2 class="success-heading">Logged in successfully</h2>
    <p class="success-message">Welcome to the Project Management Board</p>
    <div class="success-links">
        <a class="operation-button" href="addUser.jsp">1. Add new user</a>
        <a class="operation-button" href="assignNewRole.jsp">2. Add new role</a>
        <a class="operation-button" href="getProjectsForUser.jsp">3. Show user's projects</a>
        <a class="operation-button" href="getUserDocuments.jsp">4. Show user's documents</a>
        <a class="operation-button" href="addProject.jsp">5. Add new project</a>
        <a class="operation-button" href="deleteProject.jsp">6. Delete project</a>
        <a class="operation-button" href="get-all-projects">7. Show all projects</a>
        <a class="operation-button" href="getProjectDetails.jsp">8. Show project details</a>
        <a class="operation-button" href="addDocument.jsp">9. Add new document</a>
        <a class="operation-button" href="chooseDocument.jsp">10. Edit document</a>
        <a class="operation-button" href="deleteDocument.jsp">11. Delete document</a>
        <a class="operation-button" href="getDocumentDetails.jsp">12. Show document details</a>
    </div>
</div>
</body>
</html>
