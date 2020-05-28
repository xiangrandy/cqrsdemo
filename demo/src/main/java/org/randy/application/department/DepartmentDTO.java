package org.randy.application.department;

import org.randy.domain.department.root.Department;

/**
 * 部门DTO
 * 
 * @author x00418543
 * @since 2019年12月13日
 */
public class DepartmentDTO {

	private long id;

	private String departmentCode;

	private String departmentName;

	private int employeeNumber;

	public DepartmentDTO(Department department, String departmentName) {
		this.id = department.getId();
		this.departmentCode = department.getDepartmentCode();
		this.departmentName = departmentName;
		this.employeeNumber = department.getEmployees().size();
	}

	public long getId() {
		return id;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

}
