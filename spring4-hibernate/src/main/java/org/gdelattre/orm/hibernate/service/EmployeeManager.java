package org.gdelattre.orm.hibernate.service;

import java.util.List;

import org.gdelattre.orm.hibernate.entity.EmployeeEntity;

public interface EmployeeManager {
	public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}
