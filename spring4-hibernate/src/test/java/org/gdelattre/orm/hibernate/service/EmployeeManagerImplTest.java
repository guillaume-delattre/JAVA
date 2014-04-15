package org.gdelattre.orm.hibernate.service;

import static org.junit.Assert.*;

import java.util.List;

import org.gdelattre.orm.hibernate.entity.EmployeeEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class EmployeeManagerImplTest {
	
	@Autowired
	EmployeeManager employeeManager;
	
	private EmployeeEntity getEmployee(){
		
		final EmployeeEntity employee = new EmployeeEntity();
		employee.setFirstname("Guillaume");
		employee.setLastname("Delattre");
		employee.setEmail("guillaume.delattre@test.com");
		employee.setTelephone("+33100000000");
		
		return employee;
		
	}
	
	@Test
	public void testAddEmployeeAndGetAllEmployees(){
		
		final EmployeeEntity employee = getEmployee();
		
		employeeManager.addEmployee(employee);
		
		final List<EmployeeEntity> expectedEmployees = employeeManager.getAllEmployees();
		final EmployeeEntity expectedEmployee = expectedEmployees.get(0);
		
		assertEquals(1, employeeManager.getAllEmployees().size());
		assertEquals("Guillaume", expectedEmployee.getFirstname());
		assertEquals("Delattre", expectedEmployee.getLastname());
		assertEquals("guillaume.delattre@test.com", expectedEmployee.getEmail());
		assertEquals("+33100000000", expectedEmployee.getTelephone());
		
	}
	
	@Test
	public void testDeleteEmployeeAndGetAllEmployees(){
		
		final EmployeeEntity employee = employeeManager.getAllEmployees().get(0);
		
		employeeManager.deleteEmployee(employee.getId());
		
		assertEquals(0, employeeManager.getAllEmployees().size());
		
	}

}
