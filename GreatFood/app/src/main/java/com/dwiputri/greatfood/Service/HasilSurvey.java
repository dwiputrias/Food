package com.dwiputri.greatfood.Service;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dwiputri.greatfood.R;
import java.util.List;

public class HasilSurvey extends Activity {
    ListView grdData;

    private static final class Holder {
        public TextView tvNama_Makanan1;
        public TextView tvPersen;
    }

    public HasilSurvey() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_survey);

        grdData = (ListView) findViewById(R.id.grdData1);

        ControllerHasilSurvey myData = new ControllerHasilSurvey(this);
        myData.open();
        myData.getData();

        HasilSurveyAdapter adapter = new HasilSurveyAdapter(this, android.R.layout.simple_list_item_1,
                myData.getData());
        grdData.setAdapter(adapter);
        myData.close();
    }

    private class HasilSurveyAdapter extends ArrayAdapter<ModelHasilSurvey> {
        private LayoutInflater mInflater;

        public HasilSurveyAdapter(Context context, int textViewResourceId,
                                List<ModelHasilSurvey> objects) {
            super(context, textViewResourceId, objects);

            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup
                parent) {
            View view = convertView;
            HasilSurvey.Holder holder;

            if (view == null) {
                view = mInflater.inflate(R.layout.custom_hasilsurvey, parent,
                        false);

                holder = new Holder();
                holder.tvNama_Makanan1 = (TextView) view.findViewById(R.id.tvNama_Makanan1);
                holder.tvPersen = (TextView) view.findViewById(R.id.tvPersen);

                view.setTag(holder);
            } else {
                holder = (HasilSurvey.Holder) view.getTag();
            }

            ModelHasilSurvey stream = getItem(position);

            holder.tvNama_Makanan1.setText(stream.getNama());
            holder.tvPersen.setText(stream.getPersen());

            return view;
        }
    }
}
