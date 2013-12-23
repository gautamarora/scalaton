package com.gautam

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import javax.servlet.ServletException
import java.io.IOException
 
import org.eclipse.jetty.server.{Server, Request}
import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.nio.SelectChannelConnector
import org.eclipse.jetty.servlet.{ServletHolder, ServletContextHandler}
import com.sun.jersey.spi.container.servlet.ServletContainer

object WebRunner {
  def main(args: Array[String]) {

    val server = new Server(8080)
    val connector = new SelectChannelConnector()
    server.addConnector(connector)
    
    val holder:ServletHolder = new ServletHolder(classOf[ServletContainer])
    holder.setInitParameter("com.sun.jersey.config.property.resourceConfigClass",
                            "com.sun.jersey.api.core.PackagesResourceConfig")
    holder.setInitParameter("com.sun.jersey.config.property.packages",
                            "com.gautam")
    val context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS)
    context.addServlet(holder, "/*")
    server.start
    server.join
  }
}