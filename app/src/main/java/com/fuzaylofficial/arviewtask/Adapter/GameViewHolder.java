package com.fuzaylofficial.arviewtask.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fuzaylofficial.arviewtask.RetrofitData.Games;
import com.fuzaylofficial.arviewtask.R;

public class GameViewHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView name,id;

    public GameViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.image_of_game);
        name = itemView.findViewById(R.id.name_of_game);
        id = itemView.findViewById(R.id.id_of_game);

    }

    public void Bind(Games.Game game){
        Glide.with(itemView).load(
                game.getArt_url().replace("{width}","256").replace("{height}","256")
        ).centerCrop().into(img);
        name.setText(game.getGame_name());
        id.setText(String.valueOf(game.getId()));

    }
}
