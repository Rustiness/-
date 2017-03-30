package com.kosta.p1.javachef.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class AdminView extends JFrame {

	public JButton bt_mainView, bt_return;
	public JTextArea ta_add1, ta_add2, ta_add3, ta_add4, ta_add5, ta_add6;//��ǰ��,��ǰ����,������� 
	public JTextArea ta_add_arr[] = new JTextArea[6];
	
	public JTextArea  ta_inven1, ta_inven2, ta_inven3, ta_inven4, ta_inven5, ta_inven6;//������
	public JTextArea ta_inven_arr[] = new JTextArea[6];
	
	public JTextField tf_total;
	public JLabel la_top,la_sale1, la_sale2, la_sale3, la_sale4, la_sale5, la_sale6, la_saletotal, la_ready;
	public JTextArea ta_item;
	public JScrollBar scroll_inven1, scroll_inven2, scroll_inven3, scroll_inven4, scroll_inven5, scroll_inven6;
	public JButton bt_add1, bt_minus1,bt_add2, bt_minus2, bt_add3, bt_minus3, bt_add4, bt_minus4, bt_add5, bt_minus5, bt_add6, bt_minus6;
	ImageIcon bt1;
    public Font f1;
	
	public AdminView() {

		f1 = new Font("����",Font.PLAIN,20);
		la_top = new JLabel("<< �����ڿ� >> ^^");
		la_top.setFont(f1);
		la_top.setBounds(200, 30, 300, 50);
		bt_mainView = new JButton("����");
		bt_mainView.setBounds(500, 20, 80, 30);

		bt1 = new ImageIcon("don.png");// ����ũ��� 1.8cm(���簢��)
		ta_add1 = new JTextArea();
		ta_add1.setBounds(40, 100, 100, 100);
		ta_add1.setBackground(Color.ORANGE );
		ta_add2 = new JTextArea();
		ta_add2.setBounds(190, 100, 100, 100);
		ta_add2.setBackground(Color.ORANGE );
		ta_add3 = new JTextArea();
		ta_add3.setBounds(40, 300, 100, 100);
		ta_add3.setBackground(Color.ORANGE );
		ta_add4 = new JTextArea();
		ta_add4.setBounds(190, 300, 100, 100);
		ta_add4.setBackground(Color.ORANGE );
		ta_add5 = new JTextArea();
		ta_add5.setBounds(40, 500, 100, 100);
		ta_add5.setBackground(Color.ORANGE );
		ta_add6 = new JTextArea();
		ta_add6.setBounds(190, 500, 100, 100);
		ta_add6.setBackground(Color.ORANGE );
        
		//Addition
		ta_add_arr[0] = ta_add1;
		ta_add_arr[1] = ta_add2;
		ta_add_arr[2] = ta_add3;
		ta_add_arr[3] = ta_add4;
		ta_add_arr[4] = ta_add5;
		ta_add_arr[5] = ta_add6;
				
		
		bt_add1 = new JButton("�߰�");
		bt_add1.setBounds(30, 260, 60, 30);
		bt_minus1 = new JButton("ȸ��");
		bt_minus1.setBounds(90, 260, 60, 30);
		bt_add2 = new JButton("�߰�");
		bt_add2.setBounds(182, 260, 60, 30);
		bt_minus2 = new JButton("ȸ��");
		bt_minus2.setBounds(242, 260, 60, 30);
		bt_add3 = new JButton("�߰�");
		bt_add3.setBounds(30, 460, 60, 30);
		bt_minus3 = new JButton("ȸ��");
		bt_minus3.setBounds(90, 460, 60, 30);
		bt_add4 = new JButton("�߰�");
		bt_add4.setBounds(182, 460, 60, 30);
		bt_minus4 = new JButton("ȸ��");
		bt_minus4.setBounds(242, 460, 60, 30);
		bt_add5 = new JButton("�߰�");
		bt_add5.setBounds(30, 660, 60, 30);
		bt_minus5 = new JButton("ȸ��");
		bt_minus5.setBounds(90, 660, 60, 30);
		bt_add6 = new JButton("�߰�");
		bt_add6.setBounds(182, 660, 60, 30);
		bt_minus6 = new JButton("ȸ��");
		bt_minus6.setBounds(242, 660, 60, 30);
		
				
		ta_item = new JTextArea();
		ta_item.setEditable(false);
		ta_item.setBounds(340, 100, 200, 430);

		ta_inven1 = new JTextArea();
		ta_inven1.setBounds(42, 200, 40, 20);
		ta_inven2 = new JTextArea();
		ta_inven2.setBounds(192, 200, 40, 20);
		ta_inven3 = new JTextArea();
		ta_inven3.setBounds(42, 400, 40, 20);
		ta_inven4 = new JTextArea();
		ta_inven4.setBounds(192, 400, 40, 20);
		ta_inven5 = new JTextArea();
		ta_inven5.setBounds(42, 600, 40, 20);
		ta_inven6 = new JTextArea();
		ta_inven6.setBounds(192, 600, 40, 20);
		
			

		scroll_inven1 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 2, 0, 52);
		scroll_inven2 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 2, 0, 52);
		scroll_inven3 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 2, 0, 52);
		scroll_inven4 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 2, 0, 52);
		scroll_inven5 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 2, 0, 52);
		scroll_inven6 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 2, 0, 52);
		scroll_inven1.setBounds(40,230,100,20);
		scroll_inven2.setBounds(190,230,100,20);
		scroll_inven3.setBounds(40,430,100,20);
		scroll_inven4.setBounds(190,430,100,20);
		scroll_inven5.setBounds(40,630,100,20);
		scroll_inven6.setBounds(190,630,100,20);
		
      /*
       la_sale1=new JLabel("������1 �Ǹŷ�: ");      
       la_sale2=new JLabel("������2 �Ǹŷ�: ");      
       la_sale3=new JLabel("������3 �Ǹŷ�: ");      
       la_sale4=new JLabel("������4 �Ǹŷ�: ");      
       la_sale5=new JLabel("������5 �Ǹŷ�: ");      
       la_sale6=new JLabel("������6 �Ǹŷ�: ");      
       la_saletotal=new JLabel("������ �� �Ǹŷ�: ");   
       */   

//		la_ready = new JLabel("����: ");
//		la_ready.setBounds(330, 625, 100, 50);
		tf_total = new JTextField();
		tf_total.setBounds(330, 685, 200, 50);
		bt_return = new JButton("ȸ��");
		bt_return.setBounds(480, 635, 60, 30);

		add(la_top);
		add(bt_mainView);
		add(ta_add1);
		add(ta_add2);
		add(ta_add3);
		add(ta_add4);
		add(ta_add5);
		add(ta_add6);
		add(ta_inven1);
		add(ta_inven2);
		add(ta_inven3);
		add(ta_inven4);
		add(ta_inven5);
		add(ta_inven6);
		add(ta_item);
//		add(la_ready);
		add(tf_total);
		add(bt_return);
		add(scroll_inven1);
		add(scroll_inven2);
		add(scroll_inven3);
		add(scroll_inven4);
		add(scroll_inven5);
		add(scroll_inven6);
		add(bt_add1);
		add(bt_add2);
		add(bt_add3);
		add(bt_add4);
		add(bt_add5);
		add(bt_add6);
		add(bt_minus1);
		add(bt_minus2);
		add(bt_minus3);
		add(bt_minus4);
		add(bt_minus5);
		add(bt_minus6);
		

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