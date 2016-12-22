package com.example.sunrin.sunrin1228;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private final String key = "c1b406b32dbbbbeee5f2a36ddc14067f ";
    private final String target ="image";
    private final String url = "http://openapi.naver.com/search";
    private String query ="선린";
    private ArrayList<Data>
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpNaver("http://openapi.naver.com/search?key=c1b406b32dbbbbeee5f2a36ddc14067f&target=image&query=%EC%84%A0%EB%A6%B0");
    }

    private void httpNaver(String url){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Toast.makeText(getApplicationContext(), "통신성공" + statusCode, Toast.LENGTH_SHORT).show();
                String result = new String(responseBody, 0, responseBody.length);
                Log.i("asdf", result);

                try {
                    parser = new XmlParser(is).parser();
                    Toast.makeText(getApplicationContext(),parser.size()+"개",Toast.LENGTH_SHORT).show();

                }catch (XmlParser)
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), "통신실패" + statusCode + error, Toast.LENGTH_LONG).show();
            }
        });
    }


    class CustromAdapter extends BaseAdapter
    {
        private ArrayList<Data> datas;
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(parent,getContext())
            convertView = inflater.inflate(R.layout.item,parent);

            ImageView imageview = (ImageView)convertView.findViewById(R.id.imageVIew);
            String url = datas.get(position).getImageUrl();
            Picasso.with(parent.getContext()).load(url).into(imageview);
            return null;
        }
    }
}