package com.dusinski.rpnexpresionpareser.parser;

import javax.xml.transform.Result;
import java.util.Stack;

public class RPNParser {

    private final Stack<ParserElement> inputStack;
    private Stack<Object> outputStack;


    public RPNParser(String rpnInput) {
        this.inputStack = new Stack<>();
        this.outputStack = new Stack<>();
        createInputStack(rpnInput);
    }



    public String getResult() {
        return this.outputStack.toString();
    }

    public boolean isInputCorrect(String input) {
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


    public void findResult() {
        this.outputStack = new Stack<>();

        for (ParserElement element : this.inputStack) {
            if (element.getClass() == ParserNumber.class) {
                this.outputStack.push(((ParserNumber) element).getElement());
            } else {
                Integer firstParserElement = (Integer) this.outputStack.pop();
                Integer secondParserElement = (Integer) this.outputStack.pop();
                this.outputStack.push(
                        ((ParserOperator) element).compute(secondParserElement, firstParserElement));
                //System.out.println(secondParserElement + ((ParserOperator) element).getElement() + firstParserElement);
            }
        }
    System.out.println("Result: "+this.outputStack.toString());
    }

    public void findConventionalNote() {
        String conventionalNote;
        for (ParserElement element : this.inputStack) {
            if (element.getClass() == ParserNumber.class) {
                this.outputStack.push(((ParserNumber) element).getElement().toString());
            } else {
                String firstParserElement = (String) this.outputStack.pop();
                String secondParserElement = (String) this.outputStack.pop();
                conventionalNote = "(" + secondParserElement + ((ParserOperator) element).getElement() + firstParserElement + ")";
                this.outputStack.push(conventionalNote);
            }
        }
        System.out.println("Conventional Note: "+this.outputStack.toString());
    }

    private boolean isOperator(String input) {
        return (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/"));
    }
}
