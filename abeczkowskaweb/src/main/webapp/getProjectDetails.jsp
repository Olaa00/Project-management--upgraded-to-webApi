<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Project Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
        }

        .form-container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 50%;
            margin: 20px auto;
        }

        .form-heading {
            color: #333;
            margin-bottom: 10px;
        }

        .form label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        .form input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
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

        .back-button {
            margin-top: 10px;
        }

        .back-button button[type="submit"] {
            background-color: #ccc;
            color: #333;
            border: none;
            border-radius: 3px;
            padding: 8px 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .back-button button[type="submit"]:hover {
            background-color: #999;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2 class="form-heading">Get Project Details</h2>
    <form class="form" action="get-project-details" method="post">
        <label for="projectName">Project Name:</label>
        <input type="text" id="projectName" name="projectName" required>
        <button type="submit">SHOW DETAILS</button>
    </form>
    <form class="back-button" action="initPage.jsp">
        <button type="submit">BACK</button>
    </form>
</div>
</body>
</html>
