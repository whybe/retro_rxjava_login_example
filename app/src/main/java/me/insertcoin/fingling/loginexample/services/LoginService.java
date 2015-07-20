package me.insertcoin.fingling.loginexample.services;

import android.content.Context;

import me.insertcoin.fingling.loginexample.models.JsonWebToken;
import me.insertcoin.fingling.loginexample.models.SignInUser;
import me.insertcoin.fingling.loginexample.models.SignUpUser;
import me.insertcoin.fingling.loginexample.models.User;
import retrofit.RestAdapter;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by yb on 7/17/15.
 */
public class LoginService {

    private final LoginWebService loginWebService;

    public LoginService(Context context) {
        RestAdapter restAdapter = new SimpleRestAdapterBuilder()
                .useCache(context.getCacheDir())
                .requestInterceptor(new JsonRequestInterceptor())
                .build();
        loginWebService = restAdapter.create(LoginWebService.class);
    }

    public Observable<JsonWebToken> signIn(final String username, final String password) {
        return loginWebService.signIn(new SignInUser(username, password));
    }

    public Observable<User> singUp(final String username, final String password, final String email) {
        return loginWebService.signUp(new SignUpUser(username, password, email));
    }

    public Observable<Void> signOut() {
        return Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                JsonWebToken.getInstance().setToken("");
                subscriber.onNext(null);
                subscriber.onCompleted();
            }
        });
    }
}
