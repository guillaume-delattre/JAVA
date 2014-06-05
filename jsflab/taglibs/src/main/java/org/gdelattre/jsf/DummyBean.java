package org.gdelattre.jsf;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean(name="dummy")
@RequestScoped
public class DummyBean implements Serializable {
 
	int number;
 
	public int getNumber() {
		return number;
	}
 
	public void setNumber(int number) {
		this.number = number;
	}
 
}