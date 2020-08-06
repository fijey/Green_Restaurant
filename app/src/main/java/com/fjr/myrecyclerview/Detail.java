package com.fjr.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {
    public static final String EXTRA_NAME="extra_name";
    public static final String EXTRA_DESC = "desc";
    public static final String EXTRA_RATING="extra_rating";
    public static final String EXTRA_IMAGE ="extra_img";
    public static final String EXTRA_PRICE = "extra_price";

    private TextView nameFoods,desc,priceList;
    private RatingBar ratingbar;
    private ImageView imageFoods;
    private RecyclerView rvRekomen;

    private ArrayList<Foods> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameFoods = findViewById(R.id.food_name);
        desc = findViewById(R.id.desc);
        ratingbar = findViewById(R.id.ratingBar);
        imageFoods = findViewById(R.id.image_food);
        rvRekomen = findViewById(R.id.rv_rekomen);
        priceList = findViewById(R.id.priceList);

        rvRekomen.setHasFixedSize(true);

        String nameFoodsExtra = getIntent().getStringExtra(EXTRA_NAME);
        int imageFoodsExtra = getIntent().getIntExtra(EXTRA_IMAGE,0);
        String descExtra = getIntent().getStringExtra(EXTRA_DESC);
        String ratingBarExtra = getIntent().getStringExtra(EXTRA_RATING);
        int priceListExtra= getIntent().getIntExtra(EXTRA_PRICE,0);

        nameFoods.setText(nameFoodsExtra);
        desc.setText(descExtra);
        assert ratingBarExtra != null;
        ratingbar.setRating(Float.parseFloat(ratingBarExtra));
        priceList.setText("RP. "+ priceListExtra);


        Glide.with(this).load(imageFoodsExtra)
                .into(imageFoods);

        list.addAll(FoodsData.getListData());
        showRecomendList();



    }

    private void showRecomendList(){
        rvRekomen.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        CardFoodsAdapter cardFoodsAdapter = new CardFoodsAdapter(list);
        rvRekomen.setAdapter(cardFoodsAdapter);
    }
}