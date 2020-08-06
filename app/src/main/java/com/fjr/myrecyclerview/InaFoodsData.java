package com.fjr.myrecyclerview;

import java.util.ArrayList;

public class InaFoodsData {
    private static String[] foodsName = {
            "Sate Ayam",
            "Sate Kambing",
            "Nasi Goreng"
    };

    private static String[] desc ={
            "Sate atau satai adalah makanan yang terbuat dari daging yang dipotong kecil-kecil dan ditusuk sedemikian rupa dengan tusukan lidi tulang daun kelapa atau bambu kemudian dipanggang menggunakan bara arang kayu. Sate disajikan dengan berbagai macam bumbu yang bergantung pada variasi resep sate.",
            "Sate kambing adalah sejenis makanan sate terbuat dari daging kambing. Daging kambing tersebut disate dan dibumbui dengan rempah-rempah dan bumbu dapur, kemudian dibakar. Penyajiannya disajikan bersama lalapan kubis, tomat, dan bawang merah yang diiris tipis kemudian diberi kecap dan ditambahkan taburan merica",
            "Nasi goreng adalah sebuah makanan berupa nasi yang digoreng dan diaduk dalam minyak goreng, margarin atau mentega, biasanya ditambah kecap manis, bawang merah, bawang putih, asam jawa, lada dan bumbu-bumbu lainnya, seperti telur, ayam, dan kerupuk."
    };

    private static int[] image = {
            R.drawable.ina_sate_ayam,
            R.drawable.ina_sate_kambing,
            R.drawable.ina_nasi_goreng
    };

    private static String[] ratingBar = {
            "4.5",
            "3",
            "2.5",
    };

    private static int[] priceList = {
            35000,
            49900,
            21000
    };

    static ArrayList<InaFoods> getListData() {
        ArrayList<InaFoods> list = new ArrayList<>();
        for (int position = 0; position < foodsName.length; position++) {
            InaFoods inaFood = new InaFoods();
            inaFood.setName(foodsName[position]);
            inaFood.setDesc(desc[position]);
            inaFood.setImage(image[position]);
            inaFood.setRating(ratingBar[position]);
            inaFood.setPriceList(priceList[position]);
            list.add(inaFood);
        }
        return list;
    }
}
