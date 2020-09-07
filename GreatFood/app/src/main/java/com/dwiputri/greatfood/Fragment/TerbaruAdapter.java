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

class TerbaruAdapter extends RecyclerView.Adapter<TerbaruAdapter.TerbaruViewHolder> {
    private ArrayList<Terbaru> dataList;
    private Context mContext;

    public TerbaruAdapter(Context mContext, ArrayList<Terbaru> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public TerbaruAdapter.TerbaruViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_terbaru, parent, false);
        return new TerbaruAdapter.TerbaruViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TerbaruAdapter.TerbaruViewHolder holder, final int position) {
        holder.txtNama1.setText(dataList.get(position).getNama1());
        holder.txtHarga1.setText(dataList.get(position).getHarga1());
        holder.txtDeskripsi1.setText(dataList.get(position).getDeskripsi1());
        Picasso.get()
                .load(dataList.get(position).getGambar1())
                .into(holder.imageView1);
        holder.linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, dataList.get(position).getNama1(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(holder.itemView.getContext(), DetailTerbaru.class);
                i.putExtra("namaMakanan1", dataList.get(position).getNama1());
                i.putExtra("hargaMakanan1", dataList.get(position).getHarga1());
                i.putExtra("gambarMakanan1", dataList.get(position).getGambar1());
                i.putExtra("deskripsiMakanan1", dataList.get(position).getDeskripsi1());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public void setCountries(ArrayList<Terbaru> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public class TerbaruViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNama1, txtHarga1, txtDeskripsi1;
        private ImageView imageView1;
        private LinearLayout linearLayout1;

        public TerbaruViewHolder(View itemView) {
            super(itemView);
            txtNama1 = (TextView) itemView.findViewById(R.id.txt_nama_makanan1);
            txtHarga1 = (TextView) itemView.findViewById(R.id.txt_harga_makanan1);
            imageView1 = (ImageView) itemView.findViewById(R.id.imageNya1);
            txtDeskripsi1 = (TextView) itemView.findViewById(R.id.txt_deskripsi_makanan1);
            linearLayout1 = (LinearLayout) itemView.findViewById(R.id.linearLayoutTerbaru1);

        }
    }
}
