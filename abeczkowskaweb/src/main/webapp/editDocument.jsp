<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Edit Document</title>
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

    .form label {
      display: block;
      margin-bottom: 5px;
      color: #555;
    }

    .form input[type="text"],
    .form input[type="number"] {
      width: 100%;
      padding: 10px;
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
  </style>
</head>
<body>
<div class="form-container">
  <h2 class="form-heading">Edit Document</h2>
  <form class="form" action="edit-document" method="post">
    <input type="hidden" name="title" value="${document.title}">
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" value="${document.description}" required>
    <label for="creator">Creator:</label>
    <input type="text" id="creator" name="creator" value="${document.creator}" required>
    <label for="topic">Topic:</label>
    <input type="text" id="topic" name="topic" value="${document.topic}" required>
    <label for="content">Content:</label>
    <input type="text" id="content" name="content" value="${document.content}" required>
    <label for="project_id">Project ID:</label>
    <input type="number" id="project_id" name="project_id" value="${document.projectId}" required>
    <button type="submit">EDIT DOCUMENT</button>
  </form>
</div>
</body>
</html>
