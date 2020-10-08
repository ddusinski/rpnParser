package com.dusinski.rpnexpresionpareser.parser;
import java.util.Stack;

public class RPNParser {


    public boolean isInputCorrect(String input) {
        return false;
    }

    private Stack<ParserElement> createInputStack(String input) {

        Stack<ParserElement> inputStack = new Stack<>();

        String[] arr = input.split(" ");

        for (String str : arr) {

            if (isOperator(str)) {
                inputStack.add(new ParserOperator(str));
            } else
                inputStack.add(new ParserNumber(str));
        }
        return inputStack;
    }

    private String findResult(String inputRPNnote) {
        Stack<ParserElement> inputResultStack =  createInputStack(inputRPNnote);
        Stack<Object> outputResultStack = new Stack<>();

        for (ParserElement element : inputResultStack) {
            if (element.getClass() == ParserNumber.class) {
                outputResultStack.push(((ParserNumber) element).getElement());
            } else {
                Integer firstParserElement = (Integer) outputResultStack.pop();
                Integer secondParserElement = (Integer) outputResultStack.pop();
                outputResultStack.push(
                        ((ParserOperator) element).compute(secondParserElement, firstParserElement));
                       }
        }
        return outputResultStack.toString();
    }

    public String findRPNResult(String inputRPNnote){
        return findResult(inputRPNnote);
    }

    public String findCONResult(String inputCONnote){
        return findResult(findRPNNote(inputCONnote));
    }

    public String findConventionalNote(String inputRPNnote) {
        Stack<ParserElement> inputStackRPN =  createInputStack(inputRPNnote);
        Stack<String> outputStackCON = new Stack<>();
        String conventionalNote="";

        for (ParserElement element : inputStackRPN) {
            if (element.getClass() == ParserNumber.class) {
                outputStackCON.push(((ParserNumber) element).getElement().toString());
            } else {
                String firstParserElement = (String) outputStackCON.pop();
                String secondParserElement = (String) outputStackCON.pop();
                conventionalNote = "( " + secondParserElement +" "+ ((ParserOperator) element).getElement()+" " + firstParserElement + " )";
                outputStackCON.push(conventionalNote);
            }
        }
        return conventionalNote;
    }

    private String printResult(Stack<String> outputString){
        String result="";

        for (String str :outputString){
            result=result+str+" ";
        }
        return result;
    }

    public String findRPNNote(String inputCON) {
        Stack<ParserElement> inputStackCON =  createInputStack(inputCON);
        Stack<ParserElement> tempStack = new Stack<>();
        Stack<String> outputStackRPN = new Stack<>();

        for (ParserElement element : inputStackCON) {
            if (element.getClass() == ParserNumber.class){
                outputStackRPN.push(element.toString());
            }
            else if (element.toString().equals("(")){
                tempStack.push(element);
            }
            else  if (element.toString().equals(")")){
                while(!tempStack.peek().toString().equals("(")){
                    outputStackRPN.push(tempStack.pop().toString());
                }
                tempStack.pop();
            }
            else if (tempStack.empty()||((ParserOperator)element).getOperatorPriority()>((ParserOperator)tempStack.peek()).getOperatorPriority()){
                tempStack.push(element);
            }
            else {
                outputStackRPN.push(tempStack.pop().toString());
                tempStack.push(element);
            }
        }

        int tempStackSize=tempStack.size();
        for (int i=0; i<tempStackSize;i++)
        {
            outputStackRPN.push(tempStack.pop().toString());
        }
        return printResult(outputStackRPN);
    }

    private boolean isOperator(String input) {
        return (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") ||
                input.equals("(") || input.equals(")"));
    }
}
