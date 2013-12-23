package com.gautam

import javax.ws.rs.{GET, Produces, Path, QueryParam}
import javax.ws.rs.core.MediaType

@Path("/helloscala")
class HelloScala {
  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def hello(
      @QueryParam("username") username: String) = { 
      "{\"username\": \"" + username + "\"}" 
  }
}