package moe.utaha.myapplication;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list_view ;
    ArrayList<DBManager> dbManagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dbManagers = (ArrayList<DBManager>) DBManager.listAll(DBManager.class);
        list_view= (ListView) findViewById(R.id.list_view);
        list_view.setAdapter(new CustomAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            Intent intent = new Intent(MainActivity.this,AddActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.action_delete)
        {
            Toast.makeText(MainActivity.this,"asdf",Toast.LENGTH_SHORT).show();
            AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this,"asdf",Toast.LENGTH_SHORT).show();
                    DBManager dbManager = DBManager.findById(DBManager.class,position);
                    dbManager.delete();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            };
        }

        return super.onOptionsItemSelected(item);
    }
    class CustomAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return dbManagers.size();
        }

        @Override
        public Object getItem(int position) {
            return dbManagers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
            {
                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView =inflater.inflate(R.layout.custom_list,parent,false);

                TextView textName = (TextView) convertView.findViewById(R.id.list_name);
                TextView textTime = (TextView) convertView.findViewById(R.id.list_time);

                textName.setText(dbManagers.get(position).getName());
                textTime.setText(dbManagers.get(position).getTime());
            }
            return convertView;
        }
    }
}
