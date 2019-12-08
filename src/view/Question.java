/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;

import utils.E_Level;

/**
 *
 * @author Jumana abuHattoum
 */
public class Question {
    public String questionNumber;
    public ArrayList<String> answers;
    public int IndexOfCorrectAnswer; 
    E_Level level;
    
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
