package lu.uni2013.tp4.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * User: schullto
 * Date: 11/21/13
 * Time: 6:47 PM
 */
@Path("/helloWorld")
public class HelloWorldRestService {
    @GET
    @Produces("text/plain")
    public String getHelloWorld() {
        return "HelloWorld";
    }
}