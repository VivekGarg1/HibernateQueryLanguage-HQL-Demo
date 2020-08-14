package com.home.client;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.home.entities.Department;
import com.home.entities.Employee;
import com.home.util.HibernateUtil;

public class HQLWithGroupByAndHavingClientTest {

	public static void main(String[] args) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//createDepartmentWithEmployee(session);
				getDatafromDepartment(session);
			} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void getDatafromDepartment(Session session) {
		String HQL1="select dept.departmentName,SUM(emp.salary) from Department dept"
				+ " left join dept.employee emp GROUP BY dept";
		String HQL2="select dept.departmentName,SUM(emp.salary) from Department dept"
				+ " left join dept.employee emp GROUP BY dept"
				+ " HAVING SUM(emp.salary)>35000" ;
		Query<Object[]> query = session.createQuery(HQL2,Object[].class);
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			String deptName=(String) objects[0];
			Double empsalary=(Double) objects[1];
			System.out.println("Employee Deartment: "+deptName);
			System.out.println("Employee Salary: "+empsalary);
		}
		
	}

	private static void createDepartmentWithEmployee(Session session) {
		session.beginTransaction();
		Department department1= new Department();
		department1.setDepartmentName("CSE");
		department1.setDepartmentLocation("Tower1");
		
		Employee employee1=new Employee();
		employee1.setEmployeeName("Vivek");
		employee1.setEmail("vivek@gmail.com");
		employee1.setDoj(new Date());
		employee1.setSalary(16000.00);
		
		Employee employee2=new Employee();
		employee2.setEmployeeName("Prabhat");
		employee2.setEmail("prabhat@gmail.com");
		employee2.setDoj(new Date());
		employee2.setSalary(17000.00);
		
		department1.getEmployee().add(employee1);
		department1.getEmployee().add(employee2);
		
		employee1.setDepartment(department1);
		employee2.setDepartment(department1);
		
		Department department2= new Department();
		department2.setDepartmentName("ME");
		department2.setDepartmentLocation("Tower2");
		
		Employee employee3=new Employee();
		employee3.setEmployeeName("Paras");
		employee3.setEmail("paras@gmail.com");
		employee3.setDoj(new Date());
		employee3.setSalary(18000.00);
		
		Employee employee4=new Employee();
		employee4.setEmployeeName("Shubham");
		employee4.setEmail("shubham@gmail.com");
		employee4.setDoj(new Date());
		employee4.setSalary(19000.00);
		
		Employee employee5=new Employee();
		employee5.setEmployeeName("Raja");
		employee5.setEmail("raja@gmail.com");
		employee5.setDoj(new Date());
		employee5.setSalary(20000.00);
		
		department2.getEmployee().add(employee3);
		department2.getEmployee().add(employee4);
		department2.getEmployee().add(employee5);
		
		employee3.setDepartment(department2);
		employee4.setDepartment(department2);
		employee5.setDepartment(department2);
		
		session.save(department1);
		session.save(department2);
		
		session.getTransaction().commit();
		
	}
}
