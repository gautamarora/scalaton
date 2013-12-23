package com.gautam

import javax.ws.rs.{GET, Produces, Path}

@Path("/calculator")
class Calculator {
    import org.apache.commons.httpclient._, methods._, params._, cookie._
    import java.io._;
    
    @GET
    def calculate() = {
        val url = "http://www.google.com/ig/calculator?q=1USD=?INR"
        val client = new HttpClient()
        val method = new GetMethod(url)
        var result:String = ""
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false))
        try {
            client.executeMethod(method)
            val statusLine = method.getStatusLine()
            result = statusLine.toString()
            var responseBody:Array[Byte] = method.getResponseBody();
            result = new String(responseBody)
        } catch {
            case e:HttpException => println("http exception")
            case e:IOException => println("http exception")
            case e:Exception => println("exception")
        } finally {
            method.releaseConnection()
        }
        result
    }
}

