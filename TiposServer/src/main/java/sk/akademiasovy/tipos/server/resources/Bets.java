package sk.akademiasovy.tipos.server.resources;

import sk.akademiasovy.tipos.server.Credentials;
import sk.akademiasovy.tipos.server.Ticket;
import sk.akademiasovy.tipos.server.User;
import sk.akademiasovy.tipos.server.db.MySQL;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by host on 22.2.2018.
 */
@Path("/bets")
public class Bets {

    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newTicket(Ticket ticket){
      MySQL mySQL=new MySQL();
        boolean ret1 = mySQL.checkLogin(ticket.login);
        boolean ret2 = mySQL.checkToken(ticket.token);
        if(ret1 && ret2) {
            System.out.println("Token and username are correct!");
            mySQL.insertBets(ticket);
            return Response.status(201).build();
        }
        else
        {
            System.out.println("Invalid username or token");
            return Response.status(401).build();
        }
     // return Response.status(201).build();
    }
}
