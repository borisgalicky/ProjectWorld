package sk.akademiasovy.world.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorld{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getGreeting(){
        return "Hello, I'm server!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String about(){
        return "{\"Firstname\" :\"Ivan\", \"Lastname\" :\"Hrozný\",\"Age\": \"89\"}";
    }
}
