package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {

        String input;
        String postfix;
        double result;

        while (true) {
            System.out.print("Enter infix: ");
            System.out.flush();

            input = getString();

            if (input.equals("")) {
                break;
            }


            InToPost theTrans = new InToPost(input);
            postfix = theTrans.doTrans().trim(); // do the translation
            System.out.println(postfix);


            ParsePost aParser = new ParsePost(postfix);
            result = aParser.doParse();  // do the evaluation
            if (result == Math.round(result))
                System.out.println("Evaluates to " + Math.round(result));
            else
                System.out.println("Evaluates to " + result);
        }
    }
    public static String getString() throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        return br.readLine();
    }
}
