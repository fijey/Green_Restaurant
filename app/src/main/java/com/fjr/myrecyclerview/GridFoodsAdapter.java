package com.fjr.myrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridFoodsAdapter extends RecyclerView.Adapter<GridFoodsAdapter.GridViewHolder> {

    private ArrayList<Foods> listFood;

    public GridFoodsAdapter (ArrayList<Foods> list){
        this.listFood = list;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_food,viewGroup,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listFood.get(position).getImage())
                .apply(new RequestOptions().override(355,550))
                .into(holder.imgFoods);

    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoods;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoods= itemView.findViewById(R.id.image_food);

        }
    }
}
