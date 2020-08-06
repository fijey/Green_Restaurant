package com.fjr.myrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListFoodsAdapter extends RecyclerView.Adapter<ListFoodsAdapter.ListViewHolder> {
    private ArrayList<Foods> listFoods;

    public ListFoodsAdapter(ArrayList<Foods> list) {
        this.listFoods = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_food,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        Foods foods = listFoods.get(position);
        Glide.with(holder.itemView.getContext())
                .load(foods.getImage())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imageFoods);
        holder.nameFoods.setText(foods.getName());
        holder.desc.setText(foods.getDesc());
        String rating = foods.getRating();
        double ratingbar = Double.parseDouble(rating);
        holder.ratingBar.setRating((float) ratingbar);
    }

    @Override
    public int getItemCount() {
        return listFoods.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageFoods;
        TextView nameFoods, desc;
        RatingBar ratingBar;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imageFoods=itemView.findViewById(R.id.image_food);
            nameFoods = itemView.findViewById(R.id.food_name);
            desc = itemView.findViewById(R.id.desc);
            ratingBar = itemView.findViewById(R.id.ratingBar);


        }
    }
}
