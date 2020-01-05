package view;

import javax.swing.*;

import controller.sysdata;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MainPage2 extends JFrame {

	public MainPage2(boolean isAdmin) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				
				int result = JOptionPane.showConfirmDialog(
						getContentPane(),
					    "you sure you want to exit ?",
					    " ",
					    JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_NO_OPTION){
					 try{
					      
					      OutputStream fileToSave = new FileOutputStream("Game.ser");
					      OutputStream bufferout = new BufferedOutputStream(fileToSave);
					      ObjectOutput output = new ObjectOutputStream(bufferout);
					      sysdata ish = sysdata.getInstance();
					      try{
					        output.writeObject(ish);
					    	JOptionPane.showMessageDialog(getContentPane(),
								    "The Changes saved   ",
								    "saved massege",
								    JOptionPane.PLAIN_MESSAGE);
					      }
					      finally{
					        output.close();
					      }
					    }  
					    catch(IOException ex){
					    	JOptionPane.showMessageDialog(getContentPane(),
								    "Error , the changes were not saved ",
								    "saved massege",
								    JOptionPane.ERROR_MESSAGE);
					      	
				}
					
				}
			}
		});
		setBounds(new Rectangle(0, 0, 700, 730));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainPage2.class.getResource("/icon/background.jpg")));
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
			//	getContentPane().add(manageQ_btn);
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
		
		History his = new History(null);
		his.setVisible(true);
	}

	private void manageQActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

		this.setVisible(false);
		QuestionManager qm = new QuestionManager();
		qm.setVisible(true);
	}
}