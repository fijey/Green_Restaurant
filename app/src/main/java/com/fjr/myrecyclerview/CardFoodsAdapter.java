package com.fjr.myrecyclerview;

import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardFoodsAdapter extends RecyclerView.Adapter<CardFoodsAdapter.CardViewHolder> {

    private ArrayList<Foods> listFoods;
    public CardFoodsAdapter(ArrayList<Foods> list) {
        this.listFoods = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_food,viewGroup,false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, int position) {

        final Foods foods = listFoods.get(position);

        Glide.with(holder.itemView.getContext())
                .load(foods.getImage())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);

        holder.nameFoods.setText(foods.getName());
        holder.desc.setText(foods.getDesc());
        holder.ratingbar.setRating(Float.parseFloat(foods.getRating()));

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToDetail = new Intent(holder.itemView.getContext(), Detail.class);
                moveToDetail.putExtra(Detail.EXTRA_NAME,foods.getName());
                moveToDetail.putExtra(Detail.EXTRA_DESC,foods.getDesc());
                moveToDetail.putExtra(Detail.EXTRA_RATING, foods.getRating());
                moveToDetail.putExtra(Detail.EXTRA_IMAGE,foods.getImage());
                moveToDetail.putExtra(Detail.EXTRA_PRICE,foods.getPriceList());
                v.getContext().startActivity(moveToDetail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listFoods.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView nameFoods,desc,priceList;
        RatingBar ratingbar;
        Button btnDetail;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.image_food);
            nameFoods = itemView.findViewById(R.id.food_name);
            desc = itemView.findViewById(R.id.desc);
            ratingbar = itemView.findViewById(R.id.ratingBar);
            btnDetail = itemView.findViewById(R.id.btn_detail);
            priceList = itemView.findViewById(R.id.priceList);

        }
    }
}
