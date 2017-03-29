package com.kosta.p1.javachef.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import com.kosta.p1.javachef.model.Item;
import com.kosta.p1.javachef.model.Model;
import com.kosta.p1.javachef.view.AdminView;
import com.kosta.p1.javachef.view.MainView;

public class Controller implements ActionListener {
	MainView m_View;
	AdminView ad_View;
	
	Model m;
	Vector<String> iv;//iv:메뉴 잠시 저장하는 벡터, mv:돈 잠시 저장하는 벡터

	public Controller() {
		m_View = new MainView();
		ad_View = new AdminView();
		
		m = new Model();
		iv = new Vector<>();
		
		try {
	         BufferedReader ibr = new BufferedReader(new FileReader("data/item.txt"));//메뉴들의 정보 파일을 가져온다.
	         //FileWriter ifw = new FileWriter("data/item.txt");
	         
	         do{
	            String iread = ibr.readLine();//메뉴 파일을 한줄씩 읽는다
	            if(iread==null) break;//값이 없으면 더이상 읽지 않는다
	            
	            iv.add(iread);//인덱스1을 itemV벡터에 차례대로 넣는다

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

	      } catch (IOException e) {
	         e.printStackTrace();
	      }
		
		this.eventUp();
	}
	public void remainderItems(){//재고수량을 관리자 모드에서 표시
		ad_View.ta_inven1.setText(""+m.itemV.get(0).getItemNum());
		ad_View.ta_inven2.setText(""+m.itemV.get(1).getItemNum());
		ad_View.ta_inven3.setText(""+m.itemV.get(2).getItemNum());
		ad_View.ta_inven4.setText(""+m.itemV.get(3).getItemNum());
		ad_View.ta_inven5.setText(""+m.itemV.get(4).getItemNum());
		ad_View.ta_inven6.setText(""+m.itemV.get(5).getItemNum());
	}//remainderItems()

	public void salesStatement(){//1번 부터 6번까지 제품이름, 재고수량, 판매수량
		Vector<Item> itemV = m.selectitemAll(); 
		for(int  i= 0 ; i< m.itemV.size(); i++){
			
				Item p = m.itemV.get(i);
				ad_View.ta_item.append("제품이름"+"\t" +"재고수량"+"\t" + "판매수량\n"); 
				ad_View.ta_item.append(p.getItemName()+"\t" +p.getItemNum() +"\t" + p.getItemAcc()); 
				
				
				System.out.println(p.getItemName()+"\t" +p.getItemNum() +"\t" + p.getItemAcc()); //Debugging
							p.setItemNum(p.getItemNum()+5);
		}//for TextArea (1-6)
		
	}//salesStatement()
	
	public void itemView(){ //자판기 상품명 가격 표시 메소드
		Vector<Item> v = m.selectitemAll();
		for(int i=0; i<v.size(); i++){
			Item item = v.get(i);
			m_View.la_menu_arr[i].setText(item.getItemName() + "   " + item.getItemPrice()); 
		}
	}//itemView

	
	public void changeView(Object ob) {
		if (ob == m_View.bt_adminView) {
			m_View.setVisible(false); // 메인 숨김
			ad_View.setLocation(600, 50);
			ad_View.setVisible(true); // 관리자 표시
			this.remainderItems(); //관리자모드가 바뀌자마자 재고수량 표시
			this.salesStatement();// 매출표_제품이름_재고수량_판매수량
		} else if (ob == ad_View.bt_mainView) {
			ad_View.setVisible(false); // 관리자 숨김
			m_View.setLocation(600, 50);
			m_View.setVisible(true); // 메인 표시
		}
	} // changeView
	
	
	private void selectMenu(Object ob) {
		if (ob == m_View.bt_menu1) {
			m_View.display();
		}
	} // selectMenu
	
	private void clearMenu(Object ob) {
		if (ob == m_View.bt_final) {
			m_View.clear();
		}
	} // clearMenu
	
	private void payCash(Object ob){
		if (ob == m_View.bt_cash) {
			m_View.cash();
		}
	} // payCash
	
	private void payCard(Object ob){
		if (ob == m_View.bt_card) {
			m_View.card();
		}
	} // payCard
	
	private void eventUp(){	//연결자 메소드
		m_View.bt_adminView.addActionListener(this); //메인 -> 관리자 변경
		ad_View.bt_mainView.addActionListener(this); //관리자 -> 자판기 변경
		
		m_View.bt_menu1.addActionListener(this); //메인 -> 메뉴1 버튼
		m_View.bt_final.addActionListener(this); //메인 -> 취소 버튼
		m_View.bt_cash.addActionListener(this); //메인 -> 현금 버튼
		m_View.bt_card.addActionListener(this); //메인 -> 현금 버튼
	}// eventUp

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		System.out.println(ob.toString()); //오브젝트 확인
		this.changeView(ob);
		
		this.selectMenu(ob); //메인뷰의 메뉴 버튼 조작
		this.clearMenu(ob); //메인뷰의 취소버튼 조작
		this.payCash(ob); //메인뷰의 현금버튼 조작
		this.payCard(ob); //메인뷰의 카드버튼 조작
	}// actionPerformed

	public static void main(String[] args) {
		new Controller();
	}// main
}
