package org.gdelattre.orm.hibernate.dao;

import java.util.List;

import org.gdelattre.orm.hibernate.entity.EmployeeEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
//@Service
public class EmployeeDAOImpl implements EmployeeDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
//	@Transactional
	public void addEmployee(EmployeeEntity employee) {
		Transaction tx = null;
		Session session = null;
		try{
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(employee);
			tx.commit();
		}
		catch(Exception exception){
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
			employees = session.createQuery("from EmployeeEntity").list();
			tx.commit();
		}
		catch(Exception exception){
			// logs
		}
		finally{
			session.close();
		}
		return employees;
	}

	@Override
//	@Transactional
	public void deleteEmployee(Integer employeeId) {
		Transaction tx = null;
		Session session = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			EmployeeEntity employee = (EmployeeEntity) session.load(
					EmployeeEntity.class, employeeId);
	        if (null != employee) {
	        	session.delete(employee);
	        }
	        tx.commit();
		}
		catch(Exception exception){
			tx.rollback();
		}
		finally{
			session.close();
		}
	}

}
