package me.insertcoin.fingling.loginexample.models;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by yb on 7/20/15.
 */
public class SignUpUser {

    private String username;
    private final String password;
    private String email;

    public SignUpUser(String username, String password, String email) {
        this.username = username;
        this.password = username;
        this.email = email;
    }
}
