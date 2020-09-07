package com.dwiputri.greatfood.Fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
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

public class Frag_Diskon extends Fragment {

    List<Splashscreen> lstFood;
    private Context mContext;
    private RecyclerView recyclerView;
    private DiskonAdapter adapter;
    private ArrayList<Diskon> diskonArrayList;
    private ArrayList<Diskon> arraylist;
    View frag1_diskon ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        frag1_diskon = inflater.inflate(R.layout.activity_frag__diskon, container, false);

        dataDiskon();
        recyclerView = (RecyclerView) frag1_diskon.findViewById(R.id.recycler_view);
        adapter = new DiskonAdapter(getContext(), diskonArrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);

        return frag1_diskon;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void dataDiskon() {
        diskonArrayList = new ArrayList<>();
        diskonArrayList.add(new Diskon("Steik", "Rp.36.300", R.drawable.steak, "Bistik atau steik adalah sepotong besar daging, biasanya daging sapi. Daging merah, dada ayam dan ikan seringkali dipotong menjadi steik. Kebanyakan steik dipotong tegak lurus dengan serat otot, menambah kelegitan daging. Steik biasanya dimasak dengan dipanggang, meskipun dapat digoreng atau di-broil."));
        diskonArrayList.add(new Diskon("Pasta", "Rp.85.000", R.drawable.pasta, "Pasta adalah makanan olahan yang digunakan pada masakan Italia, dibuat dari campuran tepung terigu, olive oil, telur, dan garam yang membentuk adonan yang bisa dibentuk menjadi berbagai variasi ukuran dan bentuk. Pasta dijadikan berbagai hidangan setelah dimasak dengan cara direbus. Di Indonesia, jenis pasta yang populer misalnya spageti, makaroni dan lasagna."));
        diskonArrayList.add(new Diskon("Pizza", "Rp.50.000", R.drawable.pizza, "Piza (atau pizza) adalah hidangan gurih dari Italia sejenis roti bundar dan pipih, yang dipanggang di oven dan biasanya dilumuri saus tomat serta keju dengan bahan makanan tambahan lainnya yang bisa dipilih. Keju yang dipakai biasanya mozzarella atau keju pizza."));
        diskonArrayList.add(new Diskon("Sushi", "Rp.65.500", R.drawable.sushi, "Sushi (鮨, 鮓, atau biasanya すし, 寿司) adalah makanan Jepang yang terdiri dari nasi yang dibentuk bersama lauk (neta) berupa makanan laut, daging, sayuran mentah atau sudah dimasak. Nasi sushi mempunyai rasa masam yang lembut karena dibumbui campuran cuka beras, garam, dan gula."));
        diskonArrayList.add(new Diskon("Tiram", "Rp.35.200", R.drawable.tiram, "Tiram merupakan sumber seng, zat besi, kalsium, dan selenium juga Vitamin A dan Vitmin B12. Namun tiram merupakan makanan yang rendah energi dengan 12 ekor tiram hanya mengandung 110 kilo kalori. Tiram lebih bernutrisi ketika dimakan mentah."));
        diskonArrayList.add(new Diskon("Sate", "Rp.20.500", R.drawable.sate, "Sate adalah makanan yang terbuat dari daging yang dipotong kecil-kecil dan ditusuk sedemikian rupa dengan tusukan lidi tulang daun kelapa atau bambu kemudian dipanggang menggunakan bara arang kayu. Sate disajikan dengan berbagai macam bumbu yang bergantung pada variasi resep sate. Daging yang dijadikan sate antara lain daging ayam, kambing, domba, sapi, babi, kelinci, kuda, dan lain-lain."));
        diskonArrayList.add(new Diskon("Hot Dog", "Rp.14.300", R.drawable.hotdog, "Hot dog adalah suatu jenis sosis yang dimasak atau diasapi dan memiliki tekstur yang lebih halus serta rasa yang lebih lembut dan basah daripada kebanyakan sosis. Hot dog sering dimakan dengan tangan (fingerfood), terutama di Amerika Serikat, dan biasanya dimakan bersama roti lunak (bun) yang berbentuk sama dengan sosis, kadang disertai bumbu dan topping."));
    }
}
