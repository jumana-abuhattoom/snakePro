package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import model.Player;
import model.Question;
import utils.E_Level;

public class sysdata   {

	// Players and questions
	public Set<Player> players;
	public Set<Question> questions;
	// singletone's instance
	private static sysdata instance;

	
	private sysdata() {
		players = new HashSet<>();
		questions = new HashSet<>();
	}

	// Singletone
	public static sysdata getInstance() {
		if (instance == null) {
			instance = new sysdata();
			return instance;
		} else
			return instance;
	}
/////////
//public static boolean load(){
//		
//		FileInputStream fiellastesaved = null;
//		try {
//			fiellastesaved = new FileInputStream("Game.ser");
//			
//			ObjectInputStream IBuyesaved = new ObjectInputStream(fiellastesaved);
//			 instance = (sysdata) IBuyesaved.readObject();
//			
//		} catch (IOException | ClassNotFoundException e) {
//			return false;
//		} finally {
//			System.out.println("11");
//			try {
//				if (fiellastesaved != null) {
//					fiellastesaved.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return true;
//		}
//////////////

	// Adding new player
	public boolean AddPlayer(String name, String password) {
		for (Player p : players) {
			if (p.name.equals(name)) {
				return false;
			}
		}
		if (name.equals("Admin") || name.equals("admin"))
			return false;

		players.add(new Player(name, password));
		return true;
	}

	public boolean DeletePlayer(String name, String password) {
		for (Player p : players) {
			if (p.name.equals(name)) {
				players.remove(p);
				return true;
			}
		}

		return false;
	}

	// Adding New Question
	public boolean AddQuestion(String question, ArrayList<String> answers, int IndexOfCorrectAnswer, int level) {
		if (question == null || answers == null || IndexOfCorrectAnswer < 0 || IndexOfCorrectAnswer > 4 || level < 1
				|| level > 3)
			return false;

		Question q = new Question(question, answers, IndexOfCorrectAnswer, E_Level.getLevelbyNumber(level));

		// if one of the answers is empty
		for (String ans : answers) {
			if (ans.equals(""))
				return false;
		}

		// if two answers are identical:

		if (answers.get(0).equals(answers.get(1)) || answers.get(0).equals(answers.get(2))
				|| answers.get(0).equals(answers.get(3)) || answers.get(1).equals(answers.get(2))
				|| answers.get(2).equals(answers.get(3)) || answers.get(3).equals(answers.get(1))) {
			return false;
		}
		// duplicate questions
		for (Question qq : questions) {
			if (qq.getQuestion().equals(question)) {
				return false;
			}
		}
		if (this.questions.add(q)) {
			for (Question qtest : questions) {
				System.out.println(qtest);
			}
			return true;
		}
		return false;
	}

	// update question
	public boolean UpdateQuestion(String questionNumber, ArrayList<String> answers, int IndexOfCorrectAnswer,
			int level) {
		if (questionNumber == null || answers == null || IndexOfCorrectAnswer < 0 || IndexOfCorrectAnswer > 4
				|| level < 1 || level > 3)
			return false;

		Question q = new Question(questionNumber, answers, IndexOfCorrectAnswer, E_Level.getLevelbyNumber(level));

		// if one of the answers is empty
		for (String ans : answers) {
			if (ans.equals(""))
				return false;
		}

		// if two answers are identical:

		if (answers.get(0).equals(answers.get(1)) || answers.get(0).equals(answers.get(2))
				|| answers.get(0).equals(answers.get(3)) || answers.get(1).equals(answers.get(2))
				|| answers.get(2).equals(answers.get(3)) || answers.get(3).equals(answers.get(1))) {
			return false;
		}
		// duplicate question numbers
		for (Question qq : questions) {
			if (qq.getQuestion().equals(questionNumber)) {
				qq.setAnswers(q.getAnswers());
				qq.setIndexOfCorrectAnswer(q.getIndexOfCorrectAnswer());
				qq.setLevel(q.getLevel());
				return true;
			}
		}

		return false;
	}

	// delete Question
	public boolean DeleteQuestion(String num) {
		if (num == null)
			return false;

		for (Question q : questions) {
			if (q.getQuestion().equals(num)) {
				questions.remove(q);
				return true;
			}
		}
		return false;
	}
	// --------------------------------------------------Helping methods for
	// tests------------------------------------------------

	public boolean CheckUsernameAndPassword(String User, String Pass) {
		for (Player p : sysdata.getInstance().players) {
			if (p.name.equals(User) && p.password.equals(Pass)) {
				return true;
			}
		}
		return false;
	}

	public boolean UpdatePlayerDetails(String prevUser, String PrevPass, String CurrentUser, String CurrentPass) {
		sysdata.getInstance().DeletePlayer(prevUser, PrevPass);
		if (sysdata.getInstance().AddPlayer(CurrentUser, CurrentPass)) {
			return true;
		} else {
			sysdata.getInstance().AddPlayer(prevUser, PrevPass);
			return false;
		}
	}

}
