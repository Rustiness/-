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
		
			la_init.setBounds(30,30,120,30);
			la_profit.setBounds(30,70,120,30);
			la_a_num.setBounds(30,110,120,30);
			la_b_num.setBounds(30,150,120,30);
			
			tf_init.setBounds(150,30,30,30);
			tf_profit.setBounds(150,70,30,30);
			tf_a_num.setBounds(150,110,30,30);
			tf_b_num.setBounds(150,150,30,30);
			
			bt_init.setBounds(200,30,80,30);
			bt_a_num.setBounds(200,110,80,30);
			bt_b_num.setBounds(200,150,80,30);
			
			bt_sale.setBounds(95,210,120,30);
			
		add(p);
		setBounds(800,200,310,300);
		setVisible(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new AnotherView();
	}
}
