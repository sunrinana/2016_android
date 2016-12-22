package moe.utaha.myapplication;


import android.os.Debug;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by chojeaho on 2016-05-18.
 */
public class Calc extends Calcparent implements Calcinterface{
    String str1,str2,operator;
    float result;
    void Setstr(int set,String num){
        if(set==1){
            if(str1==null)
            {
                str1 = num;
            }else if(str1==null&&num.equals(".")){
              str1 = String.format("0.");
            } else{
                str1 = String.format(str1+num);
            }
        }else if(set==2){
            if(str2==null)
            {
                str2 = num;
            }else if(str1==null&&num.equals(".")){
                str1 = String.format("0.");
            } else{
                str2 = String.format(str2+num);
            }
        }
    }
    void back(){
        if(str2!=null&&str1!=null&&operator!=null){
            str2.substring(0,str2.length()-1);
        }else if(str1!=null&&operator!=null){
            operator = null;
        }else if(str1!=null){
            str1.substring(0,str1.length()-1);
        }
    }
    void delete(){
        str1 = null;
        str2 = null;
        operator = null;
    }
    void setOperator(String oper){
        switch (oper){
            case "+":
                this.operator = oper;
                break;
            case "-":
                this.operator = oper;
                break;
            case "*":
                this.operator = oper;
                break;
            case "/":
                this.operator = oper;
                break;
            case "%":
                this.operator = oper;
                break;
            case "^":
                this.operator = oper;
                break;
        }
    }
    void result(){
        float num1 = Float.parseFloat(str1);
        float num2 = Float.parseFloat(str2);
        switch (operator){
            case "+":
                result = num1+ num2;
                break;
            case "-":
                result = num1- num2;
                break;
            case "*":
                result = num1* num2;
                break;
            case "/":
                result = num1/ num2;
                break;
            case "%":
                result = num1% num2;
                break;
            case "^":
                float temp = num1;
                for(int i=1; i<num2;i++){
                    temp *= num1;
                }
                result = num1;
                break;
        }
    }
    float getResult(){
        return result;
    }
    String getFormula(){
        if(operator!=null&&this.str1!=null&&this.str2 != null){ //num2까지 있을때
            if(this.operator =="%"){
                return String.format(this.str1+"%"+this.operator+this.str2);
            }else{
                return String.format(this.str1+this.operator+this.str2);
            }
        }else if(operator!=null&&this.str1!=null){ //연산자까지 있을때
            if (this.operator == null){
                return String.format(this.str1+"");
            }
            if(this.operator == "%"){
                return String.format(this.str1+"%"+this.operator);
            }else{
                return String.format(this.str1+this.operator);
            }
        }else if(this.str1 != null){ //num1만 있을때
            return String.format(this.str1+"");
        }else{
            return String.format("");
        }
    }

    @Override
    public void setResult(int num) {
        this.result = num;
    }

    @Override
    int returnall() {
        return super.returnall();
    }
}
