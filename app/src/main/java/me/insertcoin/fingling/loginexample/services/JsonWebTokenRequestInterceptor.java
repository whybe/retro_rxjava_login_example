package me.insertcoin.fingling.loginexample.services;

import me.insertcoin.fingling.loginexample.models.JsonWebToken;
import retrofit.RequestInterceptor;
import retrofit.http.Headers;

/**
 * Created by yb on 7/20/15.
 */
public class JsonWebTokenRequestInterceptor extends JsonRequestInterceptor implements RequestInterceptor {
    @Override
    public void intercept(RequestFacade request) {
        super.intercept(request);
        request.addHeader("Authorization", "JWT " + JsonWebToken.getInstance().getToken());
    }
}
