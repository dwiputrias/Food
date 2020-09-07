package com.dwiputri.greatfood.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dwiputri.greatfood.R;
import com.dwiputri.greatfood.Splashscreen;

import java.util.ArrayList;
import java.util.List;

public class Frag_Terbaru extends Fragment {

    List<Splashscreen> lstFood;
    private Context mContext;
    private RecyclerView recyclerView2;
    private TerbaruAdapter adapter;
    private ArrayList<Terbaru> terbaruArrayList;
//    private ArrayList<Terbaru> arraylist;
    View frag2_terbaru ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        frag2_terbaru = inflater.inflate(R.layout.activity_frag__terbaru, container, false);

        dataTerbaru();
        recyclerView2 = (RecyclerView) frag2_terbaru.findViewById(R.id.recycler_view);
        adapter = new TerbaruAdapter(getContext(), terbaruArrayList);
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView2.setAdapter(adapter);

        return frag2_terbaru;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void dataTerbaru() {
        terbaruArrayList = new ArrayList<>();
        terbaruArrayList.add(new Terbaru("Jajangmyeon", "Rp.40.000", R.drawable.jajangmyeon, "Jajangmyeon (atau jjajangmyeon) adalah jenis Masakan Korea yaitu mi saus pasta kacang kedelai hitam. Jajangmyeon dipengaruhi kuliner Tionghoa, dan orang Tiongkok biasa menyebutnya Zhajiangmian (炸醬麵). Jajang artinya saus goreng, dan myeon artinya mi."));
        terbaruArrayList.add(new Terbaru("Tteokbokki", "Rp.41.000", R.drawable.tteokbokki, "Tteokbokki adalah penganan Korea berupa tteok dari tepung beras yang dimasak dalam bumbu gochujang yang pedas dan manis. Tteok yang dipakai berbentuk batang atau silinder. Penganan ini merupakan makanan rakyat yang banyak dijual di pojangmacha."));
        terbaruArrayList.add(new Terbaru("Rendang", "Rp.50.000", R.drawable.rendang, "Rendang atau randang (Jawi: رندڠ) adalah masakan daging bercita rasa pedas yang menggunakan campuran dari berbagai bumbu dan rempah-rempah. Masakan ini dihasilkan dari proses memasak yang dipanaskan berulang-ulang dengan santan kelapa."));
        terbaruArrayList.add(new Terbaru("Soto Ayam", "Rp.15.500", R.drawable.soto, "Soto ayam berupa sejenis sup ayam dengan kuah yang berwarna kekuningan. Warna kuning ini dikarenakan oleh kunyit yang digunakan sebagai bumbu."));
        terbaruArrayList.add(new Terbaru("Fish and Chips", "Rp.35.200", R.drawable.fish_and_chips, "Fish and chips (dalam bahasa Inggris berarti Ikan dan kentang) adalah makanan pesan-bawa yang paling terkenal yang berasal dari Britania Raya. Makanan ini terdiri dari ikan (secara tradisional cod) ditepungi dengan tepung roti dan dimakan bersama kentang goreng yang dipotong panjang."));
        terbaruArrayList.add(new Terbaru("Pancake", "Rp.20.500", R.drawable.pancake, "Pancake (dalam bahasa Belanda: pannenkoek) adalah kue dadar yang dibuat dari terigu, telur, gula, dan susu."));
        terbaruArrayList.add(new Terbaru("Risotto", "Rp.14.300", R.drawable.rissoto, "Risotto /rᵻˈzɒtoʊ, rᵻˈzoʊtoʊ/ (bahasa Italia: [riˈsɔtto]; Italia Utara: [riˈzɔtto]) adalah hidangan nasi campur khas Italia Utara, yaitu beras yang dimasak dengan kaldu sehingga lengket menyerupai krim. Kaldu yang digunakan dapat berasal dari daging, ikan, atau sayuran. Banyak jenis risotto mengandung mentega, keju, anggur, dan bawang. Risotto adalah cara paling lazim memasak nasi di Italia."));
    }
}
