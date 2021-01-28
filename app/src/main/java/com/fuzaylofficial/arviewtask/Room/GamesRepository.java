package com.fuzaylofficial.arviewtask.Room;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.fuzaylofficial.arviewtask.RetrofitData.Games;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class GamesRepository {
    private GamesDAO gamesDAO;
    Context context;
    private  DataSource.Factory<Integer, Games.Game> getAllGames;

    public GamesRepository(Application application){
        GamesDatabase database = GamesDatabase.getInstance(application);
        context = application.getApplicationContext();
        gamesDAO = database.gamesDAO();
        getAllGames = gamesDAO.getAllGames();
    }

    public void InsertsToDatabase(List<Games.Game> games){
        for (Games.Game game: games) {
            if (!hasInDatabase(game.getId())){
                insert(game);
            }
        }
    }

    public void insert(Games.Game gameR){
        new InsertAsyncTask(gamesDAO).execute(gameR);
    }

    public Boolean hasInDatabase(int idgame){
        try {
            return new gethasindatabase(gamesDAO).execute(idgame).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public DataSource.Factory<Integer, Games.Game> getGetAllGames(){
        return getAllGames;
    }

    private static class gethasindatabase extends AsyncTask<Integer, Void, Boolean> {
        GamesDAO contentDAO;

        public gethasindatabase(GamesDAO contentDAO) {
            this.contentDAO = contentDAO;
        }

        @Override
        protected Boolean doInBackground(Integer... strings) {
            return contentDAO.hasInDatabase(strings[0]);
        }

    }

    private static class InsertAsyncTask extends AsyncTask<Games.Game, Void, Void> {

        private GamesDAO contentDAO;

        private InsertAsyncTask(GamesDAO contentDAO){
            this.contentDAO = contentDAO;
        }

        @Override
        protected Void doInBackground(Games.Game... contents) {
            contentDAO.insert(contents[0]);
            return null;
        }
    }
}
