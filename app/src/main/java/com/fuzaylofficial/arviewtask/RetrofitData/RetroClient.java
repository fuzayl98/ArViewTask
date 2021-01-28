package com.fuzaylofficial.arviewtask.RetrofitData;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {

        private static final String BASE_URL = "https://api.twitch.tv/helix/games/";
        private static RetroClient mInstance;
        private Retrofit retrofit;

        private RetroClient() {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(HttpClients.client())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        public static synchronized RetroClient getInstance() {
            if (mInstance == null) {
                mInstance = new RetroClient();
            }
            return mInstance;
        }

        public GetGames getGames(){
            return retrofit.create(GetGames.class);
        }
}
