package com.dusinski.rpnexpresionpareser;

import com.dusinski.rpnexpresionpareser.parser.RPNParser;



public class Application {

    public static void main(String[] args) {


//        String rpnInputString="12 2 3 4 * 10 5 / + * +";

//        String rpnInputString="12 + 3 * ( 5 * 8 + 1 / 7 )";

        String rpnInputString="12 3 5 8 * 1 7 / + * +";
//12 3 5 8 * 1 7 / + * +


        RPNParser rpn = new RPNParser(rpnInputString);
        rpn.findConventionalNote();
//        rpn.findResult();

//        rpn.convConventionalToRPN();

//        System.out.println("Hello world: "+ Arrays.stream(args).findFirst());

    }


}
