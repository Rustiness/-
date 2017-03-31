package com.kosta.p1.javachef.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

	JPanel p, p_menu, p_control;
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
		
		Font f1 = new Font("궁서체",Font.PLAIN,35);
		
		la_title = new JLabel("JAVA쉐프 - 자판기");
		la_title.setFont(f1);
		la_title.setForeground(Color.WHITE);
		la_title.setBounds(55, 45, 400, 100);
		la_title.setBackground(Color.blue);


		bt_adminView = new JButton("관리자");
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
		
		//메뉴버튼에 커서가 올라가면 체크 표시가 나옴
		bt_menu1.setRolloverIcon(new ImageIcon("data/menu1_chek.png"));
		bt_menu2.setRolloverIcon(new ImageIcon("data/menu2_chek.png"));
		bt_menu3.setRolloverIcon(new ImageIcon("data/menu3_chek.png"));
		bt_menu4.setRolloverIcon(new ImageIcon("data/menu4_chek.png"));
		bt_menu5.setRolloverIcon(new ImageIcon("data/menu5_chek.png"));
		bt_menu6.setRolloverIcon(new ImageIcon("data/menu6_chek.png"));
		
		//메뉴버튼을 클릭하면 체크 표시가 나옴
		bt_menu1.setPressedIcon(new ImageIcon("data/menu1_chek2.png"));
		bt_menu2.setPressedIcon(new ImageIcon("data/menu2_chek2.png"));
		bt_menu3.setPressedIcon(new ImageIcon("data/menu3_chek2.png"));
		bt_menu4.setPressedIcon(new ImageIcon("data/menu4_chek2.png"));
		bt_menu5.setPressedIcon(new ImageIcon("data/menu5_chek2.png"));
		bt_menu6.setPressedIcon(new ImageIcon("data/menu6_chek2.png"));
		
		bt_menu_arr[0] = bt_menu1;	//메뉴 버튼 배열로 저장
		bt_menu_arr[1] = bt_menu2;
		bt_menu_arr[2] = bt_menu3;
		bt_menu_arr[3] = bt_menu4;
		bt_menu_arr[4] = bt_menu5;
		bt_menu_arr[5] = bt_menu6;

		la_menu1 = new JLabel("상품 준비중");
		la_menu1.setBounds(20, 150, 140, 40);
		la_menu2 = new JLabel("상품 준비중");
		la_menu2.setBounds(170, 150, 140, 40);
		la_menu3 = new JLabel("상품 준비중");
		la_menu3.setBounds(20, 300, 140, 40);
		la_menu4 = new JLabel("상품 준비중");
		la_menu4.setBounds(160, 300, 160, 40);
		la_menu5 = new JLabel("상품 준비중");
		la_menu5.setBounds(20, 450, 140, 40);
		la_menu6 = new JLabel("상품 준비중");
		la_menu6.setBounds(170, 450, 140, 40);
		
		
		la_menu_arr[0] = la_menu1;	//메뉴 라벨 배열로 저장
		la_menu_arr[1] = la_menu2;
		la_menu_arr[2] = la_menu3;
		la_menu_arr[3] = la_menu4;
		la_menu_arr[4] = la_menu5;
		la_menu_arr[5] = la_menu6;

		//메뉴 패널 안에 이미지 넣기
		ImageIcon p_menu_image = new ImageIcon("data/p_menu_image.png");//이미지 아이콘 객체 생성
				
		p_menu = new JPanel(){
			public void paintComponent(Graphics g) {
		        Dimension d = getSize();
		        g.drawImage(p_menu_image.getImage(), 0, 0, d.width, d.height, null);
		    }
		};//패널의 크기에 맞게 이미지 삽입
		
		p_menu.setBounds(370, 50, 330, 520);
		p_menu.setLayout(null);
		
		for(int i = 0; i < bt_menu_arr.length; i++){
			p_menu.add(bt_menu_arr[i]);
		}
		for(int i = 0; i < la_menu_arr.length; i++){
			p_menu.add(la_menu_arr[i]);
		}
		
		la_ticket = new JLabel("                       식권 배출구");
		la_ticket.setBounds(710, 510, 210, 50);
		la_ticket.setOpaque(true);
		la_ticket.setBackground(Color.GRAY);
		
		//table 생성
		String columnNames[] = {"메 뉴", "수 량", "가 격"};
		dtm = new DefaultTableModel(columnNames, 0);
		tab = new JTable(dtm);
		scroll = new JScrollPane(tab);
		scroll.setBounds(60, 20, 210, 121);
		
		bt_final = new JButton("선택 초기화");
		bt_final.setBounds(150, 160, 110, 30);

		tf_total = new JTextField("총 가격 : 0원");	//총 가격
		tf_total.setBounds(60, 220, 210, 20);
		tf_total.setEditable(false);
		//tf_total.setEnabled(isDisplayable());
		tf_payPrice = new JTextField("입금액 : 없음");	//입금액
		tf_payPrice.setBounds(60, 250, 210, 20);
		tf_payPrice.setEditable(false);
		
		tf_balance = new JTextField();	// 잔금
		tf_balance.setBounds(60, 280, 210, 20);
		tf_balance.setEditable(false);
		
		bt_cash = new JButton("현금");
		bt_cash.setBounds(60, 310, 100, 50);
		bt_cash.setEnabled(isDisplayable());	//최초 비활성화
		bt_card = new JButton("카드");
		bt_card.setBounds(60, 260, 210, 50);
		//bt_card.setBounds(170, 310, 100, 50);
		bt_card.setEnabled(isDisplayable());	//최초 비활성화
		bt_return = new JButton("잔금 반환");
		bt_return.setBounds(60, 370, 100, 50);
		bt_return.setEnabled(isDisplayable());	//최초 비활성화

		la_change = new JLabel("잔금 반환구");
		la_change.setBounds(60, 470, 210, 50);
		la_change.setOpaque(true);
		la_change.setBackground(Color.GRAY);

		p_control = new JPanel();
		p_control.setBounds(650, 100, 320, 530);
		p_control.setLayout(null);
		p_control.setOpaque(false);
		p_control.add(scroll);
		p_control.add(bt_final);	//선택 초기화
		p_control.add(tf_total);	//총 가격
		//p_control.add(tf_payPrice);	//입금액
		//p_control.add(tf_balance);	//잔금
		//p_control.add(bt_cash);		//현금 결제
		p_control.add(bt_card);		//카드 결제
		//p_control.add(bt_return);	//잔금 배출
		//p_control.add(la_change);	//잔금 반환구
		
		//바탕 패널 안에 이미지 넣기
		ImageIcon p_image = new ImageIcon("data/bg_restaurant_main.png");//이미지 아이콘 객체 생성
		
		p = new JPanel(){
            public void paintComponent(Graphics g) {
            	Dimension d = getSize();
                g.drawImage(p_image.getImage(), 0, 0, d.width, d.height, null);
            }
		};//패널의 크기에 맞게 이미지 삽입
		
		p.setLayout(null);
		p.add(bt_adminView);
		p.add(la_title);
		p.add(p_menu);
		p.add(p_control);
		p.add(la_ticket);

		this.add(p);
		this.setTitle("** 자판기 고객용 View **");
		this.setBounds(180, 20, 1000, 680);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	public void cash(){
		int i = JOptionPane.showConfirmDialog(this, "투입구에 현금을 넣어주십시오.");
		if(i==0){
			JOptionPane.showMessageDialog(this, "결제가 완료됐습니다.");
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