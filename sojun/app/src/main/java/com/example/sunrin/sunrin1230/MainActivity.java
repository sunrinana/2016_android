package com.example.sunrin.sunrin1230;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends Activity {
    //    ?key=&target=e&query=
    private final String url = "http://openapi.naver.com/search";
    private final String key = "88219bb92b7d37a464d800ea25aecb84";
    private final String target = "image";
    private String query;
    private GridView gridView;
    private ArrayList<Data> parser = new ArrayList<>();
    EditText editText;
    Button btn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridview);
        editText = (EditText) findViewById(R.id.edit_text);
        btn_search = (Button) findViewById(R.id.btn_search);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query = editText.getText().toString();
                httpNaver(url + "?key=" + key + "&target=" + target + "&query=" + query);
                System.out.println("---------------- log");
            }
        });

    }

    private void httpNaver(String url) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Toast.makeText(getApplicationContext(), "통신성공" + statusCode, Toast.LENGTH_SHORT).show();
                String result = new String(responseBody, 0, responseBody.length);
                Log.i("sunrin", result);

                InputStream is = new ByteArrayInputStream(responseBody);
                try {
                    parser = new XmlParser(is).parser();
                    Toast.makeText(getApplicationContext(), parser.size() + "개", Toast.LENGTH_SHORT).show();
                    gridView.setAdapter(new CustomAdapter(parser));
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), "통신실패" + statusCode, Toast.LENGTH_SHORT).show();
            }
        });
    }

    class CustomAdapter extends BaseAdapter {

        private ArrayList<Data> datas;

        public CustomAdapter(ArrayList<Data> datas) {
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item, parent, false);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            String url = datas.get(position).getImageUrl();


            Picasso.with(parent.getContext()).load(url).resize(100,100).centerCrop().into(imageView);

            return convertView;
        }
    }
}








