package com.dwiputri.greatfood.CRUD_Survey;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dwiputri.greatfood.CRUD.Tambah;
import com.dwiputri.greatfood.R;

import java.util.List;

public class AdapterSurvey extends RecyclerView.Adapter<AdapterSurvey.HolderData1> {

    private List<DataSurvey> mList;
    private Context ctx;


    public AdapterSurvey(Context ctx, List<DataSurvey> mList) {
        this.ctx = ctx;
        this.mList = mList;
    }

    @Override
    public HolderData1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist_survey, parent, false);
        AdapterSurvey.HolderData1 holder = new HolderData1(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(AdapterSurvey.HolderData1 holder, int position) {
        DataSurvey dm = mList.get(position);
        holder.nama.setText(dm.getNama());
        holder.persen.setText(dm.getPersen());
        holder.dm = dm;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class HolderData1 extends RecyclerView.ViewHolder {
        TextView nama, persen;
        DataSurvey dm;

        public HolderData1(View v) {
            super(v);

            nama = (TextView) v.findViewById(R.id.tvNama);
            persen = (TextView) v.findViewById(R.id.tvPersen);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goInput = new Intent(ctx, Tambah.class);
                    goInput.putExtra("id_survey", dm.getId_survey());
                    goInput.putExtra("nama", dm.getNama());
                    goInput.putExtra("persen", dm.getPersen());

                    ctx.startActivity(goInput);
                }
            });
        }
    }
}
