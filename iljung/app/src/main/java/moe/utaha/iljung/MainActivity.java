package moe.utaha.iljung;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

public class MainActivity extends Activity {
    private ListView                m_ListView;
    private CustomAdapter           m_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_Adapter = new CustomAdapter();

        // Xml에서 추가한 ListView 연결
        m_ListView = (ListView) findViewById(R.id.list_item);

        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);

        // ListView에 아이템 추가
        m_Adapter.add("1시","안녕");
        m_Adapter.add("2시","안녕");
        m_Adapter.add("3시","안녕");
        m_Adapter.add("4시","안녕");
        m_Adapter.add("5시","안녕");
        m_Adapter.add("6시","안녕");
    }
}
