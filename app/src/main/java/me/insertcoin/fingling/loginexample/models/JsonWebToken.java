package me.insertcoin.fingling.loginexample.models;

/**
 * Created by yb on 7/20/15.
 */
public class JsonWebToken {
    private static JsonWebToken instance = null;

    private String token = "";

    public JsonWebToken() {

    }

    public static JsonWebToken getInstance() {
        if (instance == null) {
            synchronized (JsonWebToken.class) {
                if (instance == null) {
                    instance = new JsonWebToken();
                }
            }
        }

        return instance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
