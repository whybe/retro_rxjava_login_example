package me.insertcoin.fingling.loginexample.services;

import me.insertcoin.fingling.loginexample.models.JsonWebToken;
import me.insertcoin.fingling.loginexample.models.SignInUser;
import me.insertcoin.fingling.loginexample.models.SignUpUser;
import me.insertcoin.fingling.loginexample.models.User;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by yb on 7/17/15.
 */

public interface LoginWebService {
    @POST("/api-token-auth/")
    Observable<JsonWebToken> signIn(@Body SignInUser signInUser);

    @POST("/users/?format=json")
    Observable<User> signUp(@Body SignUpUser user);
}


