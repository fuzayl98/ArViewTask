package com.fuzaylofficial.arviewtask.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.fuzaylofficial.arviewtask.RetrofitData.Games;

public class GameDiffUtillCallback extends DiffUtil.ItemCallback<Games.Game> {

    @Override
    public boolean areItemsTheSame(@NonNull Games.Game oldItem, @NonNull Games.Game newItem) {
        return oldItem==newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Games.Game oldItem, @NonNull Games.Game newItem) {
        return oldItem.equals(newItem);
    }
}
