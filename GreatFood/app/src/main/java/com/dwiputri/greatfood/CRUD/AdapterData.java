package com.dwiputri.greatfood.CRUD;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dwiputri.greatfood.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

        private List<DataModel> mList ;
        private Context ctx;


    public  AdapterData (Context ctx, List<DataModel> mList)
        {
            this.ctx = ctx;
            this.mList = mList;
        }

        @Override
        public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
            View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist,parent, false);
            HolderData holder = new HolderData(layout);
            return holder;
        }

        @Override
        public void onBindViewHolder(HolderData holder, int position) {
            DataModel dm = mList.get(position);
            holder.nama.setText(dm.getNama());
            holder.harga.setText(dm.getHarga());
            holder.deskripsi.setText(dm.getDeskripsi());
            holder.dm = dm;
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }


        class HolderData extends  RecyclerView.ViewHolder{
            TextView nama, harga, deskripsi;
            DataModel dm;
            public HolderData (View v)
            {
                super(v);

                nama  = (TextView) v.findViewById(R.id.tvNama);
                harga = (TextView) v.findViewById(R.id.tvHarga);
                deskripsi = (TextView) v.findViewById(R.id.tvDeskripsi);

                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent goInput = new Intent(ctx,Tambah.class);
                        goInput.putExtra("id", dm.getId());
                        goInput.putExtra("nama", dm.getNama());
                        goInput.putExtra("harga", dm.getHarga());
                        goInput.putExtra("deskripsi", dm.getDeskripsi());

                        ctx.startActivity(goInput);
                    }
                });
            }
        }
}
