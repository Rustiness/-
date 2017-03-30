package com.kosta.p1.javachef.view;

import java.awt.Color;
import java.util.Vector; //�ӽ� ����

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame {

	JPanel p, p_menu;
	JScrollPane scroll;
	public DefaultTableModel dtm;
	JTable tab;
	int i;
	
	JLabel la_change, la_title, la_ticket;
	public JLabel la_menu1, la_menu2, la_menu3, la_menu4, la_menu5, la_menu6;
	public JLabel la_menu_arr[] = new JLabel[6];
	public JTextField tf_total, tf_payPrice, tf_balance;

	public JButton bt_adminView;
	public JButton bt_menu1, bt_menu2, bt_menu3, bt_menu4, bt_menu5, bt_menu6;
	public JButton bt_menu_arr[] = new JButton[6];
	public JButton bt_final;
	public JButton bt_cash;
	public JButton bt_card;
	JButton bt_return;

	public MainView() {
		
		la_title = new JLabel("<<   �ڹٽ��� ���Ǳ� >.<   >>");
		la_title.setBounds(230, 5, 200, 100);
		la_title.setBackground(Color.blue);


		bt_adminView = new JButton("������");
		bt_adminView.setBounds(490, 20, 80, 30);
		
		bt_menu1 = new JButton(new ImageIcon("data/menu1.jpg"));
		bt_menu1.setBounds(20, 20, 130, 100);
		bt_menu2 = new JButton(new ImageIcon("data/menu2.jpg"));
		bt_menu2.setBounds(170, 20, 130, 100);
		bt_menu3 = new JButton(new ImageIcon("data/menu3.jpg"));
		bt_menu3.setBounds(20, 170, 130, 100);
		bt_menu4 = new JButton(new ImageIcon("data/menu4.jpg"));
		bt_menu4.setBounds(170, 170, 130, 100);
		bt_menu5 = new JButton(new ImageIcon("data/menu5.jpg"));
		bt_menu5.setBounds(20, 320, 130, 100);
		bt_menu6 = new JButton(new ImageIcon("data/menu6.jpg"));
		bt_menu6.setBounds(170, 320, 130, 100);
		bt_menu_arr[0] = bt_menu1;	//�޴� ��ư �迭�� ����
		bt_menu_arr[1] = bt_menu2;
		bt_menu_arr[2] = bt_menu3;
		bt_menu_arr[3] = bt_menu4;
		bt_menu_arr[4] = bt_menu5;
		bt_menu_arr[5] = bt_menu6;

		la_menu1 = new JLabel();
		la_menu1.setBounds(20, 110, 120, 40);
		la_menu2 = new JLabel();
		la_menu2.setBounds(170, 110, 120, 40);
		la_menu3 = new JLabel();
		la_menu3.setBounds(20, 260, 120, 40);
		la_menu4 = new JLabel();
		la_menu4.setBounds(170, 260, 120, 40);
		la_menu5 = new JLabel();
		la_menu5.setBounds(20, 410, 120, 40);
		la_menu6 = new JLabel();
		la_menu6.setBounds(170, 410, 120, 40);
		
		la_menu_arr[0] = la_menu1;	//�޴� �� �迭�� ����
		la_menu_arr[1] = la_menu2;
		la_menu_arr[2] = la_menu3;
		la_menu_arr[3] = la_menu4;
		la_menu_arr[4] = la_menu5;
		la_menu_arr[5] = la_menu6;

		p_menu = new JPanel();
		p_menu.setBounds(20, 100, 320, 450);
		p_menu.setLayout(null);
		p_menu.setBackground(Color.LIGHT_GRAY);
		for(int i = 0; i < bt_menu_arr.length; i++){
			p_menu.add(bt_menu_arr[i]);
		}
		for(int i = 0; i < la_menu_arr.length; i++){
			p_menu.add(la_menu_arr[i]);
		}
		
		//table ����
		String columnNames[] = {"�޴�", "����", "����"};
		dtm = new DefaultTableModel(columnNames, 0);
		tab = new JTable(dtm);
		scroll = new JScrollPane(tab);
		scroll.setBounds(360, 100, 210, 210);
		
		bt_final = new JButton("���� �ʱ�ȭ");
		bt_final.setBounds(450, 270, 110, 30);

		la_ticket = new JLabel("�ı� ���ⱸ");
		la_ticket.setBounds(20, 570, 320, 50);
		la_ticket.setOpaque(true);
		la_ticket.setBackground(Color.GRAY);

		tf_total = new JTextField("�Ѱ��� : ");	//�� ����
		tf_total.setBounds(360, 320, 210, 20);
		tf_total.setEditable(false);
		//tf_total.setEnabled(isDisplayable());
		tf_payPrice = new JTextField("�Աݾ� : ����");	//�Աݾ�
		tf_payPrice.setBounds(360, 340, 210, 20);
		tf_payPrice.setEditable(false);
		tf_balance = new JTextField();	// �ܱ�
		tf_balance.setBounds(20, 570, 320, 50);
		
		bt_cash = new JButton("����");
		bt_cash.setBounds(360, 380, 100, 50);
		bt_card = new JButton("ī��");
		bt_card.setBounds(470, 380, 100, 50);
		bt_return = new JButton("�ܱ� ��ȯ");
		bt_return.setBounds(360, 440, 100, 50);
		bt_return.setEnabled(isDisplayable());	//���� ��Ȱ��ȭ

		la_change = new JLabel("�ܱ� ��ȯ��");
		la_change.setBounds(360, 510, 210, 50);
		la_change.setOpaque(true);
		la_change.setBackground(Color.GRAY);

		p = new JPanel();
		p.setBackground(Color.magenta);
		p.setLayout(null);
		p.add(bt_adminView);
		p.add(p_menu);
		p.add(la_title);
		p.add(tf_total);
		p.add(tf_payPrice);
		p.add(bt_final);
		p.add(bt_cash);
		p.add(bt_card);
		p.add(bt_return);
		p.add(scroll);
		p.add(la_ticket);
		p.add(la_change);

		this.add(p);
		this.setBounds(600, 50, 600, 680);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	
	public void clear(){
		for(int i=0; i<dtm.getRowCount(); i++){
			dtm.removeRow(i);
		}
		
		i=0;
	} //clear
	
	public void cash(){
		int i = JOptionPane.showConfirmDialog(this, "���Ա��� ������ �־��ֽʽÿ�.");
		if(i==0){
			JOptionPane.showMessageDialog(this, "������ �Ϸ�ƽ��ϴ�.");
			clear();
		}
	} //cash
	
	public void card(){
		int i = JOptionPane.showConfirmDialog(this, "���Ա��� ī�带 �־��ֽʽÿ�.");
		if(i==0){
			JOptionPane.showMessageDialog(this, "������ �Ϸ�ƽ��ϴ�.");
			clear();
		}
	} //card
	
//	public static void main(String[] args) {
//		new MainView();
//	}
}