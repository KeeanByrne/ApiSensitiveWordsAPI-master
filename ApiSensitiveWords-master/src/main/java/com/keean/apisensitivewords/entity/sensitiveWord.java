package com.keean.apisensitivewords.entity;

//----------------------------Import List----------------------------//
import jakarta.persistence.*;

//----------------------------Import List----------------------------//
@Entity
@Table(name = "wordlist")
public class sensitiveWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;

    //Constructors
    public sensitiveWord(){

    }
    public sensitiveWord(String word){
        this.word = word;
    }

    //Getters & Setters
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getWord(){
        return word;
    }
    public void setWord(String id){
        this.word = word;
    }

}