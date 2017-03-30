package com.kosta.p1.javachef.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
	MyFile mf;
	Vector<Object> tempV;
	int itemCount[] = new int[6];

	public Controller() {
		m_View = new MainView();
		ad_View = new AdminView();
		
		m = new Model();
		tempV = new Vector<>();
		
		mf = new MyFile(m);		
		mf.filereader();

		this.viewItemTable(); //테이블 표시
		this.eventUp();
	}
	public void remainderItems(){//재고수량을 관리자 모드에서 표시
		Vector<Item> itemV = m.selectitemAll();
		for(int i=0; i<itemV.size(); i++){
			Item iv = itemV.get(i);
		//지워야함	ad_View.ta_inven_arr[i].setText(""+iv.getItemNum()); 
			ad_View.ta_add_arr[i].setText("제품이름"+iv.getItemName()+"\n" +"재고수량"+iv.getItemNum()+"\n" + "판매수량"+iv.getItemAcc()+"\n");
		}
		
	}//remainderItems()

	public void salesStatement(){//1번 부터 6번까지 제품이름, 재고수량, 판매수량 in 큰 화면
		Vector<Item> itemV = m.selectitemAll(); 
		for(int  i= 0 ; i< itemV.size(); i++){
			
				Item p = itemV.get(i);
				ad_View.ta_item.append("제품이름"+"\t" +"판매수량"+"\t" + i+"판매액"+"\n"); 
				ad_View.ta_item.append(p.getItemName()+" "+ p.getItemAcc()+"   "+ p.getItemPrice()*p.getItemAcc()); 
				
				
				System.out.println(p.getItemName()+"\t" +p.getItemNum() +"\t" + p.getItemAcc()); //Debugging
						
		}//for TextArea (1-6)
		
	}//salesStatement()
	
	
	public void viewItemTable() { // 상품 테이블 표시 초기화
		Vector<Item> itemV = m.selectitemAll();
		Vector v;
		for (int i = 0; i < 6; i++) {
			v = new Vector();
			v.add(itemV.get(i).getItemName());
			v.add(itemCount[i]);
			v.add(itemV.get(i).getItemPrice() * itemCount[0]);
			tempV.add(v);
			tempV.set(0, v);
			m_View.dtm.addRow((Vector) tempV.get(0));
		}
	}

	
	public void selectItem(int number) {// 상품 선택
		Vector<Item> itemV = m.selectitemAll();
		Vector v;
		itemCount[number]++; // 카운터

		v = new Vector();
		v.add(itemV.get(number).getItemName());
		v.add(itemCount[number]);
		v.add(itemV.get(number).getItemPrice() * itemCount[number]);

		System.out.println("벡터 저장 전: " + tempV.toString());
		tempV.set(number, v);
		System.out.println("벡터 저장 후: " + tempV.toString());
		m_View.dtm.setValueAt(itemCount[number], number, 1);
		m_View.dtm.setValueAt(itemV.get(number).getItemPrice() * itemCount[number], number, 2);
	} // selectItem

	public void selectReset() { // 상품 선택 전체 초기화
		Vector<Item> itemV = m.selectitemAll();
		Vector v;
		for (int i = 0; i < tempV.size(); i++) {
			itemCount[i] = 0;
			v = new Vector();
			v.add(itemV.get(i).getItemName());
			v.add(itemCount[i]);
			v.add(itemV.get(i).getItemPrice() * itemCount[0]);
			tempV.set(0, v);
			System.out.println("벡터 초기화 후: " + tempV.toString());
			m_View.dtm.removeRow(0);
			m_View.dtm.addRow((Vector) tempV.get(0));
		}
	} // selectReset

	public void itemView() { // 자판기 상품명 가격 표시 메소드
		Vector<Item> v = m.selectitemAll();
		for (int i = 0; i < v.size(); i++) {
			Item item = v.get(i);
			m_View.la_menu_arr[i].setText(item.getItemName() + "   " + item.getItemPrice());
		}
	}// itemView

	public void totalView(){  //총매출 표시 메소드 in 관리자
		Vector<Item> itemV = m.selectitemAll();
		for(int i =0; i<itemV.size(); i++){
			Item iv = itemV.get(i);
			ad_View.la_
		}
	}//totalView

	m_View.addWindowListener(new WindowAdapter() {

		@Override
		public void windowClosing(WindowEvent e) {
			//m.itemV.get(0).setItemAcc(3);
			mf.filewrite();
			
			System.exit(0);
		}
	});
}
	
	public void changeView(Object ob) {
		if (ob == m_View.bt_adminView) {
			m_View.setVisible(false); // 메인 숨김
			ad_View.setLocation(600, 50);
			ad_View.setVisible(true); // 관리자 표시
			this.remainderItems(); // 관리자모드가 바뀌자마자 재고수량 표시
			this.salesStatement();// 매출표_제품이름_재고수량_판매수량
		} else if (ob == ad_View.bt_mainView) {
			ad_View.setVisible(false); // 관리자 숨김
			m_View.setLocation(600, 50);
			m_View.setVisible(true); // 메인 표시
		}
	} // changeView
	
	private void selectMenu(Object ob) {
		if (ob == m_View.bt_menu1) {
			this.selectItem(0);
		}else if (ob == m_View.bt_menu2) {
			this.selectItem(1);			
		}else if (ob == m_View.bt_menu3) {
			this.selectItem(2);			
		}else if (ob == m_View.bt_menu4) {
			this.selectItem(3);			
		}else if (ob == m_View.bt_menu5) {
			this.selectItem(4);			
		}else if (ob == m_View.bt_menu6) {
			this.selectItem(5);		
		}
	} // selectMenu
	
	private void clearMenu(Object ob) {
		if (ob == m_View.bt_final) {
			this.selectReset();
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
		m_View.bt_menu2.addActionListener(this); //메인 -> 메뉴2 버튼
		m_View.bt_menu3.addActionListener(this); //메인 -> 메뉴3 버튼
		m_View.bt_menu4.addActionListener(this); //메인 -> 메뉴4 버튼
		m_View.bt_menu5.addActionListener(this); //메인 -> 메뉴5 버튼
		m_View.bt_menu6.addActionListener(this); //메인 -> 메뉴6 버튼
		m_View.bt_final.addActionListener(this); //메인 -> 취소 버튼
		m_View.bt_cash.addActionListener(this); //메인 -> 현금 버튼
		m_View.bt_card.addActionListener(this); //메인 -> 현금 버튼

		//addition
		ad_View.bt_add1.addActionListener(this);//메뉴1 수량 추가버튼
		ad_View.bt_add2.addActionListener(this);
		ad_View.bt_add3.addActionListener(this);
		ad_View.bt_add4.addActionListener(this);
		ad_View.bt_add5.addActionListener(this);
		ad_View.bt_add6.addActionListener(this);//메뉴6 수량 추가버튼
		ad_View.bt_minus1.addActionListener(this);//메뉴1 수량 회수버튼
		ad_View.bt_minus2.addActionListener(this);
		ad_View.bt_minus3.addActionListener(this);
		ad_View.bt_minus4.addActionListener(this);
		ad_View.bt_minus5.addActionListener(this);
		ad_View.bt_minus6.addActionListener(this);//메뉴 6 수량 회수버튼

	
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
	
		Vector<Item> itemV = m.selectitemAll();
		
		if(ob == ad_View.bt_add1){//1번 재고수량 추가 버튼
			
			itemV.get(0).setItemNum(itemV.get(0).getItemNum()+ad_View.scroll_inven1.getValue());
		
		}else if(ob == ad_View.bt_add2){//2번 재고수량 추가 버튼
			
			itemV.get(1).setItemNum(itemV.get(1).getItemNum()+ad_View.scroll_inven2.getValue());
		
		}else if(ob == ad_View.bt_add3){//3번 재고수량 추가 버튼
			
			itemV.get(2).setItemNum(itemV.get(2).getItemNum()+ad_View.scroll_inven3.getValue());
		
		}else if(ob == ad_View.bt_add4){//4번 재고수량 추가 버튼
			
			itemV.get(3).setItemNum(itemV.get(3).getItemNum()+ad_View.scroll_inven4.getValue());
		
		}else if(ob == ad_View.bt_add5){//5번 재고수량 추가 버튼
			
			itemV.get(4).setItemNum(itemV.get(4).getItemNum()+ad_View.scroll_inven5.getValue());
		
		}else if(ob == ad_View.bt_add6){//6번 재고수량 추가 버튼
			
			itemV.get(5).setItemNum(itemV.get(5).getItemNum()+ad_View.scroll_inven6.getValue());
		
		}else if(ob == ad_View.bt_minus1){//1번 재고수량 회수 버튼
			
			itemV.get(0).setItemNum(itemV.get(0).getItemNum()-ad_View.scroll_inven1.getValue());
		
		}else if(ob == ad_View.bt_minus2){//2번 재고수량 회수 버튼
			
			itemV.get(1).setItemNum(itemV.get(1).getItemNum()-ad_View.scroll_inven2.getValue());
		
		}else if(ob == ad_View.bt_minus3){//3번 재고수량 회수 버튼
			
			itemV.get(2).setItemNum(itemV.get(2).getItemNum()-ad_View.scroll_inven3.getValue());
		
		}else if(ob == ad_View.bt_minus4){//4번 재고수량 회수 버튼
			
			itemV.get(3).setItemNum(itemV.get(3).getItemNum()-ad_View.scroll_inven4.getValue());
		
		}else if(ob == ad_View.bt_minus5){//5번 재고수량 회수 버튼
			
			itemV.get(4).setItemNum(itemV.get(4).getItemNum()-ad_View.scroll_inven5.getValue());
		
		}else if(ob == ad_View.bt_minus6){//6번 재고수량 회수 버튼
			
			itemV.get(5).setItemNum(itemV.get(5).getItemNum()-ad_View.scroll_inven6.getValue());
		
		}//관리자 button 추가, 삭제
	}// actionPerformed

	public static void main(String[] args) {
		new Controller();
	}// main
}
