<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
<style type="text/css">
a {
	text-decoration: none;
	margin-left: 100px;
	margin-top: 25px;
	display: inline-block;
}

h3 {
	margin-left: 450px;
}
</style>
</head>
<body>
	<h3>${msg}</h3>
	<fieldset style="width: 300px; margin: 10% 35%; height: 150px;">
		<legend>Task Management:</legend>
		<a href="assignTask">Assign Tasks</a><br /> <a href="tasksView">Task
			View</a>
	</fieldset>

</body>
</html>
