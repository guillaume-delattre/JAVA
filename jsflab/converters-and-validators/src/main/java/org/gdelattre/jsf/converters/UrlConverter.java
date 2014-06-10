package org.gdelattre.jsf.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.commons.validator.UrlValidator;
import org.gdelattre.jsf.model.UrlBookmark;

@FacesConverter("org.gdelattre.UrlConverter")
public class UrlConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		String HTTP = "http://";
		StringBuilder url = new StringBuilder();
 
		//if not start with http://, then add it
		if(!value.startsWith(HTTP, 0)){
			url.append(HTTP);
		}
		url.append(value);
 
		//use Apache common URL validator to validate URL
		UrlValidator urlValidator = new UrlValidator();
		//if URL is invalid
		if(!urlValidator.isValid(url.toString())){
 
			FacesMessage msg = 
				new FacesMessage("URL Conversion error.", "Invalid URL format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		}
 
		UrlBookmark urlBookmark = new UrlBookmark(url.toString());
 
		return urlBookmark;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent conponent, Object value) {
		
		return value.toString();
		
	}

}
