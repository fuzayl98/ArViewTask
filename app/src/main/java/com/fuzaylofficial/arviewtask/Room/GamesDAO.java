package com.fuzaylofficial.arviewtask.Room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.fuzaylofficial.arviewtask.RetrofitData.Games;

import java.util.List;

@Dao
public interface GamesDAO {


    @Insert
    void insert(Games.Game gameR);

    @Update
    void update(Games.Game gameR);

    @Delete
    void delete(Games.Game gameR);


    /**ORDER BY id DESC*/
    @Query("SELECT * FROM game_table ORDER BY idauto")
    DataSource.Factory<Integer, Games.Game> getAllGames();

    @Query("SELECT EXISTS(SELECT id FROM game_table WHERE id=:idg LIMIT 1)")
    Boolean hasInDatabase(Integer idg);

}