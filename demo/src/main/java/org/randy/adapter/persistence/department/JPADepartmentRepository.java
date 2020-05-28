package org.randy.adapter.persistence.department;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.randy.adapter.persistence.Mapper;
import org.randy.domain.department.repository.DepartmentRepository;
import org.randy.domain.department.root.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 部门资源库适配器
 * 
 * @author x00418543
 * @since 2019年12月12日
 */
@Repository
public class JPADepartmentRepository implements DepartmentRepository {

	@Autowired
	@PersistenceContext
	private EntityManager em;

	private Mapper<DepartmentPO, Department> mapper = new DepartmentMapper();

	@Override
	public Department findById(long id) {
		DepartmentPO departmentPO = em.find(DepartmentPO.class, id);
		Department department = mapper.toAggregateRoot(departmentPO);
		return department;
	}

	@Override
	public void save(Department department) {

	}

	@Override
	public void remove(Department department) {

	}

}
