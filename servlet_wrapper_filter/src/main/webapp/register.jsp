<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f0f0;
    }

    .container {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
      text-align: center;
      margin-bottom: 20px;
    }

    .input-group {
      margin-bottom: 15px;
    }

    .input-group label {
      display: block;
      margin-bottom: 5px;
    }

    .input-group input {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 3px;
    }

    button {
      width: 100%;
      padding: 10px;
      background-color: #007bff;
      color: #fff;
      border: none;
      border-radius: 3px;
      cursor: pointer;
    }

    button:hover {
      background-color: #0056b3;
    }

    .error-message {
      color: red;
      text-align: center;
      margin-top: 10px;
    }

  </style>
</head>
<body>
<div class="container">
  <form id="registerForm" action="registerServlet" method="post">
    <h2>Register</h2>
    <div class="input-group">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" required>
    </div>
    <div class="input-group">
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required>
    </div>
    <div class="input-group">
      <label for="age">Age:</label>
      <input type="number" id="age" name="age" required>
    </div>
    <div class="input-group">
      <label for="university">University:</label>
      <input type="text" id="university" name="university" required>
    </div>
    <div class="input-group">
      <label>Interests:</label><br>
      <input type="checkbox" id="SE" name="interests" value="Software Engineering">
      <label for="SE">Software Engineering</label><br>
      <input type="checkbox" id="DS" name="interests" value="DataScience">
      <label for="DS">DataScience</label><br>
      <input type="checkbox" id="iot" name="interests" value="Internet Of Things">
      <label for="iot">Internet Of Things</label><br>
    </div>
    <button type="submit">Register</button>
    <p id="error-message" class="error-message"></p>
  </form>
</div>

</body>
</html>

