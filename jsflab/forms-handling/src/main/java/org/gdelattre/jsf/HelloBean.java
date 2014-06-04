package org.gdelattre.jsf;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean
@RequestScoped
public class HelloBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private String name;
 
	public String getName() {
	   return name;
	}
	public void setName(String name) {
	   this.name = name;
	}
	public String getSayWelcome(){
		
//		FacesContext facesContext = FacesContext.getCurrentInstance();
//		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
//		
//		final String charset = "javax.faces.request.charset";
//		
//		if(sessionMap.containsKey(charset)){
//			System.out.println("charset : " + sessionMap.get(charset));
//		}
		
	   if("".equals(name) || name == null){
		return "";
	   }else{
		return "Ajax message : Welcome " + name;
	   }
	}
}