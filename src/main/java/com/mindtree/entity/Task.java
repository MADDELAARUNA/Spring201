package com.mindtree.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author M1044588
 *
 */
@Entity
public class Task {

	@Id
	@GeneratedValue
	private int taskId;

	private String taskDescription;

	private String start_Date_Of_Task;

	private String end_Date_Of_Task;

	@ManyToOne
	@JoinColumn(name = "projectId")
	@JsonManagedReference
	private Project project;

	@ManyToMany(fetch=FetchType.EAGER)
	@JsonManagedReference
	@JoinTable(name = "Task_Employee", joinColumns = @JoinColumn(name = "TaskId"), inverseJoinColumns = @JoinColumn(name = "empId"))
	private List<Employee> employee = new ArrayList<Employee>();

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getStart_Date_Of_Task() {
		return start_Date_Of_Task;
	}

	public void setStart_Date_Of_Task(String start_Date_Of_Task) {
		this.start_Date_Of_Task = start_Date_Of_Task;
	}

	public String getEnd_Date_Of_Task() {
		return end_Date_Of_Task;
	}

	public void setEnd_Date_Of_Task(String end_Date_Of_Task) {
		this.end_Date_Of_Task = end_Date_Of_Task;
	}
}
