package com.mindtree.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.mindtree.dao.Dao;
import com.mindtree.entity.Employee;
import com.mindtree.entity.Project;
import com.mindtree.entity.Task;
import com.mindtree.serviceimpl.TaskServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class TaskServiceImplTest {

    @Mock
	private Dao dao;

	@InjectMocks
	private TaskServiceImpl taskServiceImpl;
	
	List<Employee> employeeList = new ArrayList<Employee>();
	
	List<Task> taskList = new ArrayList<Task>();
	
	Project project;
	
	Employee employee;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
        employee =new Employee();
     	employee.setEmpId("M1044588");
     	employee.setEmpName("Ajay J");
        project = new Project();
     	project.setProjectId(1);
     	project.setProjectName("MOSIP");
     	employee.setProject(project);
     	employeeList.add(employee);
     	Task task = new Task(); 
     	task.setEmployee(employeeList);
     	task.setTaskId(1);
     	task.setProject(project);
     	task.setTaskDescription("Unit testing");
     	task.setStart_Date_Of_Task("10-10-2018");
     	task.setEnd_Date_Of_Task("11-11-2018");
     	
     	taskList.add(task);

	}
    @Test
	public void testGetProjectList() {

		when(dao.getProjectList()).thenReturn(projectList());

		assertEquals(1, taskServiceImpl.getProjectList().size());
		Mockito.verify(dao).getProjectList();
  
	}
	
	@Test
	public void testGetEmployeeList() {
  
		when(dao.getEmployeeList(1)).thenReturn(employeeList);
		assertEquals(1, taskServiceImpl.getEmployee(1).size());
		Mockito.verify(dao).getEmployeeList(1);
		assertEquals(1, taskServiceImpl.getEmployee(1).get(0).getProject().getProjectId());
	
		
	}
	@Test
	public void testGetTaskList() {

		when(dao.getTaskList()).thenReturn(taskList);
		when(dao.getTaskList(1)).thenReturn(taskList);
		assertEquals(1, taskServiceImpl.getTaskList().size());
		assertEquals(1, taskServiceImpl.getTaskList(1).get(0).getProject().getProjectId());
		
	}
	
	@Test
	@Ignore
	public void testsaveTaskDetails() {
		
		Task task = new Task(); 
     	task.setEmployee(employeeList);
     	task.setTaskId(2);
     	task.setTaskDescription("Unit testing2");
     	task.setStart_Date_Of_Task("12-10-2018");
     	task.setEnd_Date_Of_Task("11-11-2018");
     	
     	Mockito.verify(dao).saveTask(task);
     	
	}


	private List<Project> projectList() {

		List<Project> projectList = new ArrayList<Project>();
		Project project = new Project();
		project.setProjectId(1);
		project.setProjectName("MOSSIP");
		projectList.add(project);
		return projectList;
	}
}
