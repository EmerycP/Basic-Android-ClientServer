package com.emerycprimeau;

import com.emerycprimeau.exception.*;
import com.emerycprimeau.model.Token;
import com.emerycprimeau.model.User;
import com.emerycprimeau.transfer.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/") // reçoit tout ce qui est dans /api/
public class WebService {

    private BD bd = new BD();
    public WebService(){

    }

    //region Exemple

    //  -> /api/hello/paramName
    @GET @Path("hello/{name}")
    public String helloGET(
            @PathParam("name") String nom
            //@QueryParam("option") String option
    ){
        //if (option==nul) throw new IllegalAccessException();
        return "Hello " + nom;
    }

    //  -> /api/hello/paramName
    @POST
    @Path("hello/{name}")
    public String helloPOST(

            @PathParam("name") String nom
            //@QueryParam("option") String option
    ){
        return "Coucou " + nom;
    }

    @POST
    @Path("null")
    public LoginResponse toLogin(LoginRequest login){
        System.out.println("POST SignIn " + login.user);
        LoginResponse t = new LoginResponse();
        t.Id = Integer.parseInt(UUID.randomUUID().toString());
        t.emailCleaned = login.user;
        return t;
    }

    //endregion


    // --------------------- Code ------------------------- //

    @POST
    @Path("init")
    public void toInit () {
        System.out.println("Init complété!");
        bd.InitUsers();
    }


    @POST
    @Path("click")
    public User toClick (LoginRequest logR) throws NoMatch {
        System.out.println("Utilisateur suivant ajouter une piece! -> " + logR.user);
        return bd.toClick(logR);
    }

    @GET
    @Path("howmany/{id}")
    public User howMany (@PathParam("id")int id) throws NoMatch {
        System.out.println("Utilisateur suivant souhaite savoir combien il y en a au total -> " + id);
        return bd.howMany(id);
    }

//
//    @GET
//    @Path("gameToComplete")
//    public List<Game> getToCompleteList (@CookieParam(BD.Cookie) Cookie cookie) throws TokenNotFound {
//        for(Token u: BD.listToken)
//        {
//            if(cookie.getValue().equals(u.token)) {
//                System.out.println("getToComplete -> " + u.userId);
//                return bd.getToCompleteList(u.userId);
//            }
//        }
//
//        throw new TokenNotFound("TNF");
//    }


}
