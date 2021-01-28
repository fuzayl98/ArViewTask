package com.fuzaylofficial.arviewtask.Data;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.fuzaylofficial.arviewtask.RetrofitData.Games;
import com.fuzaylofficial.arviewtask.Room.GamesRepository;

public class GamesDataSourceFactory extends DataSource.Factory {
    GamesRepository repository;

    public GamesDataSourceFactory(GamesRepository repository) {
        this.repository = repository;
    }

    private MutableLiveData<PageKeyedDataSource<String, Games.Game>> itemLiveDataSource = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource<String, Games.Game> create() {
        GamesDataSourse dataSourse = new GamesDataSourse(repository);
        itemLiveDataSource.postValue(dataSourse);
        return dataSourse;
    }

    public MutableLiveData<PageKeyedDataSource<String, Games.Game>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
