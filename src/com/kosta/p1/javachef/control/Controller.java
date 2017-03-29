package com.kosta.p1.javachef.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import com.kosta.p1.javachef.model.Item;
import com.kosta.p1.javachef.model.Model;
import com.kosta.p1.javachef.model.Money;
import com.kosta.p1.javachef.view.AdminView;
import com.kosta.p1.javachef.view.MainView;

public class Controller extends Thread implements ActionListener {
	MainView m_View;
	AdminView ad_View;

	Model m;
	Vector<String> iv, mv;//iv:메뉴 잠시 저장하는 벡터, mv:돈 잠시 저장하는 벡터
	
	public Controller() {
		m_View = new MainView();
		ad_View = new AdminView();
		
		m = new Model();
		iv = new Vector<>();
		mv = new Vector<>();
		
		this.eventUp();
		start();
	}
	
	public void run(){
		try {
	         BufferedReader ibr = new BufferedReader(new FileReader("item.txt"));//메뉴들의 정보 파일을 가져온다.
	         //FileWriter fw = new FileWriter("item.txt");
	         
	         do{
	            String iread = ibr.readLine();//메뉴 파일을 한줄씩 읽는다
	            if(iread==null) break;//값이 없으면 더이상 읽지 않는다
	            
	            String iread2[] = iread.split("=");//읽으면 =을 기준으로 값을 나눈다
	            
	            iv.add(iread2[1]);//인덱스1을 itemV벡터에 차례대로 넣는다

	            if(iv.size()==4){//itemV의 크기가 4가 되면
	            	String itemName = iv.get(0);
	            	int itemPrice = Integer.parseInt(iv.get(1));
	            	int itemNum = Integer.parseInt(iv.get(2));
	            	int itemAcc = Integer.parseInt(iv.get(3));
	            	
	            	Item item = new Item(itemName, itemPrice, itemNum, itemAcc);
	            	
	            	m.insert(item);
	               
	            	iv.removeAllElements();//하나의 메뉴 itemV가 생성되면 모두 지워 다른 메뉴를 넣을 준비를 한다.
	            }
	            
	         }while(true);
	         
	         Vector<Item> ii = m.selectitemAll();
	            for(int i=0; i<ii.size(); i++){
	    			Item p = ii.get(i);
	    			System.out.print(p.getItemName()+" ");
	    			System.out.print(p.getItemPrice()+" ");
	    			System.out.print(p.getItemNum()+" ");
	    			System.out.print(p.getItemAcc()+"\n");
	    		}
	            
	         BufferedReader mbr = new BufferedReader(new FileReader("money.txt"));//돈의 남은 수들(돈의 정보)을 가져온다.

	         do{
	            String mread = mbr.readLine();//돈 파일을 한줄씩 읽는다
	            if(mread==null) break;//값이 없으면 더이상 읽지 않는다
	            
	            String mread2[] = mread.split("=");//읽으면 =을 기준으로 값을 나눈다
	            
	            mv.add(mread2[1]);//인덱스1을 itemV벡터에 차례대로 넣는다

	            if(mv.size()==4){//itemV의 크기가 4가 되면
	            	int manwon_num = Integer.parseInt(mv.get(0));
	            	int ohchunwon_num = Integer.parseInt(mv.get(1));
	            	int chunwon_num = Integer.parseInt(mv.get(2));
	            	int ohbaekwon_num = Integer.parseInt(mv.get(3));
	            	//int 
	            	
	            	Money money = new Money(manwon_num, ohchunwon_num, chunwon_num, ohbaekwon_num);
	            	
	            	m.insert(money);
	               
	            	mv.removeAllElements();//하나의 메뉴 itemV가 생성되면 모두 지워 다른 메뉴를 넣을 준비를 한다.
	            }
	            
	         }while(true);
	         
	         Vector<Money> iii = m.selectmoneyAll();
	            for(int i=0; i<iii.size(); i++){
	    			Money p = iii.get(i);
	    			System.out.print(p.getManwon_num()+" ");
	    			System.out.print(p.getOhchunwon_num()+" ");
	    			System.out.print(p.getChunwon_num()+" ");
	    			System.out.print(p.getOhbaekwon_num()+"\n");
	    		}

	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}
	

	public void changeView(Object ob) {
		if (ob == m_View.bt_adminView) {
			m_View.setVisible(false); // 메인 숨김
			ad_View.setLocation(600, 50);
			ad_View.setVisible(true); // 관리자 표시
		} else if (ob == ad_View.bt_mainView) {
			ad_View.setVisible(false); // 관리자 숨김
			m_View.setLocation(600, 50);
			m_View.setVisible(true); // 메인 표시
		}
	} // changeView

	private void eventUp(){	//연결자 메소드
		m_View.bt_adminView.addActionListener(this); //메인 -> 관리자 변경
		ad_View.bt_mainView.addActionListener(this); //관리자 -> 자판기 변경
	}// eventUp

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		System.out.println(ob.toString()); //오브젝트 확인
		this.changeView(ob);
	}// actionPerformed

	public static void main(String[] args) {
		new Controller();
	}// main
}
