package com.kosta.p1.javachef.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Scrollbar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class AdminView extends JFrame {

	JPanel p, p_handle, p_handle2;
	public JButton bt_mainView, bt_return;
	public JTextArea ta_add1, ta_add2, ta_add3, ta_add4, ta_add5, ta_add6;//제품명,제품가격,현재수량 
	public JTextArea ta_add_arr[] = new JTextArea[6];
	
	public JTextField  tf_inven1, tf_inven2, tf_inven3, tf_inven4, tf_inven5, tf_inven6;//재고수량
	public JTextField tf_inven_arr[] = new JTextField[6];
	
	public JTextField tf_total;
	public JLabel la_top,la_sale1, la_sale2, la_sale3, la_sale4, la_sale5, la_sale6, la_saletotal, la_ready;
	public JTextArea ta_item;
	public JScrollBar scroll_inven1, scroll_inven2, scroll_inven3, scroll_inven4, scroll_inven5, scroll_inven6;
	public JScrollBar scroll_inven_arr[] = new JScrollBar[6];
	public JButton bt_add1, bt_minus1,bt_add2, bt_minus2, bt_add3, bt_minus3, bt_add4, bt_minus4, bt_add5, bt_minus5, bt_add6, bt_minus6;
	public JButton bt_add_arr[] = new JButton[6];
	public JButton bt_minus_arr[] = new JButton[6];
	ImageIcon bt1;
	
	public AdminView() {

		Font f1 = new Font("궁서체",Font.PLAIN,40);
		la_top = new JLabel("JAVA쉐프 - 관리자");
		la_top.setFont(f1);
		la_top.setBounds(50, 30, 200, 100);
		bt_mainView = new JButton("메인");
		bt_mainView.setBounds(840, 60, 80, 30);

		bt1 = new ImageIcon("don.png");// 사진크기는 1.8cm(정사각형)
		ta_add1 = new JTextArea();
		ta_add1.setBounds(30, 50, 100, 75);/////
		ta_add1.setBackground(Color.ORANGE );
		ta_add1.setEditable(false);
		ta_add2 = new JTextArea();
		ta_add2.setBounds(190, 50, 100, 75);/////
		ta_add2.setBackground(Color.ORANGE );
		ta_add2.setEditable(false);
		ta_add3 = new JTextArea();
		ta_add3.setBounds(30, 200, 100, 75);/////
		ta_add3.setBackground(Color.ORANGE );
		ta_add3.setEditable(false);
		ta_add4 = new JTextArea();
		ta_add4.setBounds(190, 200, 100, 75);////
		ta_add4.setBackground(Color.ORANGE );
		ta_add4.setEditable(false);
		ta_add5 = new JTextArea();
		ta_add5.setBounds(30, 350, 100, 75);////
		ta_add5.setBackground(Color.ORANGE );
		ta_add5.setEditable(false);
		ta_add6 = new JTextArea();
		ta_add6.setBounds(190, 350, 100, 75);////
		ta_add6.setBackground(Color.ORANGE );
		ta_add6.setEditable(false);
        
		//Addition
		ta_add_arr[0] = ta_add1; //제품정보 배열로 저장
		ta_add_arr[1] = ta_add2;
		ta_add_arr[2] = ta_add3;
		ta_add_arr[3] = ta_add4;
		ta_add_arr[4] = ta_add5;
		ta_add_arr[5] = ta_add6;
				
		tf_inven1 = new JTextField("0");
		tf_inven1.setBounds(30, 130, 30, 20);/////
		tf_inven1.setEditable(false);
		tf_inven2 = new JTextField("0");
		tf_inven2.setBounds(190, 130, 30, 20);/////
		tf_inven2.setEditable(false);
		tf_inven3 = new JTextField("0");
		tf_inven3.setBounds(30, 280, 30, 20);/////
		tf_inven3.setEditable(false);
		tf_inven4 = new JTextField("0");
		tf_inven4.setBounds(190, 280, 30, 20);////
		tf_inven4.setEditable(false);
		tf_inven5 = new JTextField("0");
		tf_inven5.setBounds(30, 430, 30, 20);////
		tf_inven5.setEditable(false);
		tf_inven6 = new JTextField("0");
		tf_inven6.setBounds(190, 430, 30, 20);////
		tf_inven6.setEditable(false);
		
		//Addition
		tf_inven_arr[0] = tf_inven1; //조정 값 배열로 저장
		tf_inven_arr[1] = tf_inven2;
		tf_inven_arr[2] = tf_inven3;
		tf_inven_arr[3] = tf_inven4;
		tf_inven_arr[4] = tf_inven5;
		tf_inven_arr[5] = tf_inven6;
		
		scroll_inven1 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 2, 0, 52);
		scroll_inven2 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 2, 0, 52);
		scroll_inven3 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 2, 0, 52);
		scroll_inven4 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 2, 0, 52);
		scroll_inven5 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 2, 0, 52);
		scroll_inven6 = new JScrollBar(Scrollbar.HORIZONTAL, 0, 2, 0, 52);
		scroll_inven1.setBounds(60,130,90,20);//
		scroll_inven2.setBounds(220,130,90,20);//
		scroll_inven3.setBounds(60,280,90,20);//
		scroll_inven4.setBounds(220,280,90,20);//
		scroll_inven5.setBounds(60,430,90,20);
		scroll_inven6.setBounds(220,430,90,20);
		
		//Addition
		scroll_inven_arr[0] = scroll_inven1; //회수 버튼 배열로 저장
		scroll_inven_arr[1] = scroll_inven2;
		scroll_inven_arr[2] = scroll_inven3;
		scroll_inven_arr[3] = scroll_inven4;
		scroll_inven_arr[4] = scroll_inven5;
		scroll_inven_arr[5] = scroll_inven6;
		
		bt_add1 = new JButton("추가");
		bt_add1.setBounds(30, 150, 60, 30);//
		bt_minus1 = new JButton("회수");
		bt_minus1.setBounds(90, 150, 60, 30);//
		bt_add2 = new JButton("추가");
		bt_add2.setBounds(190, 150, 60, 30);//
		bt_minus2 = new JButton("회수");
		bt_minus2.setBounds(250, 150, 60, 30);//
		bt_add3 = new JButton("추가");
		bt_add3.setBounds(30, 300, 60, 30);//
		bt_minus3 = new JButton("회수");
		bt_minus3.setBounds(90, 300, 60, 30);//
		bt_add4 = new JButton("추가");
		bt_add4.setBounds(190, 300, 60, 30);///
		bt_minus4 = new JButton("회수");
		bt_minus4.setBounds(250, 300, 60, 30);//
		bt_add5 = new JButton("추가");
		bt_add5.setBounds(30, 450, 60, 30);
		bt_minus5 = new JButton("회수");
		bt_minus5.setBounds(90, 450, 60, 30);
		bt_add6 = new JButton("추가");
		bt_add6.setBounds(190, 450, 60, 30);
		bt_minus6 = new JButton("회수");
		bt_minus6.setBounds(250, 450, 60, 30);
		
		//Addition
		bt_add_arr[0] = bt_add1;	//추가 버튼 배열로 저장
		bt_add_arr[1] = bt_add2;
		bt_add_arr[2] = bt_add3;
		bt_add_arr[3] = bt_add4;
		bt_add_arr[4] = bt_add5;
		bt_add_arr[5] = bt_add6;
		bt_minus_arr[0] = bt_minus1; //회수 버튼 배열로 저장
		bt_minus_arr[1] = bt_minus2;
		bt_minus_arr[2] = bt_minus3;
		bt_minus_arr[3] = bt_minus4;
		bt_minus_arr[4] = bt_minus5;
		bt_minus_arr[5] = bt_minus6;
		
		//핸들 패널 안에 이미지 넣기
		ImageIcon p_menu_image = new ImageIcon("data/p_menu_image.png");//이미지 아이콘 객체 생성
		
		p_handle = new JPanel(){
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(p_menu_image.getImage(), 0, 0, d.width, d.height, null);
			}
		};//패널의 크기에 맞게 이미지 삽입
		
		p_handle.setBounds(370, 50, 330, 520);
		p_handle.setLayout(null);
		
		for(int i = 0; i < ta_add_arr.length; i++){
			p_handle.add(ta_add_arr[i]);
		}
		for(int i = 0; i < bt_add_arr.length; i++){
			p_handle.add(bt_add_arr[i]);
		}
		for(int i = 0; i < bt_minus_arr.length; i++){
			p_handle.add(bt_minus_arr[i]);
		}
		for(int i = 0; i < scroll_inven_arr.length; i++){
			p_handle.add(scroll_inven_arr[i]);
		}
		for(int i = 0; i < tf_inven_arr.length; i++){
			p_handle.add(tf_inven_arr[i]);
		}
		
		
      /*
       la_sale1=new JLabel("아이템1 판매량: ");      
       la_sale2=new JLabel("아이템2 판매량: ");      
       la_sale3=new JLabel("아이템3 판매량: ");      
       la_sale4=new JLabel("아이템4 판매량: ");      
       la_sale5=new JLabel("아이템5 판매량: ");      
       la_sale6=new JLabel("아이템6 판매량: ");      
       la_saletotal=new JLabel("아이템 총 판매량: ");   
       */   

//		la_ready = new JLabel("시재: ");
//		la_ready.setBounds(330, 625, 100, 50);

		ta_item = new JTextArea();
		ta_item.setEditable(false);
		ta_item.setBounds(10, 10, 210, 415);

		bt_return = new JButton("정산");
		bt_return.setBounds(10, 500, 210, 30);

		tf_total = new JTextField();		//총
		tf_total.setBounds(10, 440, 60, 30);


		p_handle2 = new JPanel();
		p_handle2.setBounds(700, 100, 240, 680);
		p_handle2.setLayout(null);
		p_handle2.setOpaque(false);
		p_handle2.add(ta_item);
		p_handle2.add(tf_total);
		//p_handle2.add(bt_return);
		
		//바탕 패널 안에 이미지 넣기
		ImageIcon p_image = new ImageIcon("data/bg_restaurant_admin.png");//이미지 아이콘 객체 생성
		
		p = new JPanel(){
            public void paintComponent(Graphics g) {
            	Dimension d = getSize();
                g.drawImage(p_image.getImage(), 0, 0, d.width, d.height, null);
            }
		};//패널의 크기에 맞게 이미지 삽입
		
		p.setLayout(null);
		
		p.add(la_top);
		p.add(bt_mainView);
		p.add(p_handle);
		p.add(p_handle2);

		
		this.add(p);
		this.setTitle("** 자판기 관리자 View **");
		this.setBounds(180, 20, 1000, 680);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

   }//생성자
   
//   public static void main(String[] args) {
//      new AdminView();
//   }//main
   
}//class