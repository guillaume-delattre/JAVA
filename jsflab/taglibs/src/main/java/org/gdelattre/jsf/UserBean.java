package org.gdelattre.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
 
@ManagedBean
@RequestScoped
public class UserBean implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
 
	public String getUserName() {
		return userName;
	}
 
	public void setUserName(String userName) {
		this.userName = userName;
	}
}