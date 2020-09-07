package com.dwiputri.greatfood.CRUD_Survey;

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

public class Tambah_survey extends AppCompatActivity {

    EditText nama, persen;
    Button btn_save, btn_Tampilsurvey, btn_update, btn_delete;
    ProgressDialog pd1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_survey);


        nama = (EditText) findViewById(R.id.edt_nama1);
        persen = (EditText) findViewById(R.id.edt_persen1);
        btn_Tampilsurvey = (Button) findViewById(R.id.btntampilsurvey1);
        btn_update =(Button) findViewById(R.id.btnUpdate1);
        btn_save = (Button) findViewById(R.id.btn_insertdata1);
        btn_delete=(Button) findViewById(R.id.btnhapus1);

        Intent data = getIntent();
        final String id = data.getStringExtra("id_survey");
        if(id != null) {
            btn_save.setVisibility(View.GONE);
            btn_Tampilsurvey.setVisibility(View.GONE);
            btn_update.setVisibility(View.VISIBLE);
            btn_delete.setVisibility(View.VISIBLE);
            nama.setText(data.getStringExtra("nama"));
            persen.setText(data.getStringExtra("persen"));
        }

        pd1 = new ProgressDialog(this);

        btn_Tampilsurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent godata = new Intent(Tambah_survey.this, TampilSurvey.class);
                startActivity(godata);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd1.setMessage("Loading Hapus ...");
                pd1.setCancelable(false);
                pd1.show();

                APISurvey api = Retroserver.getClient().create(APISurvey.class);
                Call<ResponsSurvey> del  = api.deleteSurvey(id);
                del.enqueue(new Callback<ResponsSurvey>() {
                    @Override
                    public void onResponse(Call<ResponsSurvey> call, Response<ResponsSurvey> response) {
                        Log.d("Retro", "onResponse");
                        Toast.makeText(Tambah_survey.this, response.body().getPesan(),Toast.LENGTH_SHORT).show();
                        Intent gotampil = new Intent(Tambah_survey.this,TampilSurvey.class);
                        startActivity(gotampil);

                    }

                    @Override
                    public void onFailure(Call<ResponsSurvey> call, Throwable t) {
                        pd1.hide();
                        Log.d("Retro", "onFailure");
                    }
                });
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd1.setMessage("update ....");
                pd1.setCancelable(false);
                pd1.show();

                APISurvey api = Retroserver.getClient().create(APISurvey.class);
                Call<ResponsSurvey> update = api.updateSurvey(id,nama.getText().toString(),persen.getText().toString());
                update.enqueue(new Callback<ResponsSurvey>() {
                    @Override
                    public void onResponse(Call<ResponsSurvey> call, Response<ResponsSurvey> response) {
                        Log.d("Retro", "Response");
                        Toast.makeText(Tambah_survey.this,response.body().getPesan(),Toast.LENGTH_SHORT).show();
                        pd1.hide();
                    }

                    @Override
                    public void onFailure(Call<ResponsSurvey> call, Throwable t) {
                        pd1.hide();
                        Log.d("Retro", "OnFailure");

                    }
                });
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd1.setMessage("send data ... ");
                pd1.setCancelable(false);
                pd1.show();

                String snama = nama.getText().toString();
                String spersen = persen.getText().toString();
                APISurvey api = Retroserver.getClient().create(APISurvey.class);

                Call<ResponsSurvey> sendtmn = api.sendSurvey(snama,spersen);
                sendtmn.enqueue(new Callback<ResponsSurvey>() {
                    @Override
                    public void onResponse(Call<ResponsSurvey> call, Response<ResponsSurvey> response) {
                        pd1.hide();
                        Log.d("RETRO", "response : " + response.body().toString());
                        String kode = response.body().getKode();
                        if(kode.equals("1"))
                        {
                            Toast.makeText(Tambah_survey.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(Tambah_survey.this, "Data Error tidak berhasil disimpan", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsSurvey> call, Throwable t) {
                        pd1.hide();
                        Log.d("RETRO", "Falure : " + "Gagal Mengirim Request");
                    }
                });
            }
        });
    }
}
