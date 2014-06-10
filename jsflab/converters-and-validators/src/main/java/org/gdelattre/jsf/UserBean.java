package org.gdelattre.jsf;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean(name="user")
@RequestScoped
public class UserBean implements Serializable{
 
	String username;
	int age;
	double salary;
	 
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public double getSalary() {
		return salary;
	}
 
	public void setSalary(double salary) {
		this.salary = salary;
	}
 
}