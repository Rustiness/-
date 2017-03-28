package com.kosta.p1.javachef.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AnotherView extends JFrame{
	JLabel la_init, la_profit, la_a_num, la_b_num;
	JTextField tf_init, tf_profit, tf_a_num, tf_b_num;
	JButton bt_init, bt_a_num, bt_b_num;
	public JButton bt_sale;
	
	JPanel p;
	
	public AnotherView() {
		setTitle("관리자 모드");
		System.out.println("안녕");
		setBounds(800,200,310,300);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new AnotherView();
	}
}
