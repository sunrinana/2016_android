package moe.utaha.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chojeaho on 2016-02-13.
 */
public class CustomAdapter extends BaseAdapter{

    private ArrayList<String> m_list;
    public CustomAdapter() {
        m_list = new ArrayList<String>();
    }

    @Override
    public int getCount() {
        return m_list.size();
    }

    @Override
    public Object getItem(int position) {
        return m_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // 리스트가 길어지면서 현재 화면에 보이지 않는 아이템은 converView가 null인 상태로 들어 옴
        if ( convertView == null ) {
            // view가 null일 경우 커스텀 레이아웃을 얻어 옴
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_list, parent, false);

            // TextView에 현재 position의 문자열 추가
            TextView text_data = (TextView) convertView.findViewById(R.id.list_data);
            text_data.setText(m_list.get(position));

            TextView text_date = (TextView) convertView.findViewById(R.id.list_date);
            text_date.setText(m_list.get(position));
        }

            return convertView;
    }
    public void add(String _msg) {
        m_list.add(_msg);
    }

    // 외부에서 아이템 삭제 요청 시 사용
    public void remove(int _position) {
        m_list.remove(_position);
    }
}
