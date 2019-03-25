package com.mindtree.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.dao.Dao;
import com.mindtree.entity.Employee;
import com.mindtree.entity.Project;
import com.mindtree.entity.Task;
import com.mindtree.service.TaskService;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
	@Autowired
	private Dao dao;

	public List<Project> getProjectList() {
		return dao.getProjectList();
	}

	
	public List<Employee> getEmployee(int pid) {

		return dao.getEmployeeList(pid);
	}

	public void saveTaskDetails(Task task, int pid, List<String> emp) {

		for (Project project : dao.getProjectList()) {
			if (project.getProjectId() == pid) {
				task.setProject(project);
			}
		}

		for (int i = 0; i < emp.size(); i++) {
			for (Employee employee : dao.getEmployeeList()) {
				if (employee.getEmpId().equals(emp.get(i))) {
					task.getEmployee().add(employee);
				}
			}
		}
		
		
		    dao.saveTask(task);
	}

	public List<Task> getTaskList() {
		
		return dao.getTaskList();
	}

	public List<Task> getTaskList(int projectId) {
		
		return dao.getTaskList(projectId);
	}
	
	
	
}
