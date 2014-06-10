package org.gdelattre.jsf;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
@ManagedBean(name="receipt")
@RequestScoped
public class ReceiptBean implements Serializable{
 
	double amount;
	
	Date date;
	 
	public double getAmount() {
		return amount;
	}
 
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Date getDate() {
		return date;
	}
 
	public void setDate(Date date) {
		this.date = date;
	}
 
}
