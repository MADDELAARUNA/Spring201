function desc() {
	if (document.getElementById("description").value == '') {
		document.getElementById("task_description").innerHTML = "Enter a description";
	}
}

function select() {
	if (document.getElementById("project").value == 0) {
		document.getElementById("project_select").innerHTML = "Please select a project";
	}
}

/*function date() {
	var pattern = /([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)(20)((1)(8|9)|[2-9][0-9])$/;
	if (document.getElementById("endDate").value =="") {

		document.getElementById("task_endDate").innerHTML = "Enter end date";
	}
}*/
/*
function date1() {

	var pattern = /([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)(20)((1)(8|9)|[2-9][0-9])$/;
	if (document.getElementById("endDate").value =="") {

		document.getElementById("task_endDate").innerHTML = "Enter end date";
	}
}*/