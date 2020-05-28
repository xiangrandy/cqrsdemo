package org.randy.adapter.persistence.department;

import org.randy.adapter.persistence.Mapper;
import org.randy.domain.department.root.Department;

/**
 * DepartmentMapper
 * 
 * @author x00418543
 * @since 2019年12月13日
 */
public class DepartmentMapper implements Mapper<DepartmentPO, Department> {

	@Override
	public Department toAggregateRoot(DepartmentPO p) {
		long id = p.getId();
		String departmentCode = p.getDepartmentCode();
		String departmentName = p.getDepartmentName();
		Department department = new Department(id, departmentCode,
				departmentName);
		return department;
	}

	@Override
	public DepartmentPO toPersistantObject(Department r) {
		// TODO Auto-generated method stub
		return null;
	}

}
