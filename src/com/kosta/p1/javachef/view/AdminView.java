package com.kosta.p1.javachef.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextArea;

public class AdminView extends JFrame {

	public JButton bt_mainView, bt_return;
	public JButton bt_add1, bt_add2, bt_add3, bt_add4, bt_add5, bt_add6; 
	public JTextArea  ta_inven1, ta_inven2, ta_inven3, ta_inven4, ta_inven5, ta_inven6;
		   JLabel la_top,la_sale1, la_sale2, la_sale3, la_sale4, la_sale5, la_sale6, la_saletotal, la_ready, la_total;
	public JTextArea ta_item;
//	public JScrollBar scroll_inven1, scroll_inven2, scroll_inven3, scroll_inven4, scroll_inven5, scroll_inven6;
	ImageIcon bt1;

	public AdminView() {

		la_top = new JLabel("<<관리자용>>");
		la_top.setBounds(260, 5, 100, 100);
		bt_mainView = new JButton("메인");
		bt_mainView.setBounds(500, 20, 80, 30);

		bt1 = new ImageIcon("don.png");// 사진크기는 1.8cm(정사각형)
		bt_add1 = new JButton(bt1);
		bt_add1.setBounds(40, 100, 100, 100);
		bt_add2 = new JButton("아이템2");
		bt_add2.setBounds(190, 100, 100, 100);
		bt_add3 = new JButton("아이템3");
		bt_add3.setBounds(40, 300, 100, 100);
		bt_add4 = new JButton("아이템4");
		bt_add4.setBounds(190, 300, 100, 100);
		bt_add5 = new JButton("아이템5");
		bt_add5.setBounds(40, 500, 100, 100);
		bt_add6 = new JButton("아이템6");
		bt_add6.setBounds(190, 500, 100, 100);

		ta_item = new JTextArea();
		ta_item.setEditable(false);
		ta_item.setBounds(340, 100, 200, 250);

		ta_inven1 = new JTextArea();
		ta_inven1.setBounds(42, 200, 40, 40);
		ta_inven2 = new JTextArea();
		ta_inven2.setBounds(192, 200, 40, 40);
		ta_inven3 = new JTextArea();
		ta_inven3.setBounds(42, 400, 40, 40);
		ta_inven4 = new JTextArea();
		ta_inven4.setBounds(192, 400, 40, 40);
		ta_inven5 = new JTextArea();
		ta_inven5.setBounds(42, 600, 40, 40);
		ta_inven6 = new JTextArea();
		ta_inven6.setBounds(192, 600, 40, 40);

      /*
       la_sale1=new JLabel("아이템1 판매량: ");      
       la_sale2=new JLabel("아이템2 판매량: ");      
       la_sale3=new JLabel("아이템3 판매량: ");      
       la_sale4=new JLabel("아이템4 판매량: ");      
       la_sale5=new JLabel("아이템5 판매량: ");      
       la_sale6=new JLabel("아이템6 판매량: ");      
       la_saletotal=new JLabel("아이템 총 판매량: ");   
       */   

		la_ready = new JLabel("시재: ");
		la_ready.setBounds(330, 625, 100, 50);
		la_total = new JLabel("금일 매출액: ");
		la_total.setBounds(330, 685, 200, 50);
		bt_return = new JButton("회수");
		bt_return.setBounds(480, 635, 60, 30);

		add(la_top);
		add(bt_mainView);
		add(bt_add1);
		add(bt_add2);
		add(bt_add3);
		add(bt_add4);
		add(bt_add5);
		add(bt_add6);
		add(ta_inven1);
		add(ta_inven2);
		add(ta_inven3);
		add(ta_inven4);
		add(ta_inven5);
		add(ta_inven6);
		add(ta_item);
		add(la_ready);
		add(la_total);
		add(bt_return);

		this.setTitle("자판기(관리자)");
		this.setLayout(null);
		this.setBounds(600, 50, 600, 800);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

   }//생성자
   
//   public static void main(String[] args) {
//      new AdminView();
//   }//main
   
}//class