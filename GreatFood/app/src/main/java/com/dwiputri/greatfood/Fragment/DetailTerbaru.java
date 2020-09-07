package com.dwiputri.greatfood.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.dwiputri.greatfood.R;
import com.squareup.picasso.Picasso;

public class DetailTerbaru extends AppCompatActivity {
    private TextView textViewNama1, textViewHarga1, textViewDeskripsi1;
    private ImageView imageView1;
    public String dataNama1, dataDeskripsi1;
    public String dataHarga1;
    public int dataGambar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_terbaru);
        textViewNama1 = (TextView)findViewById(R.id.txt_nama_makanan_detail1);
        textViewHarga1 = (TextView)findViewById(R.id.txt_harga_makanan_detail1);
        textViewDeskripsi1 = (TextView)findViewById(R.id.txt_deskripsi_makanan_detail1);
        imageView1 = (ImageView)findViewById(R.id.imageDetailNya1);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            dataNama1 = bundle.getString("namaMakanan1");
            dataHarga1 = bundle.getString("hargaMakanan1");
            dataGambar1 = bundle.getInt("gambarMakanan1");
            dataDeskripsi1 = bundle.getString("deskripsiMakanan1");
            if(dataNama1 != null && dataHarga1 != null){
                getData1();
            }
        }

    }

    public void getData1(){
        textViewNama1.setText(dataNama1.toString());
        textViewHarga1.setText(dataHarga1.toString());
        Picasso.get().load(dataGambar1).into(imageView1);
        textViewDeskripsi1.setText(dataDeskripsi1.toString());

    }
}
