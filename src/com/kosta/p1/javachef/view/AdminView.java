package com.kosta.p1.javachef.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AdminView extends JFrame {

	public JButton bt_mainView, bt_return;
	public JButton bt_add1, bt_add2, bt_add3, bt_add4, bt_add5, bt_add6; 
	JLabel la_top, la_inven1, la_inven2, la_inven3, la_inven4, la_inven5, la_inven6, la_sale1, la_sale2, la_sale3,
			la_sale4, la_sale5, la_sale6, la_saletotal, la_ready, la_total;
	JTextArea ta_item;
	ImageIcon bt1;

	public AdminView() {

		la_top = new JLabel("<<�����ڿ�>>");
		la_top.setBounds(260, 5, 100, 100);
		bt_mainView = new JButton("����");
		bt_mainView.setBounds(500, 20, 80, 30);

		bt1 = new ImageIcon("don.png");// ����ũ��� 1.8cm(���簢��)
		bt_add1 = new JButton(bt1);
		bt_add1.setBounds(40, 100, 100, 100);
		bt_add2 = new JButton("������2");
		bt_add2.setBounds(190, 100, 100, 100);
		bt_add3 = new JButton("������3");
		bt_add3.setBounds(40, 300, 100, 100);
		bt_add4 = new JButton("������4");
		bt_add4.setBounds(190, 300, 100, 100);
		bt_add5 = new JButton("������5");
		bt_add5.setBounds(40, 500, 100, 100);
		bt_add6 = new JButton("������6");
		bt_add6.setBounds(190, 500, 100, 100);

		ta_item = new JTextArea();
		ta_item.setEditable(false);
		ta_item.setBounds(340, 100, 200, 250);

		la_inven1 = new JLabel("���: ");
		la_inven1.setBounds(42, 200, 40, 40);
		la_inven2 = new JLabel("���: ");
		la_inven2.setBounds(192, 200, 40, 40);
		la_inven3 = new JLabel("���: ");
		la_inven3.setBounds(42, 400, 40, 40);
		la_inven4 = new JLabel("���: ");
		la_inven4.setBounds(192, 400, 40, 40);
		la_inven5 = new JLabel("���: ");
		la_inven5.setBounds(42, 600, 40, 40);
		la_inven6 = new JLabel("���: ");
		la_inven6.setBounds(192, 600, 40, 40);

      /*
       la_sale1=new JLabel("������1 �Ǹŷ�: ");      
       la_sale2=new JLabel("������2 �Ǹŷ�: ");      
       la_sale3=new JLabel("������3 �Ǹŷ�: ");      
       la_sale4=new JLabel("������4 �Ǹŷ�: ");      
       la_sale5=new JLabel("������5 �Ǹŷ�: ");      
       la_sale6=new JLabel("������6 �Ǹŷ�: ");      
       la_saletotal=new JLabel("������ �� �Ǹŷ�: ");   
       */   

		la_ready = new JLabel("����: ");
		la_ready.setBounds(330, 625, 100, 50);
		la_total = new JLabel("���� �����: ");
		la_total.setBounds(330, 685, 200, 50);
		bt_return = new JButton("ȸ��");
		bt_return.setBounds(480, 635, 60, 30);

		add(la_top);
		add(bt_mainView);
		add(bt_add1);
		add(bt_add2);
		add(bt_add3);
		add(bt_add4);
		add(bt_add5);
		add(bt_add6);
		add(la_inven1);
		add(la_inven2);
		add(la_inven3);
		add(la_inven4);
		add(la_inven5);
		add(la_inven6);
		add(ta_item);
		add(la_ready);
		add(la_total);
		add(bt_return);

		this.setTitle("���Ǳ�(������)");
		this.setLayout(null);
		this.setBounds(600, 50, 600, 800);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

   }//������
   
//   public static void main(String[] args) {
//      new AdminView();
//   }//main
   
}//class