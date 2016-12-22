package com.example.sunrin.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReadActivity extends Activity {
    private ListView list_view ;
    private ArrayList<People> peoples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        peoples = (ArrayList<People>) People.listAll(People.class);
        list_view = (ListView) findViewById(R.id.list_view);
        list_view.setAdapter(new CustomAdapter());

    }
    class CustomAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return peoples.size();
        }

        @Override
        public Object getItem(int position) {
            return peoples.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)
            {

                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.custom_list, parent, false);

                TextView textName = (TextView) convertView.findViewById(R.id.list_name);
                TextView textNumber = (TextView) convertView.findViewById(R.id.list_number);

                textName.setText(peoples.get(position).getName());
                textNumber.setText(peoples.get(position).getNumber());
            }

            return convertView;
        }
    }
}
