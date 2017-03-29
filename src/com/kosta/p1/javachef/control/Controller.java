package com.kosta.p1.javachef.control;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.kosta.p1.javachef.view.MainView;

public class Controller implements ActionListener {
	MainView main_v;
	
	JButton bt_default;
	JTextField tf_num;
	JLabel la_default;
	

	public Controller() {
		main_v = new MainView();
		System.out.println("¾È³ç");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}// actionPerformed

	public static void main(String[] args) {
		new Controller();
	}// main
}
