package org.gdelattre.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.Map;
 
@ManagedBean
@RequestScoped
public class UserBean implements Serializable {
	
	private static Logger logger = Logger.getLogger(UserBean.class);
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String nickname;
	
	private int age;
 
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}
 
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String outcome() {
		
		final FacesContext facesContext = FacesContext.getCurrentInstance();
		final Map<String,String> params =  facesContext.getExternalContext().getRequestParameterMap();
		 
		String country = params.get("country");
		
		logger.info("country : " + country);
		
		return "default";
	}
	
	public void attrListener(ActionEvent event){
		 
		this.nickname = (String)event.getComponent().getAttributes().get("username");
		
		logger.info("nickname = " + this.nickname);
	 
	  }
	
	public String outcome1(){
		return "result";
	}
 
	public String getNickname() {
		return nickname;
	}
 
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}