package com.dwiputri.greatfood.CRUD_Survey;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dwiputri.greatfood.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TampilSurvey extends AppCompatActivity {

    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<DataSurvey> mItems = new ArrayList<>();
    ProgressDialog pd1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_survey);

        pd1 = new ProgressDialog(this);
        mRecycler = (RecyclerView) findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd1.setMessage("Loading ...");
        pd1.setCancelable(false);
        pd1.show();

        APISurvey api = Retroserver.getClient().create(APISurvey.class);
        Call<ResponsSurvey> getsurvey = api.getSurvey();
        getsurvey.enqueue(new Callback<ResponsSurvey>() {
            @Override
            public void onResponse(Call<ResponsSurvey> call, Response<ResponsSurvey> response) {
                pd1.hide();
                Log.d("RETRO", "RESPONSE : " + response.body().getKode());
                mItems = response.body().getResult();

                mAdapter = new AdapterSurvey(TampilSurvey.this,mItems);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponsSurvey> call, Throwable t) {
                pd1.hide();
                Log.d("RETRO", "FAILED : respon gagal");

            }
        });

    }
}
