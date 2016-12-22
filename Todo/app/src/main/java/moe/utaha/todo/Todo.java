package moe.utaha.todo;

import com.orm.SugarRecord;

/**
 * Created by chojeaho on 2015-12-28.
 */
public class Todo extends SugarRecord {
    private String name;
    private String time;

    public Todo()
    {

    }
    public Todo(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getNumber() {
        return time;
    }

    public void setNumber(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
