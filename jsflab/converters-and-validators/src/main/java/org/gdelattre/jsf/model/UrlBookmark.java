package org.gdelattre.jsf.model;

public class UrlBookmark{
	 
	String fullURL;
 
	public UrlBookmark(String fullURL) {
		this.fullURL = fullURL;
	}
 
	public String getFullURL() {
		return fullURL;
	}
 
	public void setFullURL(String fullURL) {
		this.fullURL = fullURL;
	}
 
	public String toString(){
		return fullURL;
	}
 
}