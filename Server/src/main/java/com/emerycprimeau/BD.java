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
    public static int UserId = 0;

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


    public void InitUsers() {
        listUser.add(new User(UserId++, "George", 0 ));
        listUser.add(new User(UserId++, "Marc", 0 ));
        listUser.add(new User(UserId++, "Joris", 0 ));
        listUser.add(new User(UserId++, "Oli", 0 ));
    }

    public Boolean create(LoginRequest user) {
        User u = new User();
        u.name = user.user;
        u.ID = UserId++;
        u.count = 0;
        listUser.add(u);
        return true;
    }
}
