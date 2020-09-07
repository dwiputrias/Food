package com.dwiputri.greatfood.WebService;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dwiputri.greatfood.R;

import java.util.List;

public class HasilLokasi extends Activity {
    ListView grdData;

    private static final class Holder {
        public TextView tvNama_Makanan;
        public TextView tvAsal_Makanan;
        public TextView tvLokasi;
    }

    public HasilLokasi() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_lokasi);

        grdData = (ListView) findViewById(R.id.grdData);

        ControllerHasilLokasi myData = new ControllerHasilLokasi(this);
        myData.open();
        myData.getData();

        HasilFoodAdapter adapter = new HasilFoodAdapter(this, android.R.layout.simple_list_item_1,
                myData.getData());
        grdData.setAdapter(adapter);
        myData.close();
    }

    private class HasilFoodAdapter extends ArrayAdapter<ModelHasilLokasi> {
        private LayoutInflater mInflater;

        public HasilFoodAdapter(Context context, int textViewResourceId,
                                  List<ModelHasilLokasi> objects) {
            super(context, textViewResourceId, objects);

            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup
                parent){
            View view = convertView;
            Holder holder;

            if(view == null) {
                view = mInflater.inflate(R.layout.custom_hasillokasi, parent,
                        false);

                holder = new Holder();
                holder.tvNama_Makanan = (TextView) view.findViewById(R.id.tvNama_Makanan);
                holder.tvAsal_Makanan = (TextView) view.findViewById(R.id.tvAsal_Makanan);
                holder.tvLokasi = (TextView) view.findViewById(R.id.tvLokasi);

                view.setTag(holder);
            } else {
                holder = (Holder) view.getTag();
            }

            ModelHasilLokasi stream = getItem(position);

            holder.tvNama_Makanan.setText(stream.getNama_makanan());
            holder.tvAsal_Makanan.setText(stream.getAsal_makanan());
            holder.tvLokasi.setText(stream.getLokasi());

            return view;
        }
    }
}
