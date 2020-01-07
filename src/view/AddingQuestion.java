package view;

import javax.swing.*;
import controller.importFromJson;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AddingQuestion  extends JFrame {

	
	private static final long serialVersionUID = 1L;

		public AddingQuestion() {
			setBounds(new Rectangle(0, 0, 700, 730));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			Toolkit toolK = getToolkit();
			Dimension size = toolK.getScreenSize();
			setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
			getContentPane().setLayout(null);

			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(MainPage.class.getResource("/icon/background.jpg")));
			label.setBounds(0, 0, 700, 730);
			label.setLayout(null);
			getContentPane().add(label);

			// question display
			JLabel question = new JLabel("Enter Question");
			question.setFont(new Font("Tahoma", Font.PLAIN, 16));
			question.setBounds(50, 30, 150, 47);
			label.add(question);

			JTextField questionTxt = new JTextField();
			questionTxt.setBounds(180, 30, 450, 47);
			questionTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label.add(questionTxt);
			// answer 1 display
			JLabel answer1 = new JLabel("Answer 1");
			answer1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			answer1.setBounds(50, 100, 80, 47);
			label.add(answer1);

			JTextField answer1Txt = new JTextField();
			answer1Txt.setBounds(180, 100, 450, 47);
			answer1Txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label.add(answer1Txt);

			// answer 2 display
			JLabel answer2 = new JLabel("Answer 2");
			answer2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			answer2.setBounds(50, 170, 80, 47);
			label.add(answer2);

			JTextField answer2Txt = new JTextField();
			answer2Txt.setBounds(180, 170, 450, 47);
			answer2Txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label.add(answer2Txt);

			// answer 3 display
			JLabel answer3 = new JLabel("Answer 3");
			answer3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			answer3.setBounds(50, 240, 80, 47);
			label.add(answer3);

			JTextField answer3Txt = new JTextField();
			answer3Txt.setBounds(180, 240, 450, 47);
			answer3Txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label.add(answer3Txt);

			// answer 4 display
			JLabel answer4 = new JLabel("Answer 4");
			answer4.setFont(new Font("Tahoma", Font.PLAIN, 16));
			answer4.setBounds(50, 310, 80, 47);
			label.add(answer4);

			JTextField answer4Txt = new JTextField();
			answer4Txt.setBounds(180, 310, 450, 47);
			answer4Txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label.add(answer4Txt);


			// level display
			JLabel level = new JLabel("Level");
			level.setFont(new Font("Tahoma", Font.PLAIN, 16));
			level.setBounds(50, 450, 80, 47);
			label.add(level);
			JComboBox<String> LevelComboBox = new JComboBox<String>();
			LevelComboBox.setBounds(170, 450, 150, 47);
			LevelComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
			LevelComboBox.addItem("Easy");
			LevelComboBox.addItem("Medium");
			LevelComboBox.addItem("Hard");
			label.add(LevelComboBox);
			LevelComboBox.setVisible(false);
			level.setVisible(false);

			// correct answer display
			JLabel answer = new JLabel("Correct answer");
			answer.setFont(new Font("Tahoma", Font.PLAIN, 16));
			answer.setBounds(50, 520, 150, 47);
			label.add(answer);
			JComboBox<String> correctAnswerComboBox = new JComboBox<String>();
			correctAnswerComboBox.setBounds(170, 520, 150, 47);
			correctAnswerComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label.add(correctAnswerComboBox);
			correctAnswerComboBox.setVisible(false);
			answer.setVisible(false);

			// save changes button
					JButton saveChanges = new JButton("save Changes");
					saveChanges.setBounds(50, 590, 300, 47);
					saveChanges.setFont(new Font("Tahoma", Font.PLAIN, 16));
					saveChanges.setBackground(new Color(153, 204, 153));
					label.add(saveChanges);
					saveChanges.setVisible(false);
					saveChanges.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							saveChangesActionPerformed(evt);
						}

						private void saveChangesActionPerformed(ActionEvent evt) {
							// TODO Auto-generated method stub
						
							ArrayList<String> ta = new ArrayList<>();
							ta.add(answer1Txt.getText());
							ta.add(answer2Txt.getText());
							ta.add(answer3Txt.getText());
							ta.add(answer4Txt.getText());

							if (importFromJson.Addquestiontojson(questionTxt.getText(), ta, correctAnswerComboBox.getSelectedIndex(),
									LevelComboBox.getSelectedIndex() + 1)) {
								JOptionPane.showMessageDialog(rootPane, "Your Question have been Added Successfully", "Success",
										JOptionPane.INFORMATION_MESSAGE);
								setVisible(false);
								QuestionManager qm = new QuestionManager();
								qm.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(rootPane, "wrong details try again ", "Error", JOptionPane.ERROR_MESSAGE);

							}
						}
						
					});
					// cancel button
					JButton cancel = new JButton("Cancel");
					cancel.setBounds(50, 640, 300, 47);
					cancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
					cancel.setBackground(new Color(153, 204, 153));
					label.add(cancel);
					cancel.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							cancelActionPerformed(evt);
						}

						private void cancelActionPerformed(ActionEvent evt) {
							setVisible(false);
							QuestionManager qm = new QuestionManager();
							qm.setVisible(true);
						}
						
					});			
			// continue button
			JButton Continue = new JButton("Continue");
			Continue.setBounds(50, 380, 300, 47);
			Continue.setFont(new Font("Tahoma", Font.PLAIN, 16));
			Continue.setBackground(new Color(153, 204, 153));
			label.add(Continue);
			Continue.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					continueActionPerformed(evt);
				}

				private void continueActionPerformed(ActionEvent evt) {
					// TODO Auto-generated method stub
					correctAnswerComboBox.removeAllItems();
					correctAnswerComboBox.addItem(answer1Txt.getText());
					correctAnswerComboBox.addItem(answer2Txt.getText());
					correctAnswerComboBox.addItem(answer3Txt.getText());
					correctAnswerComboBox.addItem(answer4Txt.getText());
					correctAnswerComboBox.setVisible(true);
					LevelComboBox.setVisible(true);
					answer.setVisible(true);
					level.setVisible(true);
					saveChanges.setVisible(true);
				}
			});

			
		}
	

}
