package org.gdelattre.cxf.hello.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.gdelattre.cxf.hello.service.HelloWorld;
import org.gdelattre.cxf.hello.service.model.User;

public class HelloWorldImpl implements HelloWorld {

	@Override
	@Path("/HelloWorld")
	@GET
	public Response hello() {
		
		return Response.ok().entity("Hello World !!!!").build();
	}

	@Override
	@Path("/hello")
	@GET
	public Response helloWithParam(@QueryParam("param") final String param){
		
		return Response.ok().entity("Hello " + param).build();
		
	}
	
	@Path("jsonTest/{id}/{password}")
	@GET
	@Produces("application/json")
	public Response jsonTest(@PathParam("id") final int id,
							 @PathParam("password") final String password){
		
		
		
		final User user = new User();
		user.setId("un");
		user.setPassword("passwordvalue");
		
		return Response.ok().type("application/json").entity(user).build();
		  
	}
	
	@Path("xmlTest/{id}/{password}")
	@GET
	@Produces("application/xml")
	public Response xmlTest(@PathParam("id") int id,
							@PathParam("password") final String password){
		
		final User user = new User();
		user.setId("un");
		user.setPassword("passwordvalue");
		
		return Response.ok().type("application/xml").entity(user).build();
		
	}
}
