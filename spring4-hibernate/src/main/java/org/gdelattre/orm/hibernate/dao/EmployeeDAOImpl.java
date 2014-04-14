package org.gdelattre.orm.hibernate.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.gdelattre.orm.hibernate.entity.EmployeeEntity;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Note : To use this sample with the transaction managed you need to add this line in 
 *        spring-cnfig.xml :
 *          <prop key="hibernate.current_session_context_class">managed</prop>
 *        instead of :
 *          <prop key="hibernate.current_session_context_class">thread</prop>
 * @author guillaume
 *
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
//  version without transaction 	
//	@Override
//	public void addEmployee(EmployeeEntity employee) {
//		this.sessionFactory.openSession().save(employee);
//	}
	
	
	@Override
	public void addEmployee(EmployeeEntity employee) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		this.sessionFactory.getCurrentSession().save(employee);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		List<EmployeeEntity> employees = 
				this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity").list();
		tx.commit();
		return employees;
	}

//  version without transaction	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<EmployeeEntity> getAllEmployees() {
//		List<EmployeeEntity> employees = this.sessionFactory.openSession().createQuery("from EmployeeEntity").list();
//		return employees;
//	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		EmployeeEntity employee = (EmployeeEntity) sessionFactory.getCurrentSession().load(
				EmployeeEntity.class, employeeId);
        if (null != employee) {
        	this.sessionFactory.getCurrentSession().delete(employee);
        }
        tx.commit();
	}

//  version without transaction
//	@Override
//	public void deleteEmployee(Integer employeeId) {
//		final Session session = sessionFactory.openSession();
//		EmployeeEntity employee = (EmployeeEntity) session.load(
//				EmployeeEntity.class, employeeId);
//        if (null != employee) {
//        	session.delete(employee);
//        }
//	}
	
}
