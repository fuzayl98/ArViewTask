package com.fuzaylofficial.arviewtask;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.fuzaylofficial.arviewtask.Data.GamesDataSourceFactory;
import com.fuzaylofficial.arviewtask.RetrofitData.Games;
import com.fuzaylofficial.arviewtask.Room.GamesRepository;

import java.net.InetAddress;

public class GamesViewModel extends AndroidViewModel {
    LiveData<PagedList<Games.Game>> itemPagedList;

    LiveData<PageKeyedDataSource<String, Games.Game>> liveDataSource;

    public GamesViewModel(Application application) {
        super(application);
        GamesRepository repository = new GamesRepository(application);
        GamesDataSourceFactory itemDataSourceFactory = new GamesDataSourceFactory(repository);

        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(20).build();

        if (isOnline(getApplication())){
            Toast.makeText(getApplication(),"Read from server",Toast.LENGTH_SHORT).show();

            itemPagedList = new LivePagedListBuilder(itemDataSourceFactory, pagedListConfig)
                    .build();
        }else{
            Toast.makeText(getApplication(),"Read from local database",Toast.LENGTH_SHORT).show();
            itemPagedList =new LivePagedListBuilder<>(repository.getGetAllGames(),pagedListConfig)
                    .build();
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    return true;
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    return true;
                }  else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)){
                    return true;
                }
            }
        }

        return false;
    }

}
