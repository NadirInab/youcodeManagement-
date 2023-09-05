package main.java.com.Author;

import main.java.com.Book.Book ;
import java.util.List;
public class Author {
    private int id ;
    private String name ;

    private List <Book> books ;

    public int getId(){
        return id ;
    }

    public void setId(int id){
        this.id = id ;
    }

    public String getName(){
        return name ;
    }

    public void setName(String name){
        this.name = name ;
    }
}
