package sk.akademiasovy.world.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import sk.akademiasovy.world.db.MySQL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/world")
public class World{
    @GET
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)
        public String getCountries(){
            MySQL mySQL=new MySQL();
            List<String> list= mySQL.getCountries();
            System.out.println(list);
            boolean b =false;
            String result="showCountries({\"name\":[";
            for(String temp:list){
                if(b==true){
                    result+= ',';
                }
                else{
                    b=true;
                }
                result+="\""+temp+"\"";
            }
            result+="]})";
            return result;
        }

    @GET
    @Path("/country/cities")
    @Produces(MediaType.APPLICATION_JSON)
        public String getCities(@PathParam("country") String country){
        System.out.println(country);
            return "showCities({\"name\":\"name\"})";
        }


    @GET
    @Path("/population")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPopulation(City city){
        return city.name;
    }

    public static class City{
        @JsonProperty("name")
        public String name;
    }
}
