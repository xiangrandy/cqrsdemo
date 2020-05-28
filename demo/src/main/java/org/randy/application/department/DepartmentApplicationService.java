package org.randy.application.department;

import org.randy.application.core.Cache;
import org.randy.domain.department.repository.DepartmentRepository;
import org.randy.domain.department.root.Department;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 部门应用服务
 * 
 * @author x00418543
 * @since 2019年12月13日
 */
public class DepartmentApplicationService {

	@Autowired
	private DepartmentRepository repo;

	@Autowired
	private Cache<String> cache;

	public DepartmentDTO findBy(long id) {
		Department department = repo.findById(id);
		String departmentName = cache.get("department",
				department.getDepartmentCode());
		DepartmentDTO dto = new DepartmentDTO(department, departmentName);
		return dto;
	}

}
