package com.dusinski.rpnexpresionpareser;

import com.dusinski.rpnexpresionpareser.parser.RPNParser;


public class Application {

    public static void main(String[] args) {

        RPNParser rpn = new RPNParser();
        String rpnInputString = "12 3 5 8 * 1 7 / + * +";
        System.out.println("Conv Note: " + rpn.findConventionalNote(rpnInputString));
        System.out.println("RPN Note result: " + rpn.findRPNResult(rpnInputString));

        //rpnInputString="12 + 3 * ( 5 * 8 + 1 / 7 )";
        rpnInputString = "( 12 + ( 3 * ( ( 5 * 8 ) + ( 1 / 7 ) ) ) )";
        System.out.println("RPN Note: " + rpn.findRPNNote(rpnInputString));
        System.out.println("CONV Note result: " + rpn.findCONResult(rpnInputString));


    }

}
