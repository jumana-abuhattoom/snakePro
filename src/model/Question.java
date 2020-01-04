package model;

import java.util.ArrayList;

import utils.Constants;
import utils.E_Level;

public class Question {
	private String question;
	private ArrayList<String> answers;
	private int IndexOfCorrectAnswer;
	private E_Level level;
	private int pointAdded;
	private int pointDecreaced;

	private int X, Y;

	public Question(String question, ArrayList<String> answers, int indexOfCorrectAnswer, E_Level level) {
		super();
		this.question = question;
		this.answers = answers;
		IndexOfCorrectAnswer = indexOfCorrectAnswer;
		this.level = level;
		switch (level) {
		case EASY:
			pointAdded = Constants.pointsAddedEasyQ;
			pointDecreaced = Constants.pointsDecreacedEasyQ;
			break;
		case MEDIUM:
			pointAdded = Constants.pointsAddedMediumQ;
			pointDecreaced = Constants.pointsDecreacedMediumQ;
			break;
		case HARD:
			pointAdded = Constants.pointsAddedHardQ;
			pointDecreaced = Constants.pointsDecreacedHardQ;
			break;
		}

	}

	public int getPointDecreaced() {
		return pointDecreaced;
	}

	public void setPointDecreaced(int pointDecreaced) {
		this.pointDecreaced = pointDecreaced;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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
		return "Question [question=" + question + ", answers=" + answers + ", IndexOfCorrectAnswer="
				+ IndexOfCorrectAnswer + ", level=" + level + "]";
	}

}
