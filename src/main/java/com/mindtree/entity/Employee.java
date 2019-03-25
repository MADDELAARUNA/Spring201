package com.mindtree.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.ToString;


@Entity
@ToString
public class Employee{

	public Employee(String empId, String empName, Project project, List<Task> task) {
		
		this.empId = empId;
		this.empName = empName;
		this.project = project;
		this.task = task;
	}

	
	
	public Employee() {
		
	}
	@Id
	private String empId;
	
	@Column(nullable = false)
	private String empName;
	
	@ManyToOne
	@JoinColumn(name = "projectId")
	@JsonManagedReference
	private Project project;
	
	@ManyToMany(mappedBy="employee")
	@JsonBackReference
	List<Task> task= new ArrayList<Task>();

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
