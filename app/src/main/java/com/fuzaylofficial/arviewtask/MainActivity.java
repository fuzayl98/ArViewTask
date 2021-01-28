package com.fuzaylofficial.arviewtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fuzaylofficial.arviewtask.Adapter.GameDiffUtillCallback;
import com.fuzaylofficial.arviewtask.Adapter.GamesAdapter;
import com.fuzaylofficial.arviewtask.RetrofitData.RetroClient;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.game_recycler_view);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);

        GamesViewModel viewModel = new GamesViewModel(getApplication());
        GamesAdapter adapter = new GamesAdapter(new GameDiffUtillCallback());

        viewModel.itemPagedList.observe(MainActivity.this,adapter::submitList);
        //viewModel.offlineList.observe(MainActivity.this,adapter::submitList);
        recyclerView.setAdapter(adapter);
    }
}