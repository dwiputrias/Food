package com.dwiputri.greatfood.WebService;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dwiputri.greatfood.CRUD.Tambah;
import com.dwiputri.greatfood.R;
import com.dwiputri.greatfood.SQLite.UsersList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServices extends AppCompatActivity {

    Context myContext;
    ProgressDialog progress;
    APIHasilLokasi ApiHasilLokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_services);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        myContext = getApplicationContext();
        progress = ProgressDialog.show(WebServices.this, "Inisialisasi Data", "Sedang Mengunduh Data Untuk Aplikasi", true);

        Callback<ResponseHasilLokasi> hasildatamakanan = new Callback<ResponseHasilLokasi>() {
            @Override
            public void onResponse(Call<ResponseHasilLokasi> call, Response<ResponseHasilLokasi> response) {
                if (response.isSuccessful()) {
                    List<ModelHasilLokasi> hasilLocate = response.body().getLokasi();
                    int jlhData = response.body().getLokasi().size();

                    if (jlhData > 0) {
                        ControllerHasilLokasi cht = new ControllerHasilLokasi(myContext);

                        cht.open();
                        cht.deleteData();
                        for (int y = 0; y < jlhData; y++) {
                            ModelHasilLokasi tmpHasil = hasilLocate.get(y);
                            cht.insertData(tmpHasil.getId(), tmpHasil.getNama_makanan(), tmpHasil.getAsal_makanan(),
                                    tmpHasil.getLokasi());
                        }
                        cht.close();

                        Intent sendIntent = new Intent(myContext, HasilLokasi.class);
                        startActivity(sendIntent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "DATA SEDANG TIDAK TERSEDIA",
                                Toast.LENGTH_LONG).show();
                    }
                    progress.dismiss();
                } else {
                    Log.e("onResponse failure", "Code: " + response.code() +
                            " , Message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseHasilLokasi> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(getApplicationContext(), "AKSES KE SERVER GAGAL" + t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        };

        ApiHasilLokasi = RESTClient.get();
        Call<ResponseHasilLokasi> callHasilPlants = ApiHasilLokasi.getHasilLocate();
        callHasilPlants.enqueue(hasildatamakanan);
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.awal, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            } else if (id == R.id.action_tambah) {
                Intent i = new Intent (WebServices.this, Tambah.class);
                startActivity(i);
                Toast.makeText(this, "Create Data", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.action_faq) {
                Toast.makeText(this, "FAQ", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.question) {
                Toast.makeText(this, "Question", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.recommendation) {
                Toast.makeText(this, "Recommendation", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.action_account) {
                Toast.makeText(this, "Account menu item pressed", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.profile) {
                Intent i = new Intent (WebServices.this, UsersList.class);
                startActivity(i);
                Toast.makeText(this, "All Account", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.logout) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setMessage("Do you want to Exit?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //if user pressed "yes", then he is allowed to exit from application
                        finish();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //if user select "No", just cancel this dialog and continue with app
                        dialog.cancel();
                    }
                });
                android.app.AlertDialog alert = builder.create();
                alert.show();
                Toast.makeText(this, "Berhasil Keluar", Toast.LENGTH_SHORT).show();
            }

            return super.onOptionsItemSelected(item);
        }
}
