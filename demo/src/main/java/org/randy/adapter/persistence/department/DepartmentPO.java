package org.randy.adapter.persistence.department;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.randy.adapter.persistence.Persistantable;
import org.randy.domain.department.root.Department;

/**
 * 部门持久化对象
 * 
 * @author x00418543
 * @since 2019年12月12日
 */
@Entity
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
@Table(name = "tb_department")
public class DepartmentPO implements Persistantable<Department> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "departmentCode", nullable = false, length = 64)
	private String departmentCode;

	@Column(name = "departmentName", nullable = false, length = 64)
	private String departmentName;

	private List<Long> employeeIds;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<Long> getEmployeeIds() {
		return employeeIds;
	}

	public void setEmployeeIds(List<Long> employeeIds) {
		this.employeeIds = employeeIds;
	}

}
