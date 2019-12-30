package com.theredeemed.calcengine;

public class Adder extends CalculateBase implements MathProcessing {

    public Adder() {}

    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);   //This is calling the constructor from the parent class
    }

    @Override
    public void calculate() {
        setResult(getLeftVal() + getRightVal());
    }

    @Override
    public String getKeyWord() {
        return "add";
    }

    @Override
    public char getSymbol() {
        return '+';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}
