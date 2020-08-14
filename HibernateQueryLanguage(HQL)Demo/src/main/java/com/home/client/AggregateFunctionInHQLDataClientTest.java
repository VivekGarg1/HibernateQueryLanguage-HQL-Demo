package com.home.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.home.entities.EmployeeStatistics;
import com.home.util.HibernateUtil;

public class AggregateFunctionInHQLDataClientTest {

	public static void main(String[] args) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			String HQL="select new com.home.entities.EmployeeStatistics(count(e),AVG(e.salary),MIN(e.salary),SUM(e.salary)) from Employee e";
			Query<EmployeeStatistics> query = session.createQuery(HQL,EmployeeStatistics.class);
			EmployeeStatistics statistics = query.uniqueResult();
				System.out.println("Total no of employees: "+statistics.getEmpCount());
				System.out.println("Average salary: "+statistics.getAvgSalary());
				System.out.println("Minimum salary: "+statistics.getMinSalary());
				System.out.println("Total salary: "+statistics.getSumOfSalary());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
