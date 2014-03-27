package org.gdelattre.cxf.hello.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 * Web-service :
 *   1- Hello world
 *   2- Hello with a parameter in the path
 *   3- Methode producing a response in JSON format
 * @author gdelattre
 *
 */
@Path("/")
public interface HelloWorld {
	
	@Path("HelloWorld/")
	@GET
	public Response hello();
	
	@Path("hello/")
	@GET
	public Response helloWithParam(@QueryParam("param") String param);
	
	@Path("jsonTest/{id}/{password}")
	@GET
	@Produces("application/json")
	public Response jsonTest(@PathParam("id") int id,
							 @PathParam("password") final String password);
	
	@Path("xmlTest/{id}/{password}")
	@GET
	@Produces("application/xml")
	public Response xmlTest(@PathParam("id") int id,
							 @PathParam("password") final String password);
}
