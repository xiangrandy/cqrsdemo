package org.randy.domain.department.root;

import java.util.List;

import org.randy.domain.core.models.AggregateRoot;
import org.randy.domain.department.entity.Employee;

/**
 * 部门类
 * 
 * @author x00418543
 * @since 2019年12月12日
 */
public class Department extends AggregateRoot {

	private String departmentCode;

	private String departmentName;

	private List<Employee> employees;

	public Department(long id, String departmentCode, String departmentName) {
		super(id);
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
	}

	public Department(long departmentId) {
		super(departmentId);
	}

	public void remove(Employee employee) {
		employees.remove(employee);
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
