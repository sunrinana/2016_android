package moe.utaha.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout) findViewById(R.id.layout);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < 10; i++)
        {
            Button button = new Button(getApplicationContext());
            button.setTag(i);
            button.setLayoutParams(layoutParams);
            button.setText("버튼" + i);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (Integer.valueOf(v.getTag().toString()))
                    {
                        case 0:
                            Toast.makeText(getApplicationContext(),"asdf",Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            Toast.makeText(getApplicationContext(),"fdsa",Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
            layout.addView(button);
        }





    }
    class ButtonObject
    {
        public int id=1;
        public String name ="01";
    }
}
