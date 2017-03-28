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
		setTitle("어썸한 자판기");
		
		bt_a = new JButton("A세트 500");
		bt_b = new JButton("B세트 1000");
		bt_pay = new JButton("결제");
		bt_cancel = new JButton("취소");
		bt_mgr = new JButton("관리자 모드");
		
		ta = new JTextArea();
			ta.setEditable(false);
		
		p = new JPanel();
			p.setBackground(Color.orange);
			p.setLayout(null);
			p.setSize(500,500);
			p.add(bt_a);
			p.add(bt_b);
			p.add(bt_pay);
			p.add(bt_cancel);
			p.add(bt_mgr);
			p.add(ta);
			
		bt_a.setBounds(30,30,100,80);
		bt_b.setBounds(130,30,100,80);
		bt_pay.setBounds(30,110,100,80);
		bt_cancel.setBounds(130,110,100,80);
		bt_mgr.setBounds(70,200,120,30);
		
		ta.setBounds(30,240,200,200);
		
		add(p);
		setBounds(800,200,280,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}