package com.dwiputri.greatfood.Fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dwiputri.greatfood.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class DiskonAdapter extends RecyclerView.Adapter<DiskonAdapter.DiskonViewHolder> {
    private ArrayList<Diskon> dataList;
    private Context mContext;

    public DiskonAdapter(Context mContext, ArrayList<Diskon> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public DiskonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_diskon, parent, false);
        return new DiskonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DiskonViewHolder holder, final int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtHarga.setText(dataList.get(position).getHarga());
        holder.txtDeskripsi.setText(dataList.get(position).getDeskripsi());
        Picasso.get()
                .load(dataList.get(position).getGambar())
                .into(holder.imageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, dataList.get(position).getNama(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(holder.itemView.getContext(), DetailDiskon.class);
                i.putExtra("namaMakanan", dataList.get(position).getNama());
                i.putExtra("hargaMakanan", dataList.get(position).getHarga());
                i.putExtra("gambarMakanan", dataList.get(position).getGambar());
                i.putExtra("deskripsiMakanan", dataList.get(position).getDeskripsi());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public void setCountries(ArrayList<Diskon> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public class DiskonViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama, txtHarga, txtDeskripsi;
        private ImageView imageView;
        private LinearLayout linearLayout;

        public DiskonViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_makanan);
            txtHarga = (TextView) itemView.findViewById(R.id.txt_harga_makanan);
            imageView = (ImageView) itemView.findViewById(R.id.imageNya);
            txtDeskripsi = (TextView) itemView.findViewById(R.id.txt_deskripsi_makanan);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayoutDiskon);

        }
    }
}
