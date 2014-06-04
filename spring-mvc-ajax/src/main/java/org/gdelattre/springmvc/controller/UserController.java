package org.gdelattre.springmvc.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.gdelattre.springmvc.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	private static Map<String, UserDTO> users = new HashMap<String, UserDTO>();
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody UserDTO getUser(@PathVariable String id,
										 @RequestHeader MultiValueMap<String,String> headers) {
		
		UserDTO user; 
		
		user = users.get(id);
		
		return user;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody String saveUser(@RequestBody UserDTO user) {
		
		user.setId(UUID.randomUUID().toString());
		users.put(user.getId(), user);
		
//		final ObjectMapper mapper = new ObjectMapper();
//		try {
//			System.out.println("userString : " + mapper.writeValueAsString(user));
//		} catch (JsonGenerationException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		return user.getId();
	}
	
	@RequestMapping(value = "/get-all-users", method = RequestMethod.GET)
	public @ResponseBody Iterable<UserDTO> getAllUsers() {
		Iterable<UserDTO> allUsers; 
		
		allUsers = users.values();
		
		return allUsers;
	}
	
}