package moe.utaha.todo;

import com.orm.SugarContext;

/**
 * Created by chojeaho on 2015-12-28.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(getApplicationContext());
    }
}
