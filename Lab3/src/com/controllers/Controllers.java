package com.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello") 
public class Controllers {

	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
	    return "Hello text aditya";
	  }
	  
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public String sayXMLHello() {
	    return "<?xml version=\"1.0\"?>" + "<hello> Hello XML Jersey" + "</hello>";
	  }

	  // This method is called if HTML is request
	  @GET
	  @Produces(MediaType.TEXT_HTML)
	  public String sayHtmlHello() {
	    return "<html> " + "<title>" + "Hello HTml Jersey" + "</title>"
	        + "<body><h1>" + "Hello Jersey" + "</h1></body>" + "</html> ";
	  }

}
