package com.emerycprimeau.model;

import com.emerycprimeau.transfer.LoginRequest;

import java.util.List;

public class User extends LoginRequest {
    public int ID;
    public String name;
    public int count;

    public User () {}
    public User (int pID, String pName, int pCount) { ID = pID; name = pName; count = pCount; }
}
