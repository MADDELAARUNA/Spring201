package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Employee;
import com.mindtree.entity.Project;
import com.mindtree.entity.Task;

public interface Dao {
	List<Project> getProjectList();

	List<Employee> getEmployeeList(int pid);

	List<Employee> getEmployeeList();

	void saveTask(Task task);

	List<Task> getTaskList();

	List<Task> getTaskList(int projectId);
}
