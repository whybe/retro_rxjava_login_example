package me.insertcoin.fingling.loginexample.models;

import android.content.ClipData;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by yb on 7/17/15.
 */
public class User {
    private int id;
    private String url;
    private String username;
    private String email;
    private List<Item> items;
    private List<Like> likes;

    public String toJson() {
        return new Gson().toJson(this);
    }
}
