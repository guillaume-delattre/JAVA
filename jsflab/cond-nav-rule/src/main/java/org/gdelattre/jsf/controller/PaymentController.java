package org.gdelattre.jsf.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped; 
import java.io.Serializable;
 
@ManagedBean
@SessionScoped
public class PaymentController implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	public boolean registerCompleted = true;
	
	public int orderQty = 101;

	public boolean isRegisterCompleted() {
		return registerCompleted;
	}

	public void setRegisterCompleted(boolean registerCompleted) {
		this.registerCompleted = registerCompleted;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
 
}