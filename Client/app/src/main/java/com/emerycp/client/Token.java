package com.emerycp.client;

public class Token {
    public String token;
    public String userId;
    public int expiration;

    public Token(String tk, String id, int exp)
    {
        token = tk;
        userId = id;
        expiration = exp;
    }
}
