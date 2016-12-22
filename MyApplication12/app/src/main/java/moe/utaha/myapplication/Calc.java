package moe.utaha.myapplication;

import android.widget.Toast;

import java.text.NumberFormat;

/**
 * Created by chojeaho on 2016-05-18.
 */
public class Calc extends Calcparent implements Calcinterface{
    public float num1=0,num2=0,result;
    public int cnt = 1;
    public int cnt2 = 1;
    public boolean isDeci = false;
    public boolean isOperator = false;
    public boolean isResult = false;
    public String operator = null;

    public void setNum1(float num)
    {
        if(this.isDeci&&num!=0)
        {
            for(int i=1;i<=this.cnt;i++)
            {
                num/=10;
            }
            this.num1 += num;
            cnt++;
        }else {
            this.num1 = this.num1 * 10;
            this.num1 += num;
        }
    }
    void setNum2(float num)
    {
        if(this.isDeci&&num!=0)
        {
            cnt2++;
            for(int i=1;i<=this.cnt2;i++)
            {
                num/=10;
            }
            this.num2 += num;
        }else {
            this.num2 = this.num2 * 10;
            this.num2 += num;
        }
    }
    void Deci()
    {
        this.isDeci = true;
    }
    void setOperator(String str) //연산자 초기화 함수
    {
        if(!isOperator) { //연산자 버튼 입력이 없었을때 연산자 초기화를 한다
            switch (str) {
                case "+":
                    this.operator = "+";
                    break;
                case "-":
                    this.operator = "-";
                    break;
                case "*":
                    this.operator = "*";
                    break;
                case "/":
                    this.operator = "/";
                    break;
                case "^":
                    this.operator = "^";
                    break;
                case "%":
                    this.operator = "%";
                    break;
            }
            this.isDeci = false; //num2입력을 위해 isDeci즉 소수점을 false로한다
            cnt = 1;
            this.isOperator = true;//연산자 중복입력을 막기위해 isOperator를 true로 한다.
        }
    }
    void back(){
        if(isOperator&&num2!=0){//num2까지 있을때
            if(isDeci==true){
                //소수점 하나 지우기
                NumberFormat nf = NumberFormat.getInstance();
                nf.setMaximumFractionDigits(cnt2-1);
                nf.format(num1);
                if(num2==0){
                    isDeci =false;
                }
                cnt2--;
            }else{
                num2 = (int)num2/10;
            }
        }else if(isOperator&&num2==0){//연산자 까지 있을때
            this.operator = null;
            isOperator = false;
        }else if(!isOperator&&num1!=0){//num1만 있을때
            if(isDeci||num1%1!=0){
                if(isDeci==true){
                    //소수점 하나 지우기
                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(cnt-1);
                    nf.format(num1);
                    if(num1==0){
                        isDeci = false;
                    }
                    cnt--;
                }else{
                    num1 = (int)num1/10;
                }
            }
        }
    }
    int getStat()
    {
        if(isOperator){
            return 1;
        }else{
            return 0;
        }
    }
    void delete(){ //AC버튼
        this.num1=0;
        this.num2=0;
        this.operator = null;
        this.result = 0;
        this.cnt = 1;
        this.cnt2 = 1;
        this.isOperator = false;
        this.isDeci = false;
        this.isResult = false;
    }
    float result(){ //=버튼
        if(isOperator) {
            switch (this.operator) {
                case "+":
                    result = this.num1 + this.num2;
                    break;
                case "-":
                    result = this.num1 - this.num2;
                    break;
                case "*":
                    result = this.num1 * this.num2;
                    break;
                case "/":
                    result = this.num1 / this.num2;
                    break;
                case "^":
                    float temp = this.num1;
                    for (int i = 1; i < (int)this.num2; i++) {
                        temp = temp*this.num1;
                    }
                    result = temp;
                    break;
                case "%":
                    result = num1 % num2;
                    break;
            }
        }
        this.isDeci = false;
        this.isOperator = false;
        this.isResult = true;
        return result;
    }
    String getFormula(){//연산식을 가지고오는 함수
        if(isOperator&&this.num1!=0&&this.num2 != 0){ //num2까지 있을때
            if(this.operator =="%"){
                return String.format(this.num1+"%"+this.operator+this.num2);
            }else{
                return String.format(this.num1+this.operator+this.num2);
            }
        }else if(isOperator&&this.num1!=0){ //연산자까지 있을때
            if (this.operator == null){
                return String.format(this.num1+"");
            }
            if(this.operator == "%"){
                return String.format(this.num1+"%"+this.operator);
            }else{
                return String.format(this.num1+this.operator);
            }
        }else{ //num1만 있을때
            return String.format(this.num1+"");
        }
    }
    String getResult(){
        if(isResult)
        {
            return Float.toString(this.result);
        }else{
            return null;
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
