package com.dusinski.rpnexpresionpareser.parser;

import java.util.Stack;

public class RPNParser {

    private final Stack<ParserElement> inputStack;
    private Stack<Integer> outputStack;


    public RPNParser(String rpnInput) {
        this.inputStack = new Stack<>();
        createInputStack(rpnInput);
        findConventionalNote();

    }

    public String getConventionalNote() {
        return this.outputStack.toString();
    }

    public boolean isInputCorrect(String input){
        return false;
    }

    private void createInputStack(String input) {

        String[] arr = input.split(" ");

        for (String str : arr) {
            if (isOperator(str)) {
                inputStack.add(new ParserOperator(str));
            } else
                inputStack.add(new ParserNumber(str));
        }
    }


    private void findConventionalNote() {
        this.outputStack = new Stack<>();

        for (ParserElement element : this.inputStack) {
            if (element.getClass() == ParserNumber.class) {
                this.outputStack.push(((ParserNumber) element).getElement());
            } else {
                Integer firstParserElement = this.outputStack.pop();
                Integer secondParserElement = this.outputStack.pop();
                this.outputStack.push(
                        ((ParserOperator) element).compute(secondParserElement, firstParserElement));
                System.out.println(secondParserElement + ((ParserOperator) element).getElement() + firstParserElement);

            }
        }
    }


    private boolean isOperator(String input) {
        return (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/"));
    }
}
