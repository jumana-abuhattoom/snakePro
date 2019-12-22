package model;

import java.util.ArrayList;

import utils.E_Level;

public class Question {
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((questionNumber == null) ? 0 : questionNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (questionNumber == null) {
			if (other.questionNumber != null)
				return false;
		} else if (!questionNumber.equals(other.questionNumber))
			return false;
		return true;
	}

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

	@Override
	public String toString() {
		return "Question [questionNumber=" + questionNumber + ", answers=" + answers + ", IndexOfCorrectAnswer="
				+ IndexOfCorrectAnswer + ", level=" + level + "]";
	}
    
    
    
    
	    
}
