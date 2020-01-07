package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Question;

public class QuestionView {

	public static boolean showQuestions(Question q) {
	

		// items for the dialog
		String Answers[] = new String[4];
		Answers[0] = q.getAnswers().get(0);
		Answers[1] = q.getAnswers().get(1);
		Answers[2] = q.getAnswers().get(2);
		Answers[3] = q.getAnswers().get(3);
		  JComboBox optionList = new JComboBox(Answers);
		   optionList.setSelectedIndex(0);
		      JPanel jpan = new JPanel (new BorderLayout());
		      jpan.add(new JLabel(q.getQuestion()),BorderLayout.CENTER);
		      jpan.add(optionList,BorderLayout.SOUTH);
		ImageIcon icon = new ImageIcon("src/icon/Qicon.png");

		int x = JOptionPane.showOptionDialog(null, jpan, "Answer Question", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, icon, null, null);

		if (x == q.getIndexOfCorrectAnswer()) {
			JOptionPane.showMessageDialog(null, "Good Gob :) Correct Answer!");
			return true;
		} else {

			JOptionPane.showMessageDialog(null, "Sorry :( Wrong Answer!");
			return false;
		}
	

	}
}
