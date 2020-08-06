package com.fjr.myrecyclerview;

import android.content.Intent;
import android.util.Log;
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

public class CardInaFoodsAdapter extends RecyclerView.Adapter<CardInaFoodsAdapter.CardInaViewHolder> {

    private ArrayList<InaFoods> listData;

    public CardInaFoodsAdapter(ArrayList<InaFoods> list) {
        this.listData = list;
    }

    @NonNull
    @Override
    public CardInaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card_food,viewGroup,false);
        return new CardInaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardInaViewHolder holder, int position) {

        final InaFoods inaFoods = listData.get(position);

        Glide.with(holder.itemView.getContext())
                .load(inaFoods.getImage())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPhoto);
        holder.foodsName.setText(inaFoods.getName());
        holder.desc.setText(inaFoods.getDesc());
        holder.ratingBar.setRating(Float.parseFloat(inaFoods.getRating()));

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToDetail = new Intent(holder.itemView.getContext(), Detail.class);
                moveToDetail.putExtra(Detail.EXTRA_NAME, inaFoods.getName());
                moveToDetail.putExtra(Detail.EXTRA_DESC, inaFoods.getDesc());
                moveToDetail.putExtra(Detail.EXTRA_RATING, inaFoods.getRating());
                moveToDetail.putExtra(Detail.EXTRA_IMAGE, inaFoods.getImage());
                moveToDetail.putExtra(Detail.EXTRA_PRICE, inaFoods.getPriceList());
                Log.d("harga", String.valueOf(inaFoods.getPriceList()));
                v.getContext().startActivity(moveToDetail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class CardInaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPhoto;
        private TextView foodsName,desc,priceList;
        private RatingBar ratingBar;
        private Button btnDetail;
        public CardInaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.image_food);
            foodsName = itemView.findViewById(R.id.food_name);
            desc = itemView.findViewById(R.id.desc);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            btnDetail = itemView.findViewById(R.id.btn_detail);
            priceList = itemView.findViewById(R.id.priceList);
        }
    }
}
