package com.emerycprimeau;

import com.emerycprimeau.exception.*;
import com.emerycprimeau.model.Token;
import com.emerycprimeau.model.User;
import com.emerycprimeau.transfer.*;
import com.google.gson.Gson;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.*;

public class BD {

    public static List<User> listUser = new ArrayList<>();


    public static List<Token> listToken = new ArrayList<>();
    public static final String Cookie = "Cookie-cookie";

    public BD ()
    {
    }


    public User toClick (LoginRequest lR) throws NoMatch {

        for (User s: listUser)
            if(s.name.equals(lR.user))
            {
                s.count++;
                return s;
            }

        throw new NoMatch("NM");
    }

    public User howMany (int id) throws NoMatch {

        for (User s: listUser)
            if(s.ID == id)
            {
                return s;
            }

        throw new NoMatch("NM");
    }


    public Response creerCookie()
    {
//        String token = UUID.randomUUID().toString();
//        NewCookie nC = new NewCookie(Cookie, token, "/","", "id token", 604800, true);
//        listToken.add(new Token(token, s.ID, 604800));
       return null;
    }

    public Response supprimerCookie()
    {
        return null;
    }


    public void InitUsers() {
        listUser.add(new User(0, "George", 0 ));
        listUser.add(new User(1, "Marc", 0 ));
        listUser.add(new User(2, "Joris", 0 ));
        listUser.add(new User(3, "Oli", 0 ));
    }
}
