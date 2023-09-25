<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .error-container {
            text-align: center;
        }

        .error-heading {
            color: #dc3545;
            font-size: 24px;
            margin-bottom: 10px;
        }

        .back-link {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        .back-link:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h1 class="error-heading">An Error Occurred</h1>
    <p>Please try again.</p>
    <a class="back-link" href="login.jsp">Back to logging action</a>
</div>
</body>
</html>
