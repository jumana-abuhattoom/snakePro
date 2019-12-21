package model;

import java.util.ArrayList;

import utils.E_Level;

public class Question {
	private String questionNumber;
	private ArrayList<String> answers;
	private int IndexOfCorrectAnswer;
	private E_Level level;
	private int pointAdded;
	private int X, Y;

	public Question(String questionNumber, ArrayList<String> answers, int indexOfCorrectAnswer, E_Level level) {
		super();
		this.questionNumber = questionNumber;
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

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
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

	public int getPointAdded() {
		return pointAdded;
	}

	public void setPointAdded(int pointAdded) {
		this.pointAdded = pointAdded;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	@Override
	public String toString() {
		return "Question [questionNumber=" + questionNumber + ", answers=" + answers + ", IndexOfCorrectAnswer="
				+ IndexOfCorrectAnswer + ", level=" + level + "]";
	}

}
