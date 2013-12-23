package com.gautam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hellojava")
public class HelloJava {
  @GET
  public String hello() {
    return "Hello";
  }
}