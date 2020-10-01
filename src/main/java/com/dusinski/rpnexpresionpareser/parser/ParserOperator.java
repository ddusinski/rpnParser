package com.dusinski.rpnexpresionpareser.parser;

public class ParserOperator implements ParserElement<String> {

    private final String operatorValue;
    private final int operatorPriority;

    ParserOperator(String input) {
        this.operatorValue = input;

        switch (input) {
            case "+":
            case "-":
            case ")":
                this.operatorPriority=1;
                break;
            case "*":
            case "/":
                this.operatorPriority=2;
                break;
            default:
                this.operatorPriority = 0; //"("
                break;
        }
    }


    public Integer compute(Integer a, Integer b) {
        Integer result;

        switch (this.operatorValue) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                result = null;
                break;
        }

        return result;
    }

    @Override
    public String getElement() {
        return this.operatorValue;
    }

    @Override
    public String toString() {
        return operatorValue;
    }

    public int getOperatorPriority() {
        return this.operatorPriority;
    }
}
