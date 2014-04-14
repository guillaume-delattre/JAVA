package org.gdelattre.orm.hibernate.dao;

import static org.junit.Assert.*;
import org.gdelattre.orm.hibernate.entity.EmployeeEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class EmployeeDAOImplTest {
	
	@Autowired
	EmployeeDAOImpl employeeDao;
	
	@Test
	public void testAddEmployee(){
		
		final EmployeeEntity employee = new EmployeeEntity();
		employee.setId(1);
		employee.setFirstname("Guillaume");
		employee.setLastname("Delattre");
		employee.setFirstname("guillaume.delattre@test.com");
		employee.setTelephone("+33100000000");
		
		employeeDao.addEmployee(employee);
		
		final EmployeeEntity expectedEmployee = employeeDao.getAllEmployees().get(0);
		
		assertEquals(expectedEmployee.getId(), employee.getId());
		
	}

}
