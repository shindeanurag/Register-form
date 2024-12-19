<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Profile</title>
	
  <style>
    /* Basic Reset */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    /* Body and Background Styling */
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f4f4f4;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    /* Container for Profile Section */
    .profile-container {
      background-color: white;
      padding: 40px;
      border-radius: 10px;
      box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
      width: 100%;
      max-width: 600px;
      text-align: center;
    }

    /* Header Styling */
    h1 {
      font-size: 2.5em;
      color: #333;
      margin-bottom: 20px;
    }

    /* Paragraph Styling */
    p {
      font-size: 1.2em;
      color: #555;
      margin-top: 20px;
    }

    /* Button Styling */
    .back-button {
      margin-top: 30px;
      padding: 12px 25px;
      background-color: #4285f4;
      color: white;
      border: none;
      border-radius: 5px;
      font-size: 1.1em;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .back-button:hover {
      background-color: #357ae8;
    }

    /* Mobile Responsiveness */
    @media (max-width: 500px) {
      .profile-container {
        width: 90%;
        padding: 20px;
      }
      h1 {
        font-size: 2em;
      }
    }

  </style>
</head>
<body>

  <div class="profile-container">
    <h1>Welcome to Your Profile</h1>
    <p>Here you can view your details, settings, and more.</p>
    <a href="LoginPage.html">
      <button class="back-button">Go to Login</button>
    </a>
  </div>

</body>
</html>
