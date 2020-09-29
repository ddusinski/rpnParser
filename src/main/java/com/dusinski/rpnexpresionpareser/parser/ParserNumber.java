package com.dusinski.rpnexpresionpareser.parser;

public class ParserNumber implements ParserElement<Integer>{

    private Integer numberValue;

     ParserNumber(String input){
        this.numberValue = Integer.parseInt(input);
    }

    @Override
    public Integer getElement() {
        return this.numberValue;
    }

    @Override
    public String toString() {
        return this.numberValue.toString();
    }

}
