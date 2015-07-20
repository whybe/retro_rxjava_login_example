package me.insertcoin.fingling.loginexample.services;

import retrofit.RequestInterceptor;

/**
 * Created by yb on 7/20/15.
 */
public class JsonRequestInterceptor implements RequestInterceptor {
    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("Content-Type", "application/json");
    }
}
