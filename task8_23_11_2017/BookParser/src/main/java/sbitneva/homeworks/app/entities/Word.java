package app.entities;

public class Word{
    String word;
    public Word(String word){
        this.word = word;
    }

    @Override
    public String toString() {
        return this.word;
    }
}
