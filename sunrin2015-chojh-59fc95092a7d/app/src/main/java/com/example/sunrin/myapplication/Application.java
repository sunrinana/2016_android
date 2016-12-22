package com.example.sunrin.myapplication;

import com.orm.SugarContext;

/**
 * Created by Sunrin on 2015-12-23.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(getApplicationContext());
    }
}
