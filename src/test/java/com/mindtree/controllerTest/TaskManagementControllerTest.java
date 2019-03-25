package com.mindtree.controllerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import com.mindtree.controller.TaskManagementController;
import com.mindtree.entity.Project;
import com.mindtree.service.TaskService;

@RunWith(MockitoJUnitRunner.class)
public class TaskManagementControllerTest {

	private MockMvc mockmvc;

	@Mock
	@Autowired
	private TaskService taskServiceImpl;
	
	 @Mock
	 View mockView;
	 
	 private MediaType contentType = new MediaType("application", "json", Charset.forName("UTF-8"));


	@InjectMocks
	private TaskManagementController taskController;

	@Before
	public void setup() {

		mockmvc = MockMvcBuilders.standaloneSetup(taskController).setSingleView(mockView).build();

	}

	@Test
	public void testGetProjectId() throws Exception {
		
		List<Project> projectList =Arrays.asList(new Project(1,"MOSIP"),new Project(2,"AAMC"), new Project(3,"HBS"));

		when(taskServiceImpl.getProjectList()).thenReturn(projectList);
		
		mockmvc.perform(
				MockMvcRequestBuilders.get("/project/{pid}",1)
				).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().
				  contentType(contentType));
		         
	}
	
	@Test
	public void testassignTask() throws Exception {
		
		mockmvc.perform(
				MockMvcRequestBuilders.get("/assignTask")
				).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testTaskView() throws Exception {
		
		mockmvc.perform(
				MockMvcRequestBuilders.get("/tasksView")
				).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
