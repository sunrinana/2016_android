package moe.utaha.iljung;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by chojeaho on 2016-04-17.
 */
public class CustomAdapter extends BaseAdapter {
    private ArrayList<ArrayList<String>> m_List;
    private ArrayList<String> t_list;
    private ArrayList<String> c_list;

    public CustomAdapter() {
        m_List = new ArrayList<ArrayList<String>>();
        t_list = new ArrayList<String>();
        c_list = new ArrayList<String>();
        m_List.add(t_list);
        m_List.add(c_list);
    }

    @Override
    public int getCount() {
        return m_List.size();
    }

    @Override
    public Object getItem(int position) {
        return m_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_list,parent,false);

            TextView t_text = (TextView) convertView.findViewById(R.id.list_title);
            t_text.setText(t_list.get(position));

            TextView c_text = (TextView) convertView.findViewById(R.id.list_content);
            c_text.setText(c_list.get(position));

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,t_list.get(pos),Toast.LENGTH_SHORT).show();
                }
            });

        }
        return convertView;
    }

    public void add(String t, String c)
    {
        t_list.add(t);
        c_list.add(c);
        m_List.add(t_list);
        m_List.add(c_list);
    }
    public void delete(int pos)
    {
        t_list.remove(pos);
        c_list.remove(pos);
        m_List.remove(pos);
    }
}
