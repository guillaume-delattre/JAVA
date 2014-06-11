package org.gdelattre.jsf.user.bean;

import org.gdelattre.jsf.user.User;
 
public class UserBean{
 
        //later inject in faces-config.xml
	User user;
 
	public void setUserBo(User user) {
		this.user = user;
	}
 
	public String printMsgFromSpring() {
 
		return user.getMessage();
 
	}
 
}