package com.fuzaylofficial.arviewtask.RetrofitData;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Games {
    @SerializedName("pagination")
    @Expose
    public Cursor cursor;

    public static class Cursor{
        public String getCusor() { return cusor; }
        public void setCusor(String cusor) { this.cusor = cusor; }

        @SerializedName("cursor")
        @Expose
        public String cusor;
    }

    @SerializedName("data")
    List<Game> gameList;
    public List<Game> getGameList() { return gameList; }
    public void setGameList(List<Game> gameList) { this.gameList = gameList; }

    @Entity(tableName = "game_table")
    public static class Game{

        @PrimaryKey(autoGenerate = true)
        private int idauto;
        public int getIdauto() { return idauto; }
        public void setIdauto(int idauto) { this.idauto = idauto; }



        @SerializedName("id")
        @Expose
        public int id;

        @SerializedName("name")
        @Expose
        public String game_name;

        @SerializedName("box_art_url")
        @Expose
        public String art_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGame_name() {
            return game_name;
        }

        public void setGame_nime(String game_nime) {
            this.game_name = game_nime;
        }

        public String getArt_url() {
            return art_url;
        }

        public void setArt_url(String art_url) {
            this.art_url = art_url;
        }
    }



}
