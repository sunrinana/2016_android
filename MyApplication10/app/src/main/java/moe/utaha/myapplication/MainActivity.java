package moe.utaha.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit_email;
    EditText edit_pw;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_pw = (EditText) findViewById(R.id.edit_pw);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        edit_email.getText().toString() +edit_pw.getText().toString()+"입니다",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
