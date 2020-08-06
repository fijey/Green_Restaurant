package com.fjr.myrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFoods, rvIna;
    private ArrayList<Foods> list = new ArrayList<>();
    private ArrayList<InaFoods> listIna =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFoods = findViewById(R.id.rv_food);
        rvIna = findViewById(R.id.rv_ina);
        rvIna.setHasFixedSize(true);
        rvFoods.setHasFixedSize(true);

        list.addAll(FoodsData.getListData());
        listIna.addAll(InaFoodsData.getListData());

        showCardList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedId){
        switch (selectedId) {
            case R.id.action_list :
                showRecyclerList();
                break;
            case R.id.action_grid:
                showGridList();
                break;
            case R.id.action_card:
                showCardList();
                break;
        }
    }

    private void showRecyclerList(){
        rvFoods.setLayoutManager(new LinearLayoutManager(this));
        ListFoodsAdapter listFoodsAdapter = new ListFoodsAdapter(list);
        rvFoods.setAdapter(listFoodsAdapter);
    }

    private void showGridList() {
        rvFoods.setLayoutManager(new GridLayoutManager(this,2));
        GridFoodsAdapter gridFoodsAdapter = new GridFoodsAdapter(list);
        rvFoods.setAdapter(gridFoodsAdapter);
    }

    private void showCardList(){
        rvFoods.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        CardFoodsAdapter cardFoodsAdapter = new CardFoodsAdapter(list);
        rvFoods.setAdapter(cardFoodsAdapter);

        rvIna.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        CardInaFoodsAdapter cardInaFoodsAdapter = new CardInaFoodsAdapter(listIna);
        rvIna.setAdapter(cardInaFoodsAdapter);
    }
}