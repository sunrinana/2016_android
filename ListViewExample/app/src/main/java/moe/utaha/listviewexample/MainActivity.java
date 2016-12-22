package moe.utaha.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView                m_ListView;
    private ArrayAdapter<String> m_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Android에서 제공하는 string 문자열 하나를 출력 가능한 layout으로 어댑터 생성
        m_Adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1); //기본
        //m_Adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_font ); 폰트 검정색

        // Xml에서 추가한 ListView 연결
        m_ListView = (ListView) findViewById(R.id.list_item);

        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);

        // ListView 아이템 터치 시 이벤트 추가
        m_ListView.setOnItemClickListener(onClickListItem);

        // ListView에 아이템 추가
        m_Adapter.add("Re : 제로부터 시작하는 이세계생활");
        m_Adapter.add("조커게임");
        m_Adapter.add("사카모토입니다만?");
        m_Adapter.add("쿠마미코");
        m_Adapter.add("갑칠성의 카네바리");
        m_Adapter.add("뭐쓰지");
        m_Adapter.add("에네");
    }

    // 아이템 터치 이벤트
    private AdapterView.OnItemClickListener onClickListItem = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            // 이벤트 발생 시 해당 아이템 위치의 텍스트를 출력
            Toast.makeText(getApplicationContext(),m_Adapter.getItem(arg2),Toast.LENGTH_SHORT).show();
        }
    };
}
