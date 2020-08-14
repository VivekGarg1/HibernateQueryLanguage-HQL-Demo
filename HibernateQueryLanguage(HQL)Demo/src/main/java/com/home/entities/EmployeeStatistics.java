package com.home.entities;

public class EmployeeStatistics {
	
	private Long empCount;
	private Double avgSalary;
	private Double minSalary;
	private Double sumOfSalary;
	public EmployeeStatistics(Long empCount, Double avgSalary, Double minSalary, Double sumOfSalary) {
		super();
		this.empCount = empCount;
		this.avgSalary = avgSalary;
		this.minSalary = minSalary;
		this.sumOfSalary = sumOfSalary;
	}
	public Long getEmpCount() {
		return empCount;
	}
	public void setEmpCount(Long empCount) {
		this.empCount = empCount;
	}
	public Double getAvgSalary() {
		return avgSalary;
	}
	public void setAvgSalary(Double avgSalary) {
		this.avgSalary = avgSalary;
	}
	public Double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}
	public Double getSumOfSalary() {
		return sumOfSalary;
	}
	public void setSumOfSalary(Double sumOfSalary) {
		this.sumOfSalary = sumOfSalary;
	}

}
