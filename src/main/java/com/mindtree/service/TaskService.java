package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Employee;
import com.mindtree.entity.Project;
import com.mindtree.entity.Task;

public interface TaskService {

	List<Project> getProjectList();

	List<Employee> getEmployee(int pid);

	void saveTaskDetails(Task task, int pid, List<String> emp);

	List<Task> getTaskList();

	List<Task> getTaskList(int projectId);

}
