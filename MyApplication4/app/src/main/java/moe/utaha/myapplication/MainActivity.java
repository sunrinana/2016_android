package moe.utaha.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.btn_start)
    Button btnStart;

    @Bind(R.id.btn_stop)
    Button btnStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_start:
                Intent intentStart = new Intent(MainActivity.this,MyService.class);
                startService(intentStart);

                break;
            case R.id.btn_stop:
                Intent intentStop = new Intent(MainActivity.this,MyService.class);
                stopService(intentStop);
                break;
        }
    }
}
