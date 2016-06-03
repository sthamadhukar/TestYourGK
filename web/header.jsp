<%--
  Created by IntelliJ IDEA.
  User: Madhukar
  Date: 5/26/2016
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Test Your General Knowledge</title>
  <link href="${pageContext.request.contextPath}/includes/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .navbar-brand img{
      height:45px;
    }
    .navbar-header .navbar-brand{
      color: #eaf0ff;
    }
    body{
      margin-top:60px;
    }
  </style>
</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img alt="Logo" src="${pageContext.request.contextPath}/includes/images/logo.png" class="img-responsive">
      </a>
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Test Your Generel Knowledge</a>
    </div>
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/questions">Questions</a></li>
        <li><a href="#report">Reports</a></li>
        <li><a href="${pageContext.request.contextPath}/users">Users</a></li>
        <li><a href="${pageContext.request.contextPath}/play">Play Quiz</a></li>
        <li><a href="#feedback">Feedback</a></li>
        <li><a href="#settings">Settings</a></li>

      </ul>
    </div><!--/.nav-collapse -->
  </div> <!-- container collapse -->
</div> <!-- navbar collapse -->
