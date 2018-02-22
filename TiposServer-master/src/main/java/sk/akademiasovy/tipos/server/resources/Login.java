package sk.akademiasovy.tipos.server.resources;



import javax.annotation.PostConstruct;
import javax.servlet.Registration;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonProperty;
import sk.akademiasovy.tipos.server.Credentials;
import sk.akademiasovy.tipos.server.User;
import sk.akademiasovy.tipos.server.db.MySQL;

/**
 * Created by host on 20.2.2018.
 */

@Path("/auth")
public class Login {

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkCredentials(Credentials credential){
        System.out.println(credential.getUsername());
        MySQL mySQL = new MySQL();
        User user=mySQL.getUser(credential.username, credential.password);
        if(user==null){
            return "{}";
        }
        else{
            return "{\"token\":\""+user.getToken()+"\"}";
        }

    }


    @POST
    @Path("/registration")
    @Produces(MediaType.APPLICATION_JSON)
    public String createNewUser (Registration registration)
    {

        MySQL mySQL=new MySQL();
        boolean exist=mySQL.checkIfEmailOrLoginExist(registration.login, registration.email);
        if(exist)
        {
         return "";
        }
        return "";

    }

    class Registration
    {
        @JsonProperty
        public String firstname;
        @JsonProperty
        public String lastname;
        @JsonProperty
        public String login;
        @JsonProperty
        public String email;
        @JsonProperty
        public String password;

    }
}
