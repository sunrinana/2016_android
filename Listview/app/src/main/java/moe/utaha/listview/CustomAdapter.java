package moe.utaha.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by chojeaho on 2016-06-12.
 */
public class CustomAdapter extends BaseAdapter { //오류나면 alt+enter눌러서 implement하자

    private ArrayList<String> list; //리스트

    public CustomAdapter(){ //생성자
        list = new ArrayList<String>();
    } //생성자

    @Override
    public int getCount() {
        return list.size();
    } //리스트 크기

    @Override
    public Object getItem(int position) {
        return list.get(position);
    } //아이템 위치받고 아이템반환

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*아래 중요*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position; //값이 바뀌지않게 final해주자
        final Context context = parent.getContext();

        // 리스트가 길어지면서 현재 화면에 보이지 않는 아이템은 converView가 null인 상태로 들어 옴
        if ( convertView == null ) {
            // view가 null일 경우 커스텀 레이아웃을 얻어 옴
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_custom, parent, false);

            // TextView에 현재 position의 문자열 추가
            TextView text = (TextView) convertView.findViewById(R.id.list_text);
            text.setText(list.get(position));

            // 버튼을 터치 했을 때 이벤트 발생
            Button btn = (Button) convertView.findViewById(R.id.list_btn);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // 터치 시 해당 아이템 이름 출력
                    Toast.makeText(context, list.get(pos), Toast.LENGTH_SHORT).show();
                }
            });

            // 리스트 아이템을 터치 했을 때 이벤트 발생
            convertView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // 터치 시 해당 아이템 이름 출력
                    Toast.makeText(context, "리스트 클릭 : "+list.get(pos), Toast.LENGTH_SHORT).show();
                }
            });

            // 리스트 아이템을 길게 터치 했을 떄 이벤트 발생
            convertView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    // 터치 시 해당 아이템 이름 출력
                    Toast.makeText(context, "리스트 롱 클릭 : " + list.get(pos), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        return convertView;
    }

    public void add(String str) //리스트에 아이템추가
    {
        list.add(str);
    }

    public void remove(int position) //리스트에 아이템 제거
    {
        list.remove(position);
    }
}
