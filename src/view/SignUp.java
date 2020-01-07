package view;

import javax.swing.*;

import controller.sysdata;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {

	public SignUp() {
		setBounds(new Rectangle(0, 0, 700, 730));
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		Toolkit toolK = getToolkit();
		Dimension size = toolK.getScreenSize();
		setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainPage.class.getResource("/icon/background.jpg")));
		label.setBounds(0, 0, 700, 730);
		label.setLayout(null);
		getContentPane().add(label);

		// user name
		JLabel userName = new JLabel("Select User Name");
		userName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userName.setBounds(139, 20, 380, 47);
		label.add(userName);

		JTextField userNameTxt = new JTextField();
		userNameTxt.setBounds(139, 50, 380, 47);
		userNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.add(userNameTxt);

		// password
		JLabel password = new JLabel("Select Password");
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password.setBounds(139, 100, 380, 47);
		label.add(password);

		JPasswordField passwordTxt = new JPasswordField();
		passwordTxt.setBounds(139, 130, 380, 47);
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.add(passwordTxt);

		// login
		JButton signUp_btn = new JButton("Sign Up");
		signUp_btn.setBounds(139, 200, 380, 47);
		signUp_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		signUp_btn.setBackground(new Color(153, 204, 153));
		signUp_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (sysdata.getInstance().AddPlayer(userNameTxt.getText(), passwordTxt.getText())) {
					JOptionPane.showMessageDialog(rootPane, "You Have Been Added Successfully", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					Login mp = new Login();
					mp.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(rootPane, "User Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		label.add(signUp_btn);

		// cancel
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.setBounds(139, 260, 380, 47);
		cancel_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cancel_btn.setBackground(new Color(153, 204, 153));
		cancel_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelActionPerformed(evt);
			}
		});
		label.add(cancel_btn);
	}

	private void cancelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		this.setVisible(false);
		Login mp = new Login();
		mp.setVisible(true);
	}

}
