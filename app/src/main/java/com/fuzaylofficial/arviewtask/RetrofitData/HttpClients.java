package com.fuzaylofficial.arviewtask.RetrofitData;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpClients {
    public static OkHttpClient client (){
        return new  OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request authorized = original.newBuilder()
                            .header("Authorization", "Bearer uudobpat9l27ckm8h2q6o6fxryrae9")
                            .header("Client-ID","ahuoi1tl0qmqbyi8jo8nitbmuaad7w")
                            .build();
                    return chain.proceed(authorized);
                })
                .build();
    }
}
