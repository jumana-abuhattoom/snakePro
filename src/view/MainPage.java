package view;

import javax.swing.*;
import java.awt.*;


public class MainPage extends JFrame {

	
	private static final long serialVersionUID = 1L;

	public MainPage(boolean isAdmin) {
		
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

		JButton startGame_btn = new JButton("Start new game");
		startGame_btn.setBounds(139, 31, 380, 47);
		startGame_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		startGame_btn.setBackground(new Color(153, 204, 153));
		label.add(startGame_btn);
		startGame_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startGameActionPerformed(evt);
			}
		});
		
		JButton showHistory_btn = new JButton("Show game history");
		showHistory_btn.setBounds(139, 104, 380, 47);
		showHistory_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		showHistory_btn.setBackground(new Color(153, 204, 153));
		showHistory_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				showHistoryActionPerformed(evt);
			}
		});
		label.add(showHistory_btn);
		
				JButton manageQ_btn = new JButton("Manage questions");
				manageQ_btn.setBounds(138, 184, 380, 47);
				manageQ_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
				manageQ_btn.setBackground(new Color(153, 204, 153));
				manageQ_btn.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						manageQActionPerformed(evt);
					}
				});
		if (!isAdmin) {
			manageQ_btn.setVisible(false);
		}
		label.add(manageQ_btn);

	}

	private void startGameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		this.setVisible(false);
	}

	private void showHistoryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		this.setVisible(false);
		History his = new History();
		his.setVisible(true);
	}

	private void manageQActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		this.setVisible(false);
		LoginAdmin qm = new LoginAdmin();
     	qm.setVisible(true);
	}
}