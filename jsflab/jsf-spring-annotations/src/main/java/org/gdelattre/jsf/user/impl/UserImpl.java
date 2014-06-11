package org.gdelattre.jsf.user.impl;

import org.gdelattre.jsf.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements User {

	@Override
	public String getMessage() {
		return "JSF 2 + Spring Integration";
	}

}