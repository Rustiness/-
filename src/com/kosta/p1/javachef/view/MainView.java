package com.kosta.p1.javachef.view;

import java.awt.Color;
import java.util.Vector; //�ӽ� ����

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame {

	JPanel p;
	JScrollPane scroll;
	DefaultTableModel dtm;
	JTable tab;
	int i;
	
	JLabel la_change, la_title, la_ticket;
	public JLabel la_menu1, la_menu2, la_menu3, la_menu4, la_menu5, la_menu6;
	public JLabel la_menu_arr[] = new JLabel[6];

	public JButton bt_adminView;
	public JButton bt_menu1, bt_menu2, bt_menu3, bt_menu4, bt_menu5, bt_menu6;
	public JButton bt_final;
	public JButton bt_cash;
	public JButton bt_card;
	JButton bt_return;

	public MainView() {
		p = new JPanel();
		p.setBackground(Color.magenta);
		
		//table ����
		String columnNames[] = {"�޴�", "����", "����"};
		dtm = new DefaultTableModel(columnNames, 0);
		tab = new JTable(dtm);
		scroll = new JScrollPane(tab);
		scroll.setBounds(340, 100, 200, 300);
		
		la_change = new JLabel("�Ž�����");
		la_change.setOpaque(true);
		la_change.setBackground(Color.GRAY);
		la_title = new JLabel("<<   �ڹٽ��� ���Ǳ� >.<   >>");
		la_title.setBounds(230, 5, 200, 100);
		la_title.setBackground(Color.blue);

		la_ticket = new JLabel("�ı� ���ⱸ");
		la_ticket.setBounds(50, 690, 500, 50);
		la_ticket.setOpaque(true);
		la_ticket.setBackground(Color.GRAY);

		bt_adminView = new JButton("������");
		bt_adminView.setBounds(500, 20, 80, 30);
		bt_menu1 = new JButton("��ư1");
		bt_menu1.setBounds(40, 100, 100, 100);
		bt_menu2 = new JButton("��ư2");
		bt_menu2.setBounds(190, 100, 100, 100);
		bt_menu3 = new JButton("��ư3");
		bt_menu3.setBounds(40, 300, 100, 100);
		bt_menu4 = new JButton("��ư4");
		bt_menu4.setBounds(190, 300, 100, 100);
		bt_menu5 = new JButton("��ư5");
		bt_menu5.setBounds(40, 500, 100, 100);
		bt_menu6 = new JButton("��ư6");
		bt_menu6.setBounds(190, 500, 100, 100);

		bt_final = new JButton("���");
		bt_final.setBounds(480, 460, 70, 30);

		bt_cash = new JButton("����");
		bt_cash.setBounds(350, 500, 95, 45);
		bt_card = new JButton("ī��");
		bt_card.setBounds(455, 500, 95, 45);
		bt_return = new JButton("��ȯ");
		bt_return.setBounds(350, 555, 95, 45);

		la_menu1 = new JLabel("�޴�  5,000 ");
		la_menu1.setBounds(42, 200, 70, 40);
		la_menu2 = new JLabel("�޴�  4,000 ");
		la_menu2.setBounds(192, 200, 70, 40);
		la_menu3 = new JLabel("�޴�  6,000 ");
		la_menu3.setBounds(42, 400, 70, 40);
		la_menu4 = new JLabel("�޴�  7,000 ");
		la_menu4.setBounds(192, 400, 70, 40);
		la_menu5 = new JLabel("�޴�  5,500 ");
		la_menu5.setBounds(42, 600, 70, 40);
		la_menu6 = new JLabel("�޴�  6,500 ");
		la_menu6.setBounds(192, 600, 70, 40);
		
		la_menu_arr[0] = la_menu1;	//�޴� �迭�� ����
		la_menu_arr[1] = la_menu2;
		la_menu_arr[2] = la_menu3;
		la_menu_arr[3] = la_menu4;
		la_menu_arr[4] = la_menu5;
		la_menu_arr[5] = la_menu6;
		
		p.setLayout(null);
		p.add(bt_adminView);
		p.add(bt_menu1);
		p.add(bt_menu2);
		p.add(bt_menu3);
		p.add(bt_menu4);
		p.add(bt_menu5);
		p.add(bt_menu6);

		p.add(la_title);
		p.add(bt_final);
		p.add(bt_cash);
		p.add(bt_card);
		p.add(bt_return);
		p.add(scroll);
		p.add(la_menu1);
		p.add(la_menu2);
		p.add(la_menu3);
		p.add(la_menu4);
		p.add(la_menu5);
		p.add(la_menu6);
		p.add(la_ticket);

		this.add(p);
		this.setBounds(600, 50, 600, 800);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void display(){
		i++;
		Vector v = new Vector();
		v.add("������");
		v.add(i);
		v.add(6000*i);
		
		if(dtm.getRowCount()==0){
		dtm.addRow(v);
		return;
		}
				
		for(int i=0; i<dtm.getRowCount(); i++){
			if(dtm.getValueAt(i, 0).equals(v.get(0))) {
				dtm.removeRow(i);
				dtm.insertRow(i, v);
				break;
			}else{
				dtm.addRow(v);
			}
		}
	} //display
	
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