package com.fjr.myrecyclerview;

import java.util.ArrayList;

public class FoodsData {

    private static String[] foodsName = {
            "Sushi",
            "Sashimi",
            "Onigiri"
    };

    private static String[] desc ={
            "Makanan khas Jepang satu ini sangat populer di Indonesia. Kalian pasti pernah merasakan enaknya sushi ini kan? Kamu juga bisa menemukan sushi di berbagai restoran jepang di daerahmu. Varian sushi banyak sekali, tetapi yang paling terkenal California roll, salmon roll, dan dragon roll.",
            "Makanan yang terbuat dari ikan laut segar ini biasanya disajikan saat masih mentah dan dinikmati bersama kecap asin dan perasan lemon. Enak lho!",
            "Nasi kepal khas Jepang ini pas banget buat ganjel perutmu yang sedang keroncongan nih. Bentuknya yang unik sangat disukai pecinta kuliner. Bahkan di Jepang, umumnya onigiri digunakan untuk bekal anak-anak dan dimakan saat piknik. Onigiri ini juga memiliki banyak varian isi. Di antaranya seperti tuna, ayam, salmon, dan beef yakiniku."
    };

    private static int[] image = {
            R.drawable.jp_sushi,
            R.drawable.jp_sashimi,
            R.drawable.jp_onigiri
    };

    private static String[] ratingBar = {
            "5",
            "4",
            "3.5",
    };

    private static int[] priceList = {
        15000,
        19900,
        50000
    };

    static ArrayList<Foods> getListData() {
        ArrayList<Foods> list = new ArrayList<>();
        for (int position = 0; position < foodsName.length; position++) {
            Foods food = new Foods();
            food.setName(foodsName[position]);
            food.setDesc(desc[position]);
            food.setImage(image[position]);
            food.setRating(ratingBar[position]);
            food.setPriceList(priceList[position]);
            list.add(food);
        }
        return list;
    }
}
