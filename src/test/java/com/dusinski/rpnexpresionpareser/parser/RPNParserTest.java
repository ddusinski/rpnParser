package com.dusinski.rpnexpresionpareser.parser;
import org.junit.*;


public class RPNParserTest {


    @Test
    public void findConventionalNoteTest() {
        RPNParser testRPNparser= new RPNParser();
        //given
        String inputRPN = "12 3 5 8 * 1 7 / + * +";
        String rpnOutput = "( 12 + ( 3 * ( ( 5 * 8 ) + ( 1 / 7 ) ) ) )";
        //then
        org.junit.Assert.assertEquals(testRPNparser.findConventionalNote(inputRPN),rpnOutput);
    }

    @Test
    public void findRPNNoteTest() {
        RPNParser testRPNparser= new RPNParser();
        //given

        String input = "( 12 + ( 3 * ( ( 5 * 8 ) + ( 1 / 7 ) ) ) )";
        String output = "12 3 5 8 * 1 7 / + * + ";
        //then
        org.junit.Assert.assertEquals(testRPNparser.findRPNNote(input),output);
    }




}
