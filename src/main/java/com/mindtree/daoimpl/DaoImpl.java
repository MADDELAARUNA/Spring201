package com.mindtree.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.dao.Dao;
import com.mindtree.entity.Employee;
import com.mindtree.entity.Project;
import com.mindtree.entity.Task;

@Repository
public class DaoImpl implements Dao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Project> getProjectList() {
		return sessionFactory.getCurrentSession().createQuery("from Project").list();

	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList(int pid) {
		System.out.println(pid);

		return sessionFactory.getCurrentSession().createQuery("from Employee where project=" + pid).list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeList() {

		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	public void saveTask(Task task) {

		sessionFactory.getCurrentSession().save(task);
	}

	@SuppressWarnings("unchecked")
	public List<Task> getTaskList() {

		return sessionFactory.getCurrentSession().createQuery("from Task").list();
	}

	@SuppressWarnings("unchecked")
	public List<Task> getTaskList(int projectId) {

		return sessionFactory.getCurrentSession().createQuery("from Task where projectId=" + projectId).list();
	}
}
