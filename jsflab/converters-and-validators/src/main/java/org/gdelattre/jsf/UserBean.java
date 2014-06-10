package org.gdelattre.jsf;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
 
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
	String email;
	
	public void validatePassword(ComponentSystemEvent event) {
		 
		  FacesContext fc = FacesContext.getCurrentInstance();
	 
		  UIComponent components = event.getComponent();
	 
		  // get password
		  UIInput uiInputPassword = (UIInput) components.findComponent("password");
		  String password = uiInputPassword.getLocalValue() == null ? ""
			: uiInputPassword.getLocalValue().toString();
		  String passwordId = uiInputPassword.getClientId();
	 
		  // get confirm password
		  UIInput uiInputConfirmPassword = (UIInput) components.findComponent("confirmPassword");
		  String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? ""
			: uiInputConfirmPassword.getLocalValue().toString();
	 
		  // Let required="true" do its job.
		  if (password.isEmpty() || confirmPassword.isEmpty()) {
			return;
		  }
	 
		  if (!password.equals(confirmPassword)) {
	 
			FacesMessage msg = new FacesMessage("Password must match confirm password");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(passwordId, msg);
			fc.renderResponse();
	 
		  }
	 
		}
	 
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
	
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
}