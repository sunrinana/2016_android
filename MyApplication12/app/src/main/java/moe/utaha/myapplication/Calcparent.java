package moe.utaha.myapplication;

/**
 * Created by chojeaho on 2016-06-27.
 */
public class Calcparent extends abstractCalcparent {
    int returnNum = 0;
    @Override
    int returnall() {
        return this.returnNum;
    }
}
