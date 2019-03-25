package com.mindtree.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;

/**
 * @author M1044588
 *
 */
@Entity
@AllArgsConstructor
public class Project {

	public Project(int projectId, String projectName) {
		this.projectId = projectId;
		this.projectName = projectName;
	}

	@Id
	@GeneratedValue
	private int projectId;

	@Column(nullable = false)
	private String projectName;

	@OneToMany(mappedBy = "project")
	@JsonBackReference
	private List<Task> task = new ArrayList<Task>();

	@OneToMany(mappedBy = "project")
	@JsonBackReference
	private List<Employee> employee = new ArrayList<Employee>();

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public Project() {

	}
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

}
