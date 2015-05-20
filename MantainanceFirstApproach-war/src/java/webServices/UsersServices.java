/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import Users.User;
import Users.UsersHandlerSessionBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
/*import com.google.gson.Gson;
import com.google.gson.GsonBuilder;*/

//import javax.enterprise.context.RequestScoped;

/**
 * REST Web Service
 *
 * @author Franz
 */
@Path("Users")
//@RequestScoped
public class UsersServices {

    @Context
    private UriInfo context;

    public UsersServices() {
    }

    @EJB
    private UsersHandlerSessionBean UserHandler;
    
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    
    @PUT
    @Path("CreateUser")
    @Consumes("application/x-www-form-urlencoded")
    public Response createUser(            
            @FormParam ("Name")String name,
            @FormParam ("Id") int id,
            @FormParam ("Password") String password
            ) 
    {
        System.out.println("Creo usuario: "+name+" - "+ password+" - "+ id);
        
        UserHandler.createUser(name, id, password);        
        
        ResponseBuilder rb = Response.ok();
        rb.expires(new Date());
        return rb.build();
    }
    
    @POST
    @Path("ModifyUser")
    @Consumes("application/x-www-form-urlencoded")
    public Response ModifyUser(            
            @FormParam ("NewName")String newName,
            @FormParam ("Id") int id,
            @FormParam ("NewPassword") String newPassword
            ) 
    {
        System.out.println("Modifico usuario: "+newName+" - "+ newPassword+" - "+ id);
        
        UserHandler.modifyUser(newName, id, newPassword);        
        
        ResponseBuilder rb = Response.ok();
        rb.expires(new Date());
        return rb.build();
    }
    
    @POST
    @Path("DeleteUser")
    @Consumes("application/x-www-form-urlencoded")
    public Response DeleteUser( 
            @FormParam ("Id") int id
            ) 
    {
        System.out.println("Elimino usuario: "+ id);
        
        UserHandler.deleteUser(id);        
        
        ResponseBuilder rb = Response.ok();
        rb.expires(new Date());
        return rb.build();
    }
    
    @GET
    @Path("GetUsers")
    @Produces("application/json")
    public Response getUsers(){
        System.out.println("Obtengo todos los ususarios");
        List<User> returnList = UserHandler.getUsers();
        
        Gson response = new GsonBuilder().create();
        return Response.accepted(response.toJson(returnList)).build();
    }
    
    @GET
    @Path("GetUser/{userID}")
    @Produces("application/json")
    public Response getUserByID(@PathParam ("userID")int userID){
        System.out.println("Obtengo el usuario de ID:  " + userID);
        User returnUser = UserHandler.getUser(userID);
        Gson response = new GsonBuilder().create();
        return Response.accepted(response.toJson(returnUser)).build();
    }
}
