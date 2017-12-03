package app.entities;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {

    String bookText;
    public Text(String path){
        this.bookText = BookReader.read(path);
        this.bookText = bookText.replaceAll("\\R|\\s+", " ");
    }

    public ArrayList<Word> getSortedWords(){
        HashSet<String> words = new HashSet<String>();
        ArrayList<String> arrayList = new ArrayList<String>();
        Pattern pattern = Pattern.compile("(?<!\\S)[AaEeIiOoUuYyАаЕеЁёИиОоУуЫыЭэЮюЯя]\\p{Alpha}*(?!\\S)",
                Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(this.bookText);
        while(matcher.find()){
            words.add(matcher.group());
        }

        for(Iterator<String> it = words.iterator(); it.hasNext();){
            arrayList.add(it.next());
        }

        arrayList.sort(new Comparator<String>() {
            public int compare(String s, String t1) {
                return (t1.replaceAll("^[AaEeIiOoUuYyАаЕеЁёИиОоУуЫыЭэЮюЯя]+", "")).
                        compareTo(s.replaceAll("^[AaEeIiOoUuYyАаЕеЁёИиОоУуЫыЭэЮюЯя]+", ""));
            }
        });

        ArrayList<Word> wordArrayList = new ArrayList<>();
        for(String i:arrayList){
            wordArrayList.add(new Word(i));
        }

        return wordArrayList;
    }
}
