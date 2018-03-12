package com.common.utils;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by linlipin on 18/1/1.
 */

public class OkHttpUtil {
    private static final String TAG = "OkHttpUtil";
    private static OkHttpClient httpClient;
    private static final MediaType JSON =
            MediaType.parse("application/json; charset=utf-8");

    private static String baseUrl = "";

    public OkHttpUtil() {
        if (httpClient == null) {
            httpClient = new OkHttpClient.Builder()
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();
        }
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        OkHttpUtil.baseUrl = baseUrl;
    }

    public static String makeUrl(String url) {
        if (url != null && !url.isEmpty()) {
            return getBaseUrl() + url;
        }
        return baseUrl;
    }

    public static OkHttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = new OkHttpClient.Builder()
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();
        }
        return httpClient;
    }

    public static Request buildGetRequest(String url) {
        Request request = new Request.Builder()
                .url(makeUrl(url))
                .build();
        return request;
    }

    public static Request buildPostRequest(String url, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(makeUrl(url))
                .post(body)
                .build();
        return request;
    }


    public static Request buildPostRequest(String url, RequestBody requestBody) {
        Request request = new Request.Builder()
                .url(makeUrl(url))
                .post(requestBody)
                .build();
        return request;
    }

    public static Request buildPutRequest(String url, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(makeUrl(url))
                .put(body)
                .build();
        return request;
    }

    public static Request buildDeleteRequest(String url, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(makeUrl(url))
                .delete(body)
                .build();
        return request;
    }

    public static Call newGetCall(String url) {
        Call call = getHttpClient().newCall(buildGetRequest(url));
        return call;
    }

    public static Call newPostCall(String url, String json) {
        return getHttpClient().newCall(buildPostRequest(url, json));
    }

    public static Call newPutCall(String url, String json) {
        return getHttpClient().newCall(buildPutRequest(url, json));
    }

    public static Call newDeleteCall(String url, String json) {
        return getHttpClient().newCall(buildDeleteRequest(url, json));
    }

    public static void enqueueGet(String url, Callback callback) {
        try {
            getHttpClient()
                    .newCall(buildGetRequest(url))
                    .enqueue(callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enqueuePost(String url, String json, Callback callback) {
        try {
            getHttpClient()
                    .newCall(buildPostRequest(url, json))
                    .enqueue(callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enqueuePost(String url, RequestBody requestBody, Callback callback) {
        try {
            getHttpClient()
                    .newCall(buildPostRequest(url, requestBody))
                    .enqueue(callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enqueuePut(String url, String json, Callback callback) {
        try {
            getHttpClient()
                    .newCall(buildPutRequest(url, json))
                    .enqueue(callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Response executeGet(String url) throws IOException {
        return getHttpClient()
                .newCall(buildGetRequest(url))
                .execute();

    }

    public static Response executePost(String url, RequestBody requestBody) throws IOException {
        return getHttpClient()
                .newCall(buildPostRequest(url, requestBody))
                .execute();
    }

    public static Response executePost(String url, String json) throws IOException {
        return getHttpClient()
                .newCall(buildPostRequest(url, json))
                .execute();
    }


    public static Response executePut(String url, String json) throws IOException {
        return getHttpClient()
                .newCall(buildPutRequest(url, json))
                .execute();
    }



}
