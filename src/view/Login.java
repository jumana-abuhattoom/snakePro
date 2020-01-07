package view;

import javax.swing.*;
import controller.sysdata;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;

	public Login() {
		setBounds(new Rectangle(0, 0, 700, 730));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		Toolkit toolK = getToolkit();
		Dimension size = toolK.getScreenSize();
		setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainPage.class.getResource("/icon/background.jpg")));
		label.setBounds(0, 0, 700, 730);
		label.setLayout(null);
		getContentPane().add(label);

		

		//label
		JLabel qLabel = new JLabel("Welcome To Snake Game");
		qLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		qLabel.setBounds(160, 30, 400, 47);
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
				if ( (sysdata.getInstance().CheckUsernameAndPassword(userNameTxt.getText(), passwordTxt.getText())) 
						|| (userNameTxt.getText().equals("Admin") && passwordTxt.getText().equals("Admin"))) {
					setVisible(false);
					MainPage mp = new MainPage(true);
					mp.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(rootPane, "Wrong password or user name", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		label.add(login_btn);

		/// sign up
		JButton sighup_btn = new JButton("Sign Up");
		sighup_btn.setBounds(139, 310, 380, 47);
		sighup_btn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sighup_btn.setBackground(new Color(153, 204, 153));
		sighup_btn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				signupActionPerformed(evt);
			}
		});
		label.add(sighup_btn);
	}

	private void signupActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		this.setVisible(false);
		SignUp mp = new SignUp();
		mp.setVisible(true);
	}

}
