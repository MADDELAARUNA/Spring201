<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Task</title>
<style type="text/css">
fieldset {
	border-color: darkblue;
	width: 600px;
	height: 350px;
	margin: 5% 25%;
}

td {
	padding: 10px;
}

select {
	width: 170px;
}
</style>

<s:url var="jquery" value="/static/js/jquery-3.3.1.min.js"></s:url>
<script src="${jquery}"></script>
<s:url var="val" value="/static/js/val.js"></s:url>
<script src="${val}"></script>
<script type="text/javascript">
	function changeProject(projectId) {
		var pid = projectId;

		$.ajax({
			type : 'GET',
			contentType : 'application/json',
			url : '/SpringPraticals/project/' + pid,
			dataType : 'json',
			async : true,

			success : function(response) {
				console.log(response);
				var option = '';
				if (response.length == 0) {

					$('#items').html(option);

				} else {

					for (var i = 0; i < response.length; i++) {
						option += '<option value="'+ response[i].empId + '">'
								+ "(" + response[i].empId + ")"
								+ response[i].empName + '</option>';
					}
					$('#items').html(option);
				}

			},
			error : function(data) {
				console.log(data);
			}

		});
	}
	function reload(){
		location.reload();

		
		}
</script>
<link
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/themes/base/jquery-ui.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/jquery-ui.min.js"></script>
<script>
	$(document).ready(function() {
		$('input[id$=startDate]').datepicker({
			dateFormat : 'dd-mm-yy'
		});
		$('input[id$=endDate]').datepicker({
			dateFormat : 'dd-mm-yy'
		});
	});
</script>
</head>
<body>

	<fieldset>
		<legend>Assign Task</legend>
		<form action="taskAssignment" name="myForm" method="post">
			<table>
				<tr>
					<td>Project *</td>
					<td><select id="project" name="project"
						onchange="changeProject(this.value)" onfocusout="select()">
							<option value="0">--Select Project--</option>
							<c:forEach var="element" items="${listProject}">
								<option value="${element.projectId}"><c:out
										value="${element.projectName}" />
								</option>
							</c:forEach>



					</select></td>
					<td><span id="project_select" style="color: red"></span>
				</tr>

				<tr>
					<td>Description *</td>
					<td><input type="text" name="description" id="description"
						required onfocusout="desc()"></td>
					<td><span id="task_description" style="color: red"></span>
				</tr>
				<tr>
					<td>Start Date Of Task [dd-mm-yyyy] *</td>
					<td><input type="text" placeholder="10-01-2015"
						name="startDate" id="startDate"
						pattern="^([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)(20)((1)(8|9)|[2-9][0-9])$"
						required ></td>
					<td><span id="task_startDate" style="color: red"></span>
				</tr>
				<tr>
					<td>End Date Of Task [dd-mm-yyyy] *</td>
					<td><input type="text" placeholder="12-02-2015" name="endDate"
						id="endDate" 
						pattern="^([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)(20)((1)(8|9)|[2-9][0-9])$"
						required ></td>
					<td><span id="task_endDate" style="color: red"></span>
				</tr>
				<tr>
					<td>Who Should Do this? *</td>
					<td><select name="employee" size="3" id="items" multiple
						required>

					</select></td>
					<td><span id="emp" style="color: red"></span>
				</tr>

				<tr>
					<td>
						<button type="submit">Add
							a Task</button>
					</td>
					<td><button type="reset" onclick="reload()">Cancel</button></td>
				</tr>

			</table>
		</form>


	</fieldset>

</body>
</html>