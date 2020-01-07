package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAdmin extends JFrame {

	private static final long serialVersionUID = 1L;

	public LoginAdmin() {
		setBounds(new Rectangle(0, 0, 700, 730));
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		Toolkit toolK = getToolkit();
		Dimension size = toolK.getScreenSize();
		setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainPage.class.getResource("/icon/background.jpg")));
		label.setBounds(0, 0, 700, 730);
		label.setLayout(null);
		getContentPane().add(label);

		// label
		JLabel qLabel = new JLabel("Login As Admin To Manage Questions");
		qLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		qLabel.setBounds(70, 30, 600, 47);
		label.add(qLabel);

		// user name
		JLabel userName = new JLabel("User Name");
		userName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userName.setBounds(50, 100, 80, 47);
		label.add(userName);

		JTextField userNameTxt = new JTextField();
		userNameTxt.setBounds(139, 100, 380, 47);
		userNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.add(userNameTxt);

		// password
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password.setBounds(50, 170, 80, 47);
		label.add(password);

		JPasswordField passwordTxt = new JPasswordField();
		passwordTxt.setBounds(139, 170, 380, 47);
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.add(passwordTxt);

		// login
		JButton login_btn = new JButton("Login");
		login_btn.setBounds(139, 240, 380, 47);
		login_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		login_btn.setBackground(new Color(153, 204, 153));
		login_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (userNameTxt.getText().equals("Admin") && passwordTxt.getText().equals("Admin")) {
					QuestionManager qm = new QuestionManager();
					qm.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(rootPane, "wrong password", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		label.add(login_btn);
		// cancel btn
		JButton cancel_btn = new JButton("Cancel");
		cancel_btn.setBounds(139, 310, 380, 47);
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
		MainPage mp = new MainPage(true);
		mp.setVisible(true);
	}

}