package org.gdelattre.jsf.user.bean;

import org.gdelattre.jsf.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 
@Component
@Scope("session")
public class UserBean{
	
	@Autowired
	User user;
 
	public void setUser(User user) {
		this.user = user;
	}
 
	public String printMsgFromSpring() {
		return user.getMessage();
	}

}
