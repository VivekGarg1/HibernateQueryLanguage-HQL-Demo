package com.home.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="employee_table")
/*@NamedQuery(name = "getTotalSalryOfEmpByDept", query = "select dept.departmentName,SUM(emp.salary) from Department dept" 
		+  " left join dept.employee emp GROUP BY dept" 
		+ " HAVING SUM(emp.salary)>35000")*/
/*@NamedQueries(value = { 
		@NamedQuery(name = "getTotalSalryOfEmpByDept", query = "select dept.departmentName,SUM(emp.salary) from Department dept" 
				+  " left join dept.employee emp GROUP BY dept" 
				+ " HAVING SUM(emp.salary)>35000"),
		@NamedQuery(name = "Employee.byId", query = "from Employee where employeeId=:empId") 
		})*/

@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "getTotalSalryOfEmpByDept", query = "select dept.department_name as deptName," + 
				"sum(emp.salary) as totalSalary from department_table dept left outer join employee_table emp on dept.department_id=emp.department_id "+ 
				"group by dept.department_id having sum(emp.salary)>35000"),
		@NamedNativeQuery(name = "Employee.byId", query = "select * from employee_table where employee_id=:empId",resultClass = Employee.class)
		})
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "employee_name",length = 100, nullable = false)
	private String employeeName;
	
	@Column(name = "email",unique = true)
	private String email;
	
	@Column(name = "date_of_joining")
	private Date doj;
	
	@Column(name = "salary")
	private double salary;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id")
	private Department department;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email + ", doj="
				+ doj + ", salary=" + salary + ", department=" + department + "]";
	}

}
