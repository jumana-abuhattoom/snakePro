package view;

import javax.swing.*;

import java.awt.*;

public class QuestionManager extends JFrame {

	public QuestionManager() {
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

		// add q
		JButton AddQuestion_btn = new JButton("Add Question");
		AddQuestion_btn.setBounds(139, 50, 380, 47);
		AddQuestion_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AddQuestion_btn.setBackground(new Color(153, 204, 153));
		label.add(AddQuestion_btn);
		AddQuestion_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AddQuestionActionPerformed(evt);
			}
		});

		// delete q
		JButton deleteQ_btn = new JButton("Delete Question");
		deleteQ_btn.setBounds(139, 120, 380, 47);
		deleteQ_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		deleteQ_btn.setBackground(new Color(153, 204, 153));
		deleteQ_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteQActionPerformed(evt);
			}
		});
		label.add(deleteQ_btn);

		// update
		JButton updateQ_btn = new JButton("Update Question");
		updateQ_btn.setBounds(139, 190, 380, 47);
		updateQ_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		updateQ_btn.setBackground(new Color(153, 204, 153));
		updateQ_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateQActionPerformed(evt);
			}
		});
		label.add(updateQ_btn);

		// back
		JButton back_btn = new JButton("Back");
		back_btn.setBounds(139, 260, 380, 47);
		back_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		back_btn.setBackground(new Color(153, 204, 153));
		back_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backActionPerformed(evt);
			}
		});
		label.add(back_btn);
	}

	private void AddQuestionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		this.setVisible(false);
		AddingQuestion ad = new AddingQuestion();
		ad.setVisible(true);
	}

	private void deleteQActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		this.setVisible(false);
		DeletingQuestion mp = new DeletingQuestion();
		mp.setVisible(true);
	}

	private void updateQActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		this.setVisible(false);
		UpdateQView up = new UpdateQView();
		up.setVisible(true);
	}
	 private void backActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
			this.setVisible(false);
			MainPage mp  = new MainPage(true);
			mp.setVisible(true);
		}
}
