package me.insertcoin.fingling.loginexample.services;

import java.io.File;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by yb on 7/20/15.
 */

public interface RestAdapterBuilder {
    SimpleRestAdapterBuilder endpoint(String endpoint);
    SimpleRestAdapterBuilder useCache(File cacheDir);
    SimpleRestAdapterBuilder useCache(File cacheDir, long cacheSize);
    SimpleRestAdapterBuilder requestInterceptor(RequestInterceptor requestInterceptor);
    SimpleRestAdapterBuilder logLevel(RestAdapter.LogLevel logLevel);
    RestAdapter build();
}
