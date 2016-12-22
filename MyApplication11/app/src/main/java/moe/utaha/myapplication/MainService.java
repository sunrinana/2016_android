package moe.utaha.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by chojeaho on 2016-03-13.
 */
public class MainService extends Service {

    @Override
    public void onCreate(){

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
