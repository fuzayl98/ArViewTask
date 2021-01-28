package com.fuzaylofficial.arviewtask.Room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.fuzaylofficial.arviewtask.RetrofitData.Games;

@Database(entities = {Games.Game.class},version = 1,exportSchema = false)

public abstract class GamesDatabase extends RoomDatabase {

    private static GamesDatabase instance;

    public abstract GamesDAO gamesDAO();

    public static synchronized GamesDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),GamesDatabase.class,"game_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static Callback roomCallBack = new Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void> {
        private GamesDAO gamesDAO;

        private PopulateDBAsyncTask(GamesDatabase db){
            gamesDAO = db.gamesDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
