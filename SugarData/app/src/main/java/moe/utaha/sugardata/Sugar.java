package moe.utaha.sugardata;

import com.orm.SugarRecord;

/**
 * Created by chojeaho on 2016-08-10.
 */
public class Sugar extends SugarRecord{
    String value;

    public Sugar() {
    }

    public Sugar(String value) {
        this.value = value;
    }
}
