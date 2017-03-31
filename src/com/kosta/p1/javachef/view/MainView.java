package com.kosta.p1.javachef.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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

	JPanel p, p_menu, p_control;
	JScrollPane scroll;
	public DefaultTableModel dtm;
	JTable tab;
	int i;
	
	public JLabel la_change, la_title, la_ticket;
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
		
		Font f1 = new Font("�ü�ü",Font.PLAIN,35);
		
		la_title = new JLabel("JAVA���� - ���Ǳ�");
		la_title.setFont(f1);
		la_title.setForeground(Color.WHITE);
		la_title.setBounds(55, 45, 400, 100);
		la_title.setBackground(Color.blue);


		bt_adminView = new JButton("������");
		bt_adminView.setBounds(840, 60, 80, 30);
		
		bt_menu1 = new JButton(new ImageIcon("data/menu1.jpg"));
		bt_menu1.setBounds(20, 60, 130, 100);
		bt_menu2 = new JButton(new ImageIcon("data/menu2.jpg"));
		bt_menu2.setBounds(170, 60, 130, 100);
		bt_menu3 = new JButton(new ImageIcon("data/menu3.jpg"));
		bt_menu3.setBounds(20, 210, 130, 100);
		bt_menu4 = new JButton(new ImageIcon("data/menu4.jpg"));
		bt_menu4.setBounds(170, 210, 130, 100);
		bt_menu5 = new JButton(new ImageIcon("data/menu5.jpg"));
		bt_menu5.setBounds(20, 360, 130, 100);
		bt_menu6 = new JButton(new ImageIcon("data/menu6.jpg"));
		bt_menu6.setBounds(170, 360, 130, 100);
		
		//�޴���ư�� Ŀ���� �ö󰡸� üũ ǥ�ð� ����
		bt_menu1.setRolloverIcon(new ImageIcon("data/menu1_chek.png"));
		bt_menu2.setRolloverIcon(new ImageIcon("data/menu2_chek.png"));
		bt_menu3.setRolloverIcon(new ImageIcon("data/menu3_chek.png"));
		bt_menu4.setRolloverIcon(new ImageIcon("data/menu4_chek.png"));
		bt_menu5.setRolloverIcon(new ImageIcon("data/menu5_chek.png"));
		bt_menu6.setRolloverIcon(new ImageIcon("data/menu6_chek.png"));
		
		//�޴���ư�� Ŭ���ϸ� üũ ǥ�ð� ����
		bt_menu1.setPressedIcon(new ImageIcon("data/menu1_chek2.png"));
		bt_menu2.setPressedIcon(new ImageIcon("data/menu2_chek2.png"));
		bt_menu3.setPressedIcon(new ImageIcon("data/menu3_chek2.png"));
		bt_menu4.setPressedIcon(new ImageIcon("data/menu4_chek2.png"));
		bt_menu5.setPressedIcon(new ImageIcon("data/menu5_chek2.png"));
		bt_menu6.setPressedIcon(new ImageIcon("data/menu6_chek2.png"));
		
		bt_menu_arr[0] = bt_menu1;	//�޴� ��ư �迭�� ����
		bt_menu_arr[1] = bt_menu2;
		bt_menu_arr[2] = bt_menu3;
		bt_menu_arr[3] = bt_menu4;
		bt_menu_arr[4] = bt_menu5;
		bt_menu_arr[5] = bt_menu6;

		la_menu1 = new JLabel("��ǰ �غ���");
		la_menu1.setBounds(20, 150, 140, 40);
		la_menu2 = new JLabel("��ǰ �غ���");
		la_menu2.setBounds(170, 150, 140, 40);
		la_menu3 = new JLabel("��ǰ �غ���");
		la_menu3.setBounds(20, 300, 140, 40);
		la_menu4 = new JLabel("��ǰ �غ���");
		la_menu4.setBounds(160, 300, 160, 40);
		la_menu5 = new JLabel("��ǰ �غ���");
		la_menu5.setBounds(20, 450, 140, 40);
		la_menu6 = new JLabel("��ǰ �غ���");
		la_menu6.setBounds(170, 450, 140, 40);
		
		
		la_menu_arr[0] = la_menu1;	//�޴� �� �迭�� ����
		la_menu_arr[1] = la_menu2;
		la_menu_arr[2] = la_menu3;
		la_menu_arr[3] = la_menu4;
		la_menu_arr[4] = la_menu5;
		la_menu_arr[5] = la_menu6;

		//�޴� �г� �ȿ� �̹��� �ֱ�
		ImageIcon p_menu_image = new ImageIcon("data/p_menu_image.png");//�̹��� ������ ��ü ����
				
		p_menu = new JPanel(){
			public void paintComponent(Graphics g) {
		        Dimension d = getSize();
		        g.drawImage(p_menu_image.getImage(), 0, 0, d.width, d.height, null);
		    }
		};//�г��� ũ�⿡ �°� �̹��� ����
		
		p_menu.setBounds(370, 50, 330, 520);
		p_menu.setLayout(null);
		
		for(int i = 0; i < bt_menu_arr.length; i++){
			p_menu.add(bt_menu_arr[i]);
		}
		for(int i = 0; i < la_menu_arr.length; i++){
			p_menu.add(la_menu_arr[i]);
		}
		
		la_ticket = new JLabel("                       �ı� ���ⱸ");
		la_ticket.setBounds(710, 510, 210, 50);
		la_ticket.setOpaque(true);
		la_ticket.setBackground(Color.GRAY);
		
		//table ����
		String columnNames[] = {"�� ��", "�� ��", "�� ��"};
		dtm = new DefaultTableModel(columnNames, 0);
		tab = new JTable(dtm);
		scroll = new JScrollPane(tab);
		scroll.setBounds(60, 20, 210, 121);
		
		bt_final = new JButton("���� �ʱ�ȭ");
		bt_final.setBounds(150, 160, 110, 30);
		bt_final.setEnabled(isDisplayable());	//���� ��Ȱ��ȭ

		tf_total = new JTextField("�� ���� : 0��");	//�� ����
		tf_total.setBounds(60, 220, 210, 20);
		tf_total.setEditable(false);
		//tf_total.setEnabled(isDisplayable());
		tf_payPrice = new JTextField("�Աݾ� : ����");	//�Աݾ�
		tf_payPrice.setBounds(60, 250, 210, 20);
		tf_payPrice.setEditable(false);
		
		tf_balance = new JTextField();	// �ܱ�
		tf_balance.setBounds(60, 280, 210, 20);
		tf_balance.setEditable(false);
		
		bt_cash = new JButton("����");
		bt_cash.setBounds(60, 310, 100, 50);
		bt_cash.setEnabled(isDisplayable());	//���� ��Ȱ��ȭ
		bt_card = new JButton("ī��");
		bt_card.setBounds(60, 260, 210, 50);
		//bt_card.setBounds(170, 310, 100, 50);
		bt_card.setEnabled(isDisplayable());	//���� ��Ȱ��ȭ
		bt_return = new JButton("�ܱ� ��ȯ");
		bt_return.setBounds(60, 370, 100, 50);
		bt_return.setEnabled(isDisplayable());	//���� ��Ȱ��ȭ

		la_change = new JLabel("�ܱ� ��ȯ��");
		la_change.setBounds(60, 470, 210, 50);
		la_change.setOpaque(true);
		la_change.setBackground(Color.GRAY);

		p_control = new JPanel();
		p_control.setBounds(650, 100, 320, 530);
		p_control.setLayout(null);
		p_control.setOpaque(false);
		p_control.add(scroll);
		p_control.add(bt_final);	//���� �ʱ�ȭ
		p_control.add(tf_total);	//�� ����
		//p_control.add(tf_payPrice);	//�Աݾ�
		//p_control.add(tf_balance);	//�ܱ�
		//p_control.add(bt_cash);		//���� ����
		p_control.add(bt_card);		//ī�� ����
		//p_control.add(bt_return);	//�ܱ� ����
		//p_control.add(la_change);	//�ܱ� ��ȯ��
		
		//���� �г� �ȿ� �̹��� �ֱ�
		ImageIcon p_image = new ImageIcon("data/bg_restaurant_main.png");//�̹��� ������ ��ü ����
		
		p = new JPanel(){
            public void paintComponent(Graphics g) {
            	Dimension d = getSize();
                g.drawImage(p_image.getImage(), 0, 0, d.width, d.height, null);
            }
		};//�г��� ũ�⿡ �°� �̹��� ����
		
		p.setLayout(null);
		p.add(bt_adminView);
		p.add(la_title);
		p.add(p_menu);
		p.add(p_control);
		p.add(la_ticket);

		this.add(p);
		this.setTitle("** ���Ǳ� ���� View **");
		this.setBounds(180, 20, 1000, 680);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	public void cash(){
		int i = JOptionPane.showConfirmDialog(this, "���Ա��� ������ �־��ֽʽÿ�.");
		if(i==0){
			JOptionPane.showMessageDialog(this, "������ �Ϸ�ƽ��ϴ�.");
		}
	} //cash
	
	public void showMsg(String message){
		JOptionPane.showMessageDialog(this, message);
		
	}

	public int showConfMsg(String message){
		int i = JOptionPane.showConfirmDialog(this, message);
		return i;
	}
	
//	public static void main(String[] args) {
//		new MainView();
//	}
}