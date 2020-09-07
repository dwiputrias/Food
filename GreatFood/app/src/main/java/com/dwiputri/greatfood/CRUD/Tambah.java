package com.dwiputri.greatfood.CRUD;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dwiputri.greatfood.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tambah extends AppCompatActivity {

    EditText nama, harga, deskripsi;
    Button btn_save, btn_Tampildata, btn_update, btn_delete;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);


        nama = (EditText) findViewById(R.id.edt_nama);
        harga = (EditText) findViewById(R.id.edt_harga);
        deskripsi = (EditText) findViewById(R.id.edt_deskripsi);
        btn_Tampildata = (Button) findViewById(R.id.btntampildata);
        btn_update =(Button) findViewById(R.id.btnUpdate);
        btn_save = (Button) findViewById(R.id.btn_insertdata);
        btn_delete=(Button) findViewById(R.id.btnhapus);

        Intent data = getIntent();
        final String iddata = data.getStringExtra("id");
        if(iddata != null) {
            btn_save.setVisibility(View.GONE);
            btn_Tampildata.setVisibility(View.GONE);
            btn_update.setVisibility(View.VISIBLE);
            btn_delete.setVisibility(View.VISIBLE);
            nama.setText(data.getStringExtra("nama"));
            harga.setText(data.getStringExtra("harga"));
            deskripsi.setText(data.getStringExtra("deskripsi"));
        }

        pd = new ProgressDialog(this);

        btn_Tampildata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent godata = new Intent(Tambah.this, TampilData.class);
                startActivity(godata);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("Loading Hapus ...");
                pd.setCancelable(false);
                pd.show();

                APIRequest api = Retrofit.getClient().create(APIRequest.class);
                Call<ResponsModel> del  = api.deleteData(iddata);
                del.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        Log.d("Retro", "onResponse");
                        Toast.makeText(Tambah.this, response.body().getPesan(),Toast.LENGTH_SHORT).show();
                        Intent gotampil = new Intent(Tambah.this,TampilData.class);
                        startActivity(gotampil);

                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("Retro", "onFailure");
                    }
                });
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("update ....");
                pd.setCancelable(false);
                pd.show();

                APIRequest api = Retrofit.getClient().create(APIRequest.class);
                Call<ResponsModel> update = api.updateData(iddata,nama.getText().toString(),harga.getText().toString(),deskripsi.getText().toString());
                update.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        Log.d("Retro", "Response");
                        Toast.makeText(Tambah.this,response.body().getPesan(),Toast.LENGTH_SHORT).show();
                        pd.hide();
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("Retro", "OnFailure");

                    }
                });
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("send data ... ");
                pd.setCancelable(false);
                pd.show();

                String snama = nama.getText().toString();
                String sharga = harga.getText().toString();
                String sdeskripsi = deskripsi.getText().toString();
                APIRequest api = Retrofit.getClient().create(APIRequest.class);

                Call<ResponsModel> sendtmn = api.sendTanaman(snama,sharga,sdeskripsi);
                sendtmn.enqueue(new Callback<ResponsModel>() {
                    @Override
                    public void onResponse(Call<ResponsModel> call, Response<ResponsModel> response) {
                        pd.hide();
                        Log.d("RETRO", "response : " + response.body().toString());
                        String kode = response.body().getKode();
                        if(kode.equals("1"))
                        {
                            Toast.makeText(Tambah.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(Tambah.this, "Data Error tidak berhasil disimpan", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsModel> call, Throwable t) {
                        pd.hide();
                        Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
                    }
                });
            }
        });
    }
}
