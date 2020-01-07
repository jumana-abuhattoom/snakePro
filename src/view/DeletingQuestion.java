package view;

import javax.swing.*;

import controller.importFromJson;
import controller.sysdata;
import model.Question;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DeletingQuestion extends JFrame {

	private static final long serialVersionUID = 1L;

	public DeletingQuestion() {
		setBounds(new Rectangle(0, 0, 700, 730));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Toolkit toolK = getToolkit();
		Dimension size = toolK.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		getContentPane().setLayout(null);

		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainPage.class.getResource("/icon/background.jpg")));
		label.setBounds(0, 0, 700, 730);
		label.setLayout(null);
		getContentPane().add(label);

		//label
		JLabel qLabel = new JLabel("Select Question To Delete");
		qLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		qLabel.setBounds(180, 80, 400, 47);
		label.add(qLabel);

		//questions comboBox
		JComboBox<String> qComboBox = new JComboBox<String>();
		qComboBox.setBounds(50, 150, 600, 47);
		qComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		for (Question q : sysdata.getInstance().questions) {
			qComboBox.addItem(q.getQuestion());
		}
		label.add(qComboBox);

		// delete button
		JButton deleteQBtn = new JButton("Delete Question");
		deleteQBtn.setBounds(200, 220, 300, 47);
		deleteQBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteQBtn.setBackground(new Color(153, 204, 153));
		label.add(deleteQBtn);
		deleteQBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				DeleteActionPerformed(evt);
			}

			private void DeleteActionPerformed(ActionEvent evt) {

				String questionString = qComboBox.getSelectedItem().toString();

				if (importFromJson.reomveQuestiontojson(questionString)) {

					JOptionPane.showMessageDialog(rootPane, "Your Question Has Been Deleted Successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					qComboBox.removeAllItems();
					for (Question w : sysdata.getInstance().questions) {
						qComboBox.addItem(w.getQuestion());
					}
					return;
				}

				JOptionPane.showMessageDialog(rootPane, "Question not found", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		// cancel button
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(200, 290, 300, 47);
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

	}
}
