package com.theredeemed.calcengine;

public class Subtracter extends CalculateBase {

    public Subtracter() {}

    public Subtracter(double leftVal, double rightVal){
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        setResult(getLeftVal() - getRightVal());
    }
}
