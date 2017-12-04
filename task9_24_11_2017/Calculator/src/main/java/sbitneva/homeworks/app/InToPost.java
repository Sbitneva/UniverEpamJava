package app;

public class InToPost // Преобразование инфиксной записи в постфиксную
{
    private StackX theStack;
    private String input;
    private String output = "";

    public InToPost(String in){
        input = in.replaceAll("\\ +","");
        int stackSize = input.length();
        theStack = new StackX(stackSize);
    }
    //--------------------------------------------------------------
    public String doTrans(){ // Преобразование в постфиксную форму

        for(int j = 0; j < input.length(); j++){
            int index = j + 1;
            while (index<input.length()){

                if(Character.isAlphabetic(input.charAt(j)) && Character.isAlphabetic(input.charAt(index))){
                    index++;
                }
                else if (Character.isDigit(input.charAt(j)) && Character.isDigit(input.charAt(index))){
                    index++;
                }
                else {
                    break;
                }
            }

            String ch = input.substring(j, index);
            j = index-1;
            theStack.displayStack("For "+ ch + " ");
            switch(ch){
                case "+":
                case "-":
                    gotOper(ch, 1); // Извлечение операторов
                    break; // (приоритет 1)
                case "*": // * или /
                case "/":
                    gotOper(ch, 2); // Извлечение операторов
                    break; // (приоритет 2)
                case "(":
                case "cos":
                case "sin":
                    theStack.push(ch); // Занести в стек
                    break;
                case ")": // Закрывающая круглая скобка
                    gotParen(ch); // Извлечение операторов
                    break;
                default: // Остается операнд
                    output = output + " " + ch; // Записать в выходную строку
                    break;
            }
        }
        while( !theStack.isEmpty() ) // Извлечение оставшихся операторов
        {
            theStack.displayStack("While "); // *диагностика*
            output = output + " " +  theStack.pop();
        }
        theStack.displayStack("End "); // *диагностика*
        return output; // Возвращение постфиксного выражения
    }
    //--------------------------------------------------------------
    public void gotOper(String opThis, int prec1){
     // Чтение оператора из входной строки
        while( !theStack.isEmpty() )
        {
            String opTop = theStack.pop();
            if(opTop.equals("(")) // Если это '('
            {
                theStack.push(opTop); // Вернуть '('
                break;
            }
            else // Оператор
            {
                int prec2; // Приоритет нового оператора
                if(opTop.equals("+") || opTop.equals("-")) // Определение приоритета
                    prec2 = 1;
                else
                    prec2 = 2;
                if(prec2 < prec1) // Если приоритет нового оператора
                { // меньше приоритета старого
                    theStack.push(opTop); // Сохранить новый оператор
                    break;
                }
                else // Приоритет нового оператора
                    output = output + " " + opTop; // не меньше приоритета старого
            }
        }
        theStack.push(opThis + ""); // Занесение в стек нового оператора
    }

    public void gotParen(String ch){
        // Прочитана закрывающая скобка
        while(!theStack.isEmpty() )
        {
            String chx = theStack.pop();
            if(chx.equals("(")){
                break;  // Если извлечен элемент ‘(‘
            }
            else { // Если извлечен оператор
                output = output + " " + chx;
            }
        }
    }
}
