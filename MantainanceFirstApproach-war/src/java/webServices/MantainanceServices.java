package webServices;

import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
//import javax.enterprise.context.RequestScoped;

/**
 * REST Web Service
 *
 * @author Franz
 */
@Path("mantainance")
//@RequestScoped
public class MantainanceServices {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MantainanceServices
     */
    public MantainanceServices() {
    }

    /**
     * Retrieves representation of an instance of webServices.MantainanceServices
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "SOFWAAAAA";
    }

    
    @PUT
    @Path("InsertResource")
    @Consumes("application/x-www-form-urlencoded")
    public Response putJsonResource(
            @FormParam ("Admin")String admin,
            @FormParam ("Password")String password,
            @FormParam ("ResourceName")String name,
            @FormParam ("ResourceDescription") String description,
            @FormParam ("ResourceID") int id
            ) 
    {
        System.out.println("Inserto recurso: "+name+" - "+ description+" - "+ id);
        ResponseBuilder rb = Response.ok();
        rb.expires(new Date());
        return rb.build();
    }
    
    @GET
    @Path("ObtainAllResources")
    @Produces("application/json")
    public String getAllResources(
            /*@FormParam ("Admin")String admin,
            @FormParam ("Password")String password  */         
            ) 
    {
        System.out.println("Obtengo todos los recursos - Admin: " /*+ admin+" - Pass:" + password*/);
        return "RECURSOS";
    }
    
    @GET
    @Path("ObtainResource/{resourceID}")
    @Produces("application/json")
    public String getResourceByID(
            /*@FormParam ("Admin")String admin,
            @FormParam ("Password")String password,*/
            @PathParam ("resourceID")int resourceID                        
            ) 
    {
        System.out.println("Obtengo el recurso de ID:  " + resourceID);
        return "Datos del recurso: "+resourceID;
    }
    
    @POST
    @Path("ModifyResource")
    @Consumes("application/x-www-form-urlencoded")
    public Response modifyResource(
            @FormParam ("Admin")String admin,
            @FormParam ("Password")String password,
            @FormParam ("NewResourceName")String name,
            @FormParam ("NewResourceDescription") String description,
            @FormParam ("ResourceID") int id
            ) 
    {
        System.out.println("Modifico recurso: "+name+" - "+ description+" - "+ id);
        ResponseBuilder rb = Response.ok();
        rb.expires(new Date());
        return rb.build();
    } 
    /*@PUT
    @Path("InsertUser")
    @Consumes("application/x-www-form-urlencoded")
    public Response putJsonUser(
            @FormParam ("Admin")String admin,
            @FormParam ("Password")String password,
            @FormParam ("UserName")String userName,
            @FormParam ("UserPassword") String userPassword,
            @FormParam ("UserID") int userID
            ) 
    {
        System.out.println("Inserto usuario: "+userName+" - "+ userPassword+" - "+ userID);
        ResponseBuilder rb = Response.ok();
        rb.expires(new Date());
        return rb.build();
    }*/
}
