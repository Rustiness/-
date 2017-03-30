package com.kosta.p1.javachef.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Vector; //임시 벡터

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
		
		la_title = new JLabel("<<   자바쉐프 자판기 >.<   >>");
		la_title.setBounds(230, 5, 200, 100);
		la_title.setBackground(Color.blue);


		bt_adminView = new JButton("관리자");
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
		
		//메뉴버튼에 커서가 올라가면 체크 표시가 나옴
		bt_menu1.setRolloverIcon(new ImageIcon("data/check.png"));
		bt_menu2.setRolloverIcon(new ImageIcon("data/check.png"));
		bt_menu3.setRolloverIcon(new ImageIcon("data/check.png"));
		bt_menu4.setRolloverIcon(new ImageIcon("data/check.png"));
		bt_menu5.setRolloverIcon(new ImageIcon("data/check.png"));
		bt_menu6.setRolloverIcon(new ImageIcon("data/check.png"));
		
		//메뉴버튼을 클릭하면 체크 표시가 나옴
		bt_menu1.setPressedIcon(new ImageIcon("data/check2.jpg"));
		bt_menu2.setPressedIcon(new ImageIcon("data/check2.jpg"));
		bt_menu3.setPressedIcon(new ImageIcon("data/check2.jpg"));
		bt_menu4.setPressedIcon(new ImageIcon("data/check2.jpg"));
		bt_menu5.setPressedIcon(new ImageIcon("data/check2.jpg"));
		bt_menu6.setPressedIcon(new ImageIcon("data/check2.jpg"));
		
		bt_menu_arr[0] = bt_menu1;	//메뉴 버튼 배열로 저장
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
		
		la_menu1.setOpaque(true);
		la_menu2.setOpaque(true);
		la_menu3.setOpaque(true);
		la_menu4.setOpaque(true);
		la_menu5.setOpaque(true);
		la_menu6.setOpaque(true);
		
		la_menu_arr[0] = la_menu1;	//메뉴 라벨 배열로 저장
		la_menu_arr[1] = la_menu2;
		la_menu_arr[2] = la_menu3;
		la_menu_arr[3] = la_menu4;
		la_menu_arr[4] = la_menu5;
		la_menu_arr[5] = la_menu6;

		//메뉴 패널 안에 이미지 넣기
		ImageIcon p_menu_image = new ImageIcon("data/p_menu_image.jpg");//이미지 아이콘 객체 생성
				
		p_menu = new JPanel(){
			public void paintComponent(Graphics g) {
		        Dimension d = getSize();
		        g.drawImage(p_menu_image.getImage(), 0, 0, d.width, d.height, null);
		    }
		};//패널의 크기에 맞게 이미지 삽입
		
		p_menu.setBounds(20, 100, 320, 450);
		p_menu.setLayout(null);
		
		for(int i = 0; i < bt_menu_arr.length; i++){
			p_menu.add(bt_menu_arr[i]);
		}
		for(int i = 0; i < la_menu_arr.length; i++){
			p_menu.add(la_menu_arr[i]);
		}
		
		//table 생성
		String columnNames[] = {"메뉴", "수량", "가격"};
		dtm = new DefaultTableModel(columnNames, 0);
		tab = new JTable(dtm);
		scroll = new JScrollPane(tab);
		scroll.setBounds(360, 100, 210, 210);
		
		bt_final = new JButton("선택 초기화");
		bt_final.setBounds(450, 270, 110, 30);

		la_ticket = new JLabel("식권 배출구");
		la_ticket.setBounds(20, 570, 320, 50);
		la_ticket.setOpaque(true);
		la_ticket.setBackground(Color.GRAY);

		tf_total = new JTextField("총가격 : ");	//총 가격
		tf_total.setBounds(360, 320, 210, 20);
		tf_total.setEditable(false);
		//tf_total.setEnabled(isDisplayable());
		tf_payPrice = new JTextField("입금액 : 없음");	//입금액
		tf_payPrice.setBounds(360, 340, 210, 20);
		tf_payPrice.setEditable(false);
		tf_balance = new JTextField();	// 잔금
		tf_balance.setBounds(20, 570, 320, 50);
		
		bt_cash = new JButton("현금");
		bt_cash.setBounds(360, 380, 100, 50);
		bt_card = new JButton("카드");
		bt_card.setBounds(470, 380, 100, 50);
		bt_return = new JButton("잔금 반환");
		bt_return.setBounds(360, 440, 100, 50);
		bt_return.setEnabled(isDisplayable());	//최초 비활성화

		la_change = new JLabel("잔금 반환구");
		la_change.setBounds(360, 510, 210, 50);
		la_change.setOpaque(true);
		la_change.setBackground(Color.GRAY);
		
		//바탕 패널 안에 이미지 넣기
		ImageIcon p_image = new ImageIcon("data/restaurant.jpg");//이미지 아이콘 객체 생성
		
		p = new JPanel(){
            public void paintComponent(Graphics g) {
            	Dimension d = getSize();
                g.drawImage(p_image.getImage(), 0, 0, d.width, d.height, null);
            }
		};//패널의 크기에 맞게 이미지 삽입
		
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
		int i = JOptionPane.showConfirmDialog(this, "투입구에 현금을 넣어주십시오.");
		if(i==0){
			JOptionPane.showMessageDialog(this, "결제가 완료됐습니다.");
			clear();
		}
	} //cash
	
	public void card(){
		int i = JOptionPane.showConfirmDialog(this, "투입구에 카드를 넣어주십시오.");
		if(i==0){
			JOptionPane.showMessageDialog(this, "결제가 완료됐습니다.");
			clear();
		}
	} //card
	
//	public static void main(String[] args) {
//		new MainView();
//	}
}