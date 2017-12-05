package app;

import app.entities.Text;
import app.entities.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово,
 * Предложение, Знак препинания и др. Во всех задачах с формированием текста заменять табуляции
 * и последовательности пробелов одним пробелом.
 * 8. Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном порядке по первой согласной букве слова.
 */
public class Main {
    public static void main(String...args){
        Text text = new Text("book.txt");
        ArrayList<Word> words = text.getSortedWords();
        for(Word w:words){
            System.out.println(w.toString());
        }
    }
}
