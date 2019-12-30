package com.theredeemed.myapp;

import com.theredeemed.calcengine.*;

public class Main {

    public static void main(String[] args) {

        String[] statements = {
                "add 25.0 92.0",
                "power 5.0 2.0"
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf()
        });

        for (String statement: statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }
    }

    static void useCalculateHelper() {
        String[] statements = {
                "add 1.0",
                "add xx 25.0",
                "addX 0.0 0.0",
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };

        CalculateHelper helper = new CalculateHelper();
        for (String statement : statements) {
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out.println(" Original exception: " + e.getCause().getMessage());
            }
        }
    }

    static void useMathEquation() {
        System.out.println("****** Using Math Equation *******");

        MathEquation[] mathEquations = new MathEquation[4];
        mathEquations[0] = new MathEquation('d', 100.0d, 50.0d); // create(100.0d, 50.0d, 'd');
        mathEquations[1] = new MathEquation('a', 25.0d, 92.0d); //create(25.0d, 92.0d, 'a');
        mathEquations[2] = new MathEquation('s', 225.0d, 17.0d); //create(225.0d, 17.0d, 's');
        mathEquations[3] = new MathEquation('m', 11.0d, 3.0d); //create(11.0d, 3.0d, 'm');

        for (MathEquation equation : mathEquations) {
            equation.execute();
            System.out.println("Result = " + equation.getResult());
        }

        System.out.println("****** End Using Math Equation *******");
    }

    static void useCalculatorBase() {
        System.out.println("****** Using calculator base with Inheritance *******");
        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for (CalculateBase calculator : calculators) {
            calculator.calculate();
            System.out.println("Result " + calculator.getResult());
        }
        System.out.println("****** End Using calculator base with Inheritance *******");
    }

//    public static MathEquation create(double leftVal, double rightVal, char opCode) {
//        MathEquation mathEquation = new MathEquation();
//        mathEquation.setLeftVal(leftVal);
//        mathEquation.setRightVal(rightVal);
//        mathEquation.setOpCode(opCode);
//        return mathEquation;
//    }
}
