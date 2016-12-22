package moe.utaha.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_0,btn_1,btn_2,btn_3,btn_4
            ,btn_5,btn_6,btn_7,btn_8
            ,btn_9,btn_ac,btn_back,btn_divide
            ,btn_dot,btn_equal,btn_minus,btn_multiply
            ,btn_plus,btn_pow,btn_rem;
    TextView text_formula,text_result;
    int set =1;

    Calc calc = new Calc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_ac = (Button) findViewById(R.id.btn_ac);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_pow = (Button) findViewById(R.id.btn_pow);
        btn_rem = (Button) findViewById(R.id.btn_rem);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_ac.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_pow.setOnClickListener(this);
        btn_rem.setOnClickListener(this);

        text_formula = (TextView) findViewById(R.id.text_text);
        text_result = (TextView) findViewById(R.id.text_result);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_0:
                calc.Setstr(set,"0");
                break;
            case R.id.btn_1:
                calc.Setstr(set,"1");
                break;
            case R.id.btn_2:
                calc.Setstr(set,"2");
                break;
            case R.id.btn_3:
                calc.Setstr(set,"3");
                break;
            case R.id.btn_4:
                calc.Setstr(set,"4");
                break;
            case R.id.btn_5:
                calc.Setstr(set,"5");
                break;
            case R.id.btn_6:
                calc.Setstr(set,"6");
                break;
            case R.id.btn_7:
                calc.Setstr(set,"7");
                break;
            case R.id.btn_8:
                calc.Setstr(set,"8");
                break;
            case R.id.btn_9:
                calc.Setstr(set,"9");
                break;
            case R.id.btn_ac:
                calc.delete();
                text_result.setText("");
                break;
            case R.id.btn_back:
                calc.back();
                if(calc.operator == null){
                    set = 1;
                }
                break;
            case R.id.btn_dot:
                calc.Setstr(set,".");
                break;
            case R.id.btn_equal:
                calc.result();
                set = 1;
                text_result.setText(calc.getResult()+"");
                break;
            case R.id.btn_divide:
                calc.setOperator("/");
                set = 2;
                break;
            case R.id.btn_minus:
                calc.setOperator("-");
                set =2;
                break;
            case R.id.btn_multiply:
                calc.setOperator("*");
                set = 2;
                break;
            case R.id.btn_plus:
                calc.setOperator("+");
                set =2;
                break;
            case R.id.btn_pow:
                calc.setOperator("^");
                set = 2;
                break;
            case R.id.btn_rem:
                calc.setOperator("%");
                set = 2;
                break;
        }
        text_formula.setText(calc.getFormula());
        Toast.makeText(getApplicationContext(),calc.str1+calc.operator+calc.str2,Toast.LENGTH_SHORT).show();
    }
}
