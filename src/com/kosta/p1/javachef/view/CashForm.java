package com.kosta.p1.javachef.view;

import javax.swing.JFrame;

public class CashForm extends JFrame {
	
	
	public CashForm() {
		
		this.setBounds(880, 350, 300, 300);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CashForm();
	}// main

} // class