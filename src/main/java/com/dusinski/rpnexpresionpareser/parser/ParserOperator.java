package com.dusinski.rpnexpresionpareser.parser;

public class ParserOperator implements ParserElement<String> {

    private final String operatorValue;

    ParserOperator(String input) {
        this.operatorValue = input;
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
}
