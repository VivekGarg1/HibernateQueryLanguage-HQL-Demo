package com.home.client;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.home.entities.Employee;
import com.home.util.HibernateUtil;

public class InsertDataClientTest {

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
			insertEmployeeRecord(sf);
	}

	private static void insertEmployeeRecord(SessionFactory sf) {
		
         try(Session session=sf.openSession()){
			String HQL="insert into Employee(employeeName,email,doj,salary)"+
         "select employeeName,email,doj,salary from BackupEmployee";
			Query query = session.createQuery(HQL);
			session.beginTransaction();
			int executeUpdate=query.executeUpdate();
			if(executeUpdate >0)
				System.out.println(executeUpdate+" records updated successfully!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
