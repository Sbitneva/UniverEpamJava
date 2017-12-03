package app;

public class ParsePost
{
    private StackX stack;
    private String input;

    public ParsePost(String s){
        this.input = s;
    }

    public double doParse(){
        stack = new StackX(20);
        String ch;
        int j;
        double num1, num2;
        double interAns;

        for(j = 0; j < input.length(); j++){
            int index = j + 1;

            while ( index < input.length()){
                if (input.charAt(index)!=' ')index++;
                else break;
            }

            ch = input.substring( j ,index);
            j = index;

            stack.displayStack("" + ch + " ");

            if(ch.charAt(0) >= '0' && ch.charAt(0) <= '9') {
                stack.push((ch));
            }
            else
            {
                num2 = Double.parseDouble(stack.pop());
                switch(ch)
                {
                    case "+":
                        String pop = stack.pop();
                        if (pop == null) pop = "0";
                        num1 = Double.parseDouble(pop);
                        interAns = num1 + num2;
                        break;
                    case "-":
                        pop = stack.pop();
                        if (pop == null) pop = "0";
                        num1 = Double.parseDouble(pop);
                        interAns = num1 - num2;
                        break;
                    case "*":
                        pop = stack.pop();
                        if (pop == null) pop = "1";
                        num1 = Double.parseDouble(pop);
                        interAns = num1 * num2;
                        break;
                    case "/":
                        pop = stack.pop();
                        if (pop == null) pop = "1";
                        num1 = Double.parseDouble(pop);
                        interAns = num1 / num2;
                        break;
                    case "cos":
                        interAns = Math.cos(Math.toDegrees(num2));
                        break;
                    case "sin":
                        interAns = Math.sin(Math.toDegrees(num2));
                        break;
                    default:
                        interAns = 0;
                }
                stack.push(interAns + " ");
            }
        }
        interAns = Double.parseDouble(stack.pop());
        return interAns;
    }
}