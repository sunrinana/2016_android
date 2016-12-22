package moe.utaha.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by chojeaho on 2015-12-28.
 */
public class AddActivity extends AppCompatActivity{
    EditText editText;
    Button btn_submit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        editText = (EditText) findViewById(R.id.edit_text);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /***********data***********/
                Calendar calendar = Calendar.getInstance();
                DBManager dbManager = new DBManager(editText.getText().toString(), calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)+"");
                dbManager.save();
                Intent intent = new Intent(AddActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
