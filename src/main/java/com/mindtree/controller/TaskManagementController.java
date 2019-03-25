package com.mindtree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.entity.Employee;
import com.mindtree.entity.Task;
import com.mindtree.service.TaskService;

@Controller
public class TaskManagementController {

	@Autowired
	private TaskService service;

	@RequestMapping(value = "/assignTask")
	public ModelAndView assignTask() {
		ModelAndView mv = new ModelAndView("assignTask");
		mv.addObject("listProject", service.getProjectList());
		return mv;
	}

	@RequestMapping(value = "/tasksView")
	public ModelAndView taskView() {
		ModelAndView mv = new ModelAndView("viewTask");
		mv.addObject("listProject", service.getProjectList());
		return mv;
	}

	@RequestMapping(value = "/taskAssignment", method = RequestMethod.POST)
	public ModelAndView getTaskDetail(@RequestParam("description") String description,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("project") int pid, @RequestParam("employee") List<String> emp) {
		Task task = new Task();
		task.setTaskDescription(description);
		task.setStart_Date_Of_Task(startDate);
		task.setEnd_Date_Of_Task(endDate);
		service.saveTaskDetails(task, pid, emp);
		ModelAndView mv = new ModelAndView("../index");
		mv.addObject("msg", "Details added Successfully");
		return mv;

	}

	@RequestMapping(value = "/project/{pid}", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getProjectId(@PathVariable int pid) {
		return service.getEmployee(pid);
	}

	@RequestMapping(value="/getTaskLists/{pid}",method=RequestMethod.GET)
	@ResponseBody
	public List<Task> getTaskdetails(@PathVariable int pid){
	
		if(pid==0) {
			return service.getTaskList();
		}else if(pid >0){
			return service.getTaskList(pid);
		}else{
		
		return null;
	}
	}

}
