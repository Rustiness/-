package com.kosta.p1.javachef.view;

import javax.swing.JFrame;

public class CardForm extends JFrame {
	
	
	public CardForm() {
		
		this.setBounds(880, 350, 300, 200);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CardForm();
	}// main

} // class
