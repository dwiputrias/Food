package com.dwiputri.greatfood.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dwiputri.greatfood.R;
import com.squareup.picasso.Picasso;

public class DetailDiskon extends AppCompatActivity {
    private TextView textViewNama, textViewHarga, textViewDeskripsi;
    private ImageView imageView;
    public String dataNama, dataDeskripsi;
    public String dataHarga;
    public int dataGambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_diskon);
        textViewNama = (TextView)findViewById(R.id.txt_nama_makanan_detail);
        textViewHarga = (TextView)findViewById(R.id.txt_harga_makanan_detail);
        textViewDeskripsi = (TextView)findViewById(R.id.txt_deskripsi_makanan_detail);
        imageView = (ImageView)findViewById(R.id.imageDetailNya);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            dataNama = bundle.getString("namaMakanan");
            dataHarga = bundle.getString("hargaMakanan");
            dataGambar = bundle.getInt("gambarMakanan");
            dataDeskripsi = bundle.getString("deskripsiMakanan");
            if(dataNama != null && dataHarga != null){
                getData();
            }
        }

    }

    public void getData(){
        textViewNama.setText(dataNama.toString());
        textViewHarga.setText(dataHarga.toString());
        Picasso.get().load(dataGambar).into(imageView);
        textViewDeskripsi.setText(dataDeskripsi.toString());

    }
}
