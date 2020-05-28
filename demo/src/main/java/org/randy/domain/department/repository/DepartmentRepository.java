package org.randy.domain.department.repository;

import org.randy.domain.core.repository.AggregateRootRepository;
import org.randy.domain.department.root.Department;

/**
 * 部门聚合根
 * 
 * @author x00418543
 * @since 2019年12月12日
 */
public interface DepartmentRepository
		extends
			AggregateRootRepository<Department> {

}
