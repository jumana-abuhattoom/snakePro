package model;

import java.util.ArrayList;

import utils.E_Level;

public class Question {
    public String questionNumber;
    public ArrayList<String> answers;
    public int IndexOfCorrectAnswer; 
    public E_Level level;
    
    public Question(String questionNumber,ArrayList<String> answers,int IndexOfCorrectAnswer,int level){
    this.questionNumber= questionNumber;
    this.IndexOfCorrectAnswer = IndexOfCorrectAnswer;
    this.level = E_Level.getLevelbyNumber(level);
    this.answers = new ArrayList<>();
    this.answers.addAll(answers);            
    }
    
    public Question(String questionNumber,ArrayList<String> answers,int IndexOfCorrectAnswer,E_Level level){
    	this.questionNumber= questionNumber;
    	this.IndexOfCorrectAnswer = IndexOfCorrectAnswer;
    	this.level = level;
    	this.answers = new ArrayList<>();
    	this.answers.addAll(answers);            
    }
    
    
	    
}
