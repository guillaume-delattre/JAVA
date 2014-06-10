package org.gdelattre.jsf;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean(name="user")
@RequestScoped
public class UserBean implements Serializable{
 
	String username;
	int age;
	double salary;
	String password;
	String confPassword;
	Date dob;
	String bookmarkURL;
	 
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfPassword() {
		return confPassword;
	}

	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getBookmarkURL() {
		return bookmarkURL;
	}
 
	public void setBookmarkURL(String bookmarkURL) {
		this.bookmarkURL = bookmarkURL;
	}
 
}