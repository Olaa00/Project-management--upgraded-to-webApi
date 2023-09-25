<%@page import="java.util.List"%>
<%@ page import="pl.abeczkowska.project.model.Project" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project List</title>
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

        .table-container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 50%;
            margin: 0 auto;
            overflow: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .back-button {
            text-align: center;
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
<div class="table-container">
    <h2>Projects List</h2>
    <table>
        <thead>
        <tr>
            <th>Project Name</th>
            <th>Description</th>
            <th>Creator</th>
        </tr>
        </thead>
        <tbody>
        <%!
            private Project[] projects;
        %><% for(Project project : projects){ %>
        <tr>
            <td><%=project.getName()%></td>
            <td><%=project.getDescription()%></td>
            <td><%=project.getCreator()%></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<div class="back-button">
    <form action="initPage.jsp">
        <button type="submit">Back</button>
    </form>
</div>
</body>
</html>
