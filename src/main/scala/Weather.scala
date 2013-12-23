package com.gautam

import javax.ws.rs.{GET, Produces, Path}
import rapture.io._

@Path("/weather")
class Weather {
    import org.apache.commons.httpclient._, methods._, params._, cookie._
    import java.io._;
    
    @GET
    def weather() = {
        val url = "http://query.yahooapis.com/v1/public/yql?q=select%20item%20from%20weather.forecast%20where%20location%3D%2210001%22&format=json"
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
            val json = Json.parse(result)
            val x: Json = json.query.results.channel.item.condition.temp
            val y: String = x.get[String]
            result = y
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