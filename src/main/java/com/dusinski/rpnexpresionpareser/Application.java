package com.dusinski.rpnexpresionpareser;

import com.dusinski.rpnexpresionpareser.parser.RPNParser;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {


        String rpnInputString="12 2 3 4 * 10 5 / + * +";

        RPNParser rpn = new RPNParser(rpnInputString);
        System.out.println(rpn.getConventionalNote());

//        System.out.println("Hello world: "+ Arrays.stream(args).findFirst());

    }


}
