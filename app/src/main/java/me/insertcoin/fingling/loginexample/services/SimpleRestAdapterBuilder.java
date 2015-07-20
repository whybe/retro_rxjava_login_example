package me.insertcoin.fingling.loginexample.services;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class SimpleRestAdapterBuilder implements RestAdapterBuilder {
    public static final String BASE_URL = "http://192.168.0.23:8000/";
    private static final RestAdapter.LogLevel LOG_LEVEL = RestAdapter.LogLevel.FULL;
    private static final long CACHE_SIZE = 10 * 1024 * 1024;

    private String endpoint = BASE_URL;
    private File cacheDir = null;
    private long cacheSize = CACHE_SIZE;
    private RequestInterceptor requestInterceptor = null;
    private RestAdapter.LogLevel logLevel = LOG_LEVEL;

    public SimpleRestAdapterBuilder() {

    }

    @Override
    public SimpleRestAdapterBuilder endpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    @Override
    public SimpleRestAdapterBuilder useCache(File cacheDir) {
        this.cacheDir = cacheDir;
        return this;
    }

    @Override
    public SimpleRestAdapterBuilder useCache(File cacheDir, long cacheSize) {
        this.cacheDir = cacheDir;
        this.cacheSize = cacheSize;
        return this;
    }

    @Override
    public SimpleRestAdapterBuilder requestInterceptor(RequestInterceptor requestInterceptor) {
        this.requestInterceptor = requestInterceptor;
        return this;
    }

    @Override
    public SimpleRestAdapterBuilder logLevel(RestAdapter.LogLevel logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    @Override
    public RestAdapter build() {
        OkHttpClient httpClient = new OkHttpClient();
        if (cacheDir != null) {
            httpClient.setCache(new Cache(cacheDir, cacheSize));
        }

        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setEndpoint(endpoint)
                .setClient(new OkClient(httpClient))
                .setLogLevel(logLevel);

        if (requestInterceptor != null) {
            builder.setRequestInterceptor(requestInterceptor);
        }

        return builder.build();
    }
}
