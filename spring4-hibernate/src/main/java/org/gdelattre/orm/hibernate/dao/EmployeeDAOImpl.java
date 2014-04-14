package org.gdelattre.orm.hibernate.dao;

import java.util.List;

import org.gdelattre.orm.hibernate.entity.EmployeeEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
//@Service
public class EmployeeDAOImpl implements EmployeeDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
//  version without transaction 	
//	@Override
//	public void addEmployee(EmployeeEntity employee) {
//		this.sessionFactory.openSession().save(employee);
//	}
	
	
	@Override
//	@Transactional
	public void addEmployee(EmployeeEntity employee) {
		Transaction tx = null;
		Session session = null;
		try{
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
	//		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
	//		this.sessionFactory.getCurrentSession().save(employee);
			session.save(employee);
			tx.commit();
		}
		catch(HibernateException exception){
			tx.rollback();
		}
		finally{
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
//	@Transactional
	public List<EmployeeEntity> getAllEmployees() {
		Transaction tx = null;
		Session session = null;
		List<EmployeeEntity> employees = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
	//		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
			employees = session.createQuery("from EmployeeEntity").list();
	//		List<EmployeeEntity> employees = 
	//				this.sessionFactory.getCurrentSession().
	//					createQuery("from EmployeeEntity").list();
			tx.commit();
		}
		catch(HibernateException exception){
			// logs
		}
		finally{
			session.close();
		}
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
//	@Transactional
	public void deleteEmployee(Integer employeeId) {
		Transaction tx = null;
		Session session = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
	//		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
	//		EmployeeEntity employee = (EmployeeEntity) sessionFactory.getCurrentSession().load(
	//				EmployeeEntity.class, employeeId);
			EmployeeEntity employee = (EmployeeEntity) session.load(
					EmployeeEntity.class, employeeId);
	        if (null != employee) {
	//        	this.sessionFactory.getCurrentSession().delete(employee);
	        	session.delete(employee);
	        }
	        tx.commit();
		}
		catch(HibernateException exception){
			tx.rollback();
		}
		finally{
			session.close();
		}
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
