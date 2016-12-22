package moe.utaha.myapplication;

import com.orm.SugarRecord;

/**
 * Created by chojeaho on 2015-12-28.
 */
public class DBManager extends SugarRecord{
    String name;
    String time;

    public DBManager(){}

    public DBManager(String name,String time)
    {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
