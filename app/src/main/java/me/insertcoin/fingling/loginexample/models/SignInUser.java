package me.insertcoin.fingling.loginexample.models;

/**
 * Created by yb on 7/20/15.
 */
public class SignInUser {

    private String username;
    private String password;

    public SignInUser() {

    }

    public SignInUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
