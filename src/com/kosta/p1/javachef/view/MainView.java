package com.kosta.p1.javachef.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainView extends JFrame {	
	JButton bt_a, bt_b, bt_pay, bt_cancel;
	public JButton bt_mgr;
	JPanel p;
	JTextArea ta;
	
	public MainView() {
		setTitle("ÀÚÆÇ±â");
		
		setBounds(800,200,280,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}