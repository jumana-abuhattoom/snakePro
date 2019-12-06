package model;

import java.util.ArrayList;

import utils.E_Level;

public class Question {
	    public String questionNumber;
	    public String team;
	    public String[] answers=new String[4];
	    public int IndexOfCorrectAnswer; 
	    public E_Level level;
	     
	    
	    
	public Question(String questionNumber, String team, String[] answers, int indexOfCorrectAnswer, E_Level level) {
			super();
			this.questionNumber = questionNumber;
			this.team = team;
			this.answers = answers;
			IndexOfCorrectAnswer = indexOfCorrectAnswer;
			this.level = level;
		}



		public String getQuestionNumber() {
			return questionNumber;
		}



		public void setQuestionNumber(String questionNumber) {
			this.questionNumber = questionNumber;
		}



		public String getTeam() {
			return team;
		}



		public void setTeam(String team) {
			this.team = team;
		}



		public String[] getAnswers() {
			return answers;
		}



		public void setAnswers(String[] answers) {
			this.answers = answers;
		}



		public int getIndexOfCorrectAnswer() {
			return IndexOfCorrectAnswer;
		}



		public void setIndexOfCorrectAnswer(int indexOfCorrectAnswer) {
			IndexOfCorrectAnswer = indexOfCorrectAnswer;
		}



		public E_Level getLevel() {
			return level;
		}



		public void setLevel(E_Level level) {
			this.level = level;
		}

	    
}
