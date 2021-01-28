package com.fuzaylofficial.arviewtask.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.fuzaylofficial.arviewtask.RetrofitData.Games;
import com.fuzaylofficial.arviewtask.R;

public class GamesAdapter extends PagedListAdapter<Games.Game, GameViewHolder> {
    @Override
    public void submitList(@Nullable PagedList<Games.Game> pagedList) {
        super.submitList(pagedList);
    }

    public GamesAdapter(@NonNull DiffUtil.ItemCallback<Games.Game> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item,parent,false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        holder.Bind(getItem(position));
    }
}
