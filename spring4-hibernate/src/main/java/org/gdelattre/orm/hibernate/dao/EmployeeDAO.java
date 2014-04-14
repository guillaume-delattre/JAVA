package org.gdelattre.orm.hibernate.dao;

import java.util.List;
import org.gdelattre.orm.hibernate.entity.EmployeeEntity;

public interface EmployeeDAO 
{
    public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}