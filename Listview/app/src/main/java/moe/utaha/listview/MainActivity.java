package moe.utaha.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView                m_ListView;
    private CustomAdapter           m_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Android에서 제공하는 string 문자열 하나를 출력 가능한 layout으로 어댑터 생성
        m_Adapter = new CustomAdapter();

        // Xml에서 추가한 ListView 연결
        m_ListView = (ListView) findViewById(R.id.listView);

        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);

        // ListView에 아이템 추가
        m_Adapter.add("Re : 제로부터 시작하는 이세계생활");
        m_Adapter.add("조커게임");
        m_Adapter.add("사카모토입니다만?");
        m_Adapter.add("쿠마미코");
        m_Adapter.add("갑칠성의 카네바리");
        m_Adapter.add("뭐쓰지");
        m_Adapter.add("에네");
    }

}
