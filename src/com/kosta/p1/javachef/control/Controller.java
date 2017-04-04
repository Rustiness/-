package com.kosta.p1.javachef.control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import com.kosta.p1.javachef.model.Item;
import com.kosta.p1.javachef.model.Model;
import com.kosta.p1.javachef.view.AdminView;
import com.kosta.p1.javachef.view.MainView;

public class Controller implements ActionListener, AdjustmentListener {
	MThread cThread; // 스레드 선언
	MainView m_View;
	AdminView ad_View;

	Model m;
	MyFile mf;
	int itemCount[] = new int[6];

	Vector<Object> tempV;
	Vector<Item> itemV;
	Vector<Object> v;
	Vector<Vector> accV;// 아래의 벡터를 담은 벡터(여러 아이템을 구매했을때를 위한)
	Vector<String> accV2;// 고객이 선택한 아이템이름과 수량을 담는 벡터

	public Controller() {
		m_View = new MainView();
		ad_View = new AdminView();

		m = new Model();
		mf = new MyFile(m);
		mf.filereader();

		tempV = new Vector<>();
		itemV = m.selectitemAll();
		v = new Vector<>();
		accV = new Vector<>();
		accV2 = new Vector<>();
		
		this.viewItemTable(); // 테이블 표시
		this.itemView(); //상품 라벨 갱신
		this.eventUp();
		
		m_View.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				//m.itemV.get(0).setItemAcc(3);
				mf.filewrite();
				//m.t.setTotal(total);
				
				System.exit(0);
			}
		});
		
		ad_View.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				//m.itemV.get(0).setItemAcc(3);
				mf.filewrite();
				//m.t.setTotal(total);
				
				System.exit(0);
			}
		});
	}

	public void remainderItems() {// 재고수량을 관리자 모드에서 표시
//		System.out.println("itemV" + itemV);
		for (int i = 0; i < itemV.size(); i++) {
			Item iv = itemV.get(i);
	
			ad_View.ta_add_arr[i].setText("제품이름:\n"+iv.getItemName()+ "\n"+"재고수량:"+iv.getItemNum()+"\n" + "판매수량:"+iv.getItemAcc()+"\n");
			}
		
	}//remainderItems()

	public void salesStatement(){//1번 부터 6번까지 제품이름, 재고수량, 판매수량 in 큰 화면		
		ad_View.ta_item.setText("           ▶"+"제품이름"+"  "+ itemV.get(0).getItemName()+"\n"
								+"               "+"판매수량"+"  "+  itemV.get(0).getItemAcc()+"\n"
								+"               "+"판매금액"+"  "+ itemV.get(0).getItemPrice()*itemV.get(0).getItemAcc()+"\n"
								+"\n "
								+"           ▶"+"제품이름"+"  "+ itemV.get(1).getItemName()+"\n"
								+"               "+"판매수량"+"  "+  itemV.get(1).getItemAcc()+"\n"
								+"               "+"판매금액"+"  "+ itemV.get(1).getItemPrice()*itemV.get(1).getItemAcc()+"\n"
								+"\n "
								+"           ▶"+"제품이름"+"  "+ itemV.get(2).getItemName()+"\n"
								+"               "+"판매수량"+"  "+  itemV.get(2).getItemAcc()+"\n"
								+"               "+"판매금액"+"  "+ itemV.get(2).getItemPrice()*itemV.get(2).getItemAcc()+"\n"
								+"\n "
								+"           ▶"+"제품이름"+"  "+ itemV.get(3).getItemName()+"\n"
								+"               "+"판매수량"+"  "+  itemV.get(3).getItemAcc()+"\n"
								+"               "+"판매금액"+"  "+ itemV.get(3).getItemPrice()*itemV.get(3).getItemAcc()+"\n"
								+"\n "
								+"           ▶"+"제품이름"+"  "+ itemV.get(4).getItemName()+"\n"
								+"               "+"판매수량"+"  "+  itemV.get(4).getItemAcc()+"\n"
								+"               "+"판매금액"+"  "+ itemV.get(4).getItemPrice()*itemV.get(4).getItemAcc()+"\n"
								+"\n "
								+"           ▶"+"제품이름"+"  "+ itemV.get(5).getItemName()+"\n"
								+"               "+"판매수량"+"  "+  itemV.get(5).getItemAcc()+"\n"
								+"               "+"판매금액"+"  "+ itemV.get(5).getItemPrice()*itemV.get(5).getItemAcc()+"\n"
								+"\n ");
		
	}//salesStatement()
	
	
	public void viewItemTable() { // 상품 테이블 표시 초기화
		for (int i = 0; i < 6; i++) {
			v = new Vector<Object>();
			v.add(itemV.get(i).getItemName());
			v.add(itemCount[i]);
			v.add(itemV.get(i).getItemPrice() * itemCount[0]);
			tempV.add(v);
			tempV.set(0, v);
			m_View.dtm.addRow((Vector) tempV.get(0));
		}
	}
	
	
	public void selectItem(int number) {// 상품 선택
		if (itemV.get(number).getItemNum() - (Integer) m_View.dtm.getValueAt(number, 1) < 1){
				m_View.showMsg("상품 재고가 부족합니다.");
				return;
		}
		
		itemCount[number]++; // 카운터
		this.itemView(); //상품 라벨 갱신
		v = new Vector<>();
		v.add(itemV.get(number).getItemName());
		v.add(itemCount[number]);
		v.add(itemV.get(number).getItemPrice() * itemCount[number]);
		v.add(String.format("%,d", itemV.get(number).getItemPrice() * itemCount[number]));

		//System.out.println("벡터 저장 전 : " + tempV.get(number).toString());
		tempV.set(number, v);
		//System.out.println("벡터 저장 후 : " + tempV.get(number).toString());
		m_View.dtm.setValueAt(v.get(1), number, 1);
		m_View.dtm.setValueAt(String.format("%,d", v.get(2)), number, 2);

		int a = Integer.valueOf(String.valueOf(m_View.dtm.getValueAt(0, 2)).replaceAll(",", ""));
		int b = Integer.valueOf(String.valueOf(m_View.dtm.getValueAt(1, 2)).replaceAll(",", ""));
		int c = Integer.valueOf(String.valueOf(m_View.dtm.getValueAt(2, 2)).replaceAll(",", ""));
		int d = Integer.valueOf(String.valueOf(m_View.dtm.getValueAt(3, 2)).replaceAll(",", ""));
		int e = Integer.valueOf(String.valueOf(m_View.dtm.getValueAt(4, 2)).replaceAll(",", ""));
		int f = Integer.valueOf(String.valueOf(m_View.dtm.getValueAt(5, 2)).replaceAll(",", ""));
		
		int total = a + b + c + d + e + f;
		
		selectTotal(total);
		
		m_View.bt_cash.setEnabled(true);	//결제 버튼 표시
		m_View.bt_card.setEnabled(true);
		m_View.bt_final.setEnabled(true);

	} // selectItem
	
	public void selectTotal(int total) { //선택 총 가격 
		m_View.tf_total.setText("총 가격 : " + String.format("%,d", total) + "원");
	}//selectTotal
	
	public void selectReset() { // 상품 선택 전체 초기화
		this.itemView(); // 상품 라벨 갱신
		m_View.bt_cash.setEnabled(false); // 결제 버튼 숨김
		m_View.bt_card.setEnabled(false);
		m_View.bt_final.setEnabled(false);
		for (int i = 0; i < tempV.size(); i++) {
			itemCount[i] = 0;
			v = new Vector<>();
			v.add(itemV.get(i).getItemName());
			v.add(0);
			v.add(0);
			tempV.set(0, v);
			//System.out.println("벡터 초기화 후: " + tempV.get(0).toString());
			m_View.dtm.removeRow(0);
			m_View.dtm.addRow((Vector) tempV.get(0));
			selectTotal(0);
		}
	} // selectReset
	
	public void itemView() { // 자판기 상품명 가격 표시 메소드
		for (int i = 0; i < itemV.size(); i++) {
			Item item = itemV.get(i);
			m_View.la_menu_arr[i].setText(item.getItemName() + " | " + String.format("%,d", item.getItemPrice()) + "원 | " + item.getItemNum() +"매");
		}
	}// itemView
	
	public void totalView(){  //총매출 표시 메소드 in 관리자
		   int sum=0;
		for(int i =0; i<itemV.size(); i++){
			Item iv = itemV.get(i);
			//salesMoney = iv.getItemAcc()* iv.getItemPrice();
			sum += iv.getItemAcc()* iv.getItemPrice();
			}//for
		//m.t.setTotal(total);
		ad_View.tf_total.setText("총 매출액: "+sum+"원");
	}//totalView
	
	public void card(){ //카드 결제
		int i = m_View.showConfMsg(m_View.tf_total.getText() + " 입니다.\n 카드결제를 진행하시겠습니까?");
		if(i == 0){
			String str = m_View.tf_total.getText().replaceAll(",", "");
			String str2 = str.substring(7, str.length()-1);
			int total = Integer.parseInt(str2);
			m.t.setTotal(total);
			this.acc();
			this.sendAcc();
			this.selectReset(); // 상품 선택 전체 초기화
			m_View.showMsg("결제가 완료되었습니다.");
			cThread = new MThread(); // 스레드 초기화
			cThread.start(); // 스레드 시작
		}
		//System.out.println(m.t.getTotal());
	} // card
	
	public void acc() {
		accV2.clear();
		for (int i = 0; i < m_View.dtm.getRowCount(); i++) {
			// System.out.println("테이블행수:"+m_View.dtm.getRowCount());

			int ii = (Integer) m_View.dtm.getValueAt(i, 1);
			if (ii > 0) {
				accV2.add(String.valueOf(m_View.dtm.getValueAt(i, 0)));
				//System.out.println("가져온 이름:"+String.valueOf(m_View.dtm.getValueAt(i, 0)));
				accV2.add(String.valueOf(m_View.dtm.getValueAt(i, 1)));
				//System.out.println("가져온 갯수:"+String.valueOf(m_View.dtm.getValueAt(i, 1)));
				accV.add(accV2);
				//System.out.println("acc에 "+String.valueOf(m_View.dtm.getValueAt(i, 0))+"추가함");
				for(int j=0; j<accV2.size(); j++){
					//System.out.println("accV의 벡터"+accV2.get(j));
				}
			}
		}
		//System.out.println("=====================");
	}
	
	public void sendAcc(){ //상품 판매 정보 전송 
		//System.out.println("accV크기: "+accV.size());
		//System.out.println(String.valueOf(accV.get(0).get(0)));
		//System.out.println(String.valueOf(accV.get(1).get(0)));
		//System.out.println(String.valueOf(accV.get(2).get(0)));
		//System.out.println(String.valueOf(accV.get(3).get(0)));
		int count=0;
		for(int i=0; i<accV.size(); i++){
			for(int j=count; j<accV2.size(); j++){
				//System.out.println("상품명 : "+String.valueOf(accV.get(i).get(j)));
				//System.out.println("수량 : "+String.valueOf(accV.get(i).get(j+1)));
				String itemName = String.valueOf(accV.get(i).get(j));
				int itemStock = Integer.parseInt(String.valueOf(accV.get(i).get(j+1)));
				
				m.updateItem(itemName, itemStock);
				
				count+=2;
				break;
			}
		}
	
	}//sendAcc
	
	public void changeView(Object ob) {
		if (ob == m_View.bt_adminView) {
			m_View.setVisible(false); // 메인 숨김
			ad_View.setLocation(180, 20);
			ad_View.setVisible(true); // 관리자 표시
			this.remainderItems(); // 관리자모드가 바뀌자마자 재고수량 표시
			this.salesStatement();// 매출표_제품이름_재고수량_판매수량
			this.totalView();
		} else if (ob == ad_View.bt_mainView) {
			ad_View.setVisible(false); // 관리자 숨김
			m_View.setLocation(180, 20);
			m_View.setVisible(true); // 메인 표시
			this.itemView(); // 상품 라벨 갱신
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
			this.card();
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
		
		ad_View.scroll_inven1.addAdjustmentListener(this);
		ad_View.scroll_inven2.addAdjustmentListener(this);
		ad_View.scroll_inven3.addAdjustmentListener(this);
		ad_View.scroll_inven4.addAdjustmentListener(this);
		ad_View.scroll_inven5.addAdjustmentListener(this);
		ad_View.scroll_inven6.addAdjustmentListener(this);
	}// eventUp

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		//System.out.println(ob.toString()); //오브젝트 확인
		this.changeView(ob);
		
		this.selectMenu(ob); //메인뷰의 메뉴 버튼 조작
		this.clearMenu(ob); //메인뷰의 취소버튼 조작
		this.payCash(ob); //메인뷰의 현금버튼 조작
		this.payCard(ob); //메인뷰의 카드버튼 조작
		
		if (ob == ad_View.bt_add1) {// 1번 재고수량 추가 버튼
			
			if(m.itemV.get(0).getItemNum()+ ad_View.scroll_inven1.getValue() > 200) {
				ad_View.showMsg("재고 최대수량은200개 입니다\n"
						+(200-m.itemV.get(0).getItemNum()+"개만 추가하세요"));
			}else {
				m.itemV.get(0).setItemNum(m.itemV.get(0).getItemNum() + ad_View.scroll_inven1.getValue());
				ad_View.scroll_inven1.setValue(0);	
			}
			remainderItems();
		} else if (ob == ad_View.bt_add2) {// 2번 재고수량 추가 버튼
			
			if(m.itemV.get(1).getItemNum()+ ad_View.scroll_inven2.getValue() > 200) {
				ad_View.showMsg("재고 최대수량은200개 입니다\n"
						+(200-m.itemV.get(1).getItemNum()+"개만 추가하세요"));
			}else {
				m.itemV.get(1).setItemNum(m.itemV.get(1).getItemNum() + ad_View.scroll_inven2.getValue());
				ad_View.scroll_inven2.setValue(0);	
			}
			remainderItems();
		} else if (ob == ad_View.bt_add3) {// 3번 재고수량 추가 버튼
			if(m.itemV.get(2).getItemNum()+ ad_View.scroll_inven3.getValue() > 200) {
				ad_View.showMsg("재고 최대수량은200개 입니다\n"
						+(200-m.itemV.get(2).getItemNum()+"개만 추가하세요"));
			}else {
				m.itemV.get(2).setItemNum(m.itemV.get(2).getItemNum() + ad_View.scroll_inven3.getValue());
				ad_View.scroll_inven3.setValue(0);	
			}
			remainderItems();
			
			
		} else if (ob == ad_View.bt_add4) {// 4번 재고수량 추가 버튼
			if(m.itemV.get(3).getItemNum()+ ad_View.scroll_inven4.getValue() > 200) {
				ad_View.showMsg("재고 최대수량은200개 입니다\n"
						+(200-m.itemV.get(3).getItemNum()+"개만 추가하세요"));
			}else {
				m.itemV.get(3).setItemNum(m.itemV.get(3).getItemNum() + ad_View.scroll_inven4.getValue());
				ad_View.scroll_inven4.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_add5) {// 5번 재고수량 추가 버튼
			if(m.itemV.get(4).getItemNum()+ ad_View.scroll_inven5.getValue() > 200) {
				ad_View.showMsg("재고 최대수량은200개 입니다\n"
						+(200-m.itemV.get(4).getItemNum()+"개만 추가하세요"));
			}else {
				m.itemV.get(4).setItemNum(m.itemV.get(4).getItemNum() + ad_View.scroll_inven5.getValue());
				ad_View.scroll_inven5.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_add6) {// 6번 재고수량 추가 버튼
			if(m.itemV.get(5).getItemNum()+ ad_View.scroll_inven6.getValue() > 200) {
				ad_View.showMsg("재고 최대수량은200개 입니다\n"
						+(200-m.itemV.get(5).getItemNum()+"개만 추가하세요"));
			}else {
				m.itemV.get(5).setItemNum(m.itemV.get(5).getItemNum() + ad_View.scroll_inven6.getValue());
				ad_View.scroll_inven6.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_minus1) {// 1번 재고수량 회수 버튼
			if(m.itemV.get(0).getItemNum() - ad_View.scroll_inven1.getValue()<0){
				ad_View.showMsg("재고 최소수량은0개 입니다\n"
						+(m.itemV.get(0).getItemNum()+"개까지 회수 가능합니다"));
			}else {
				m.itemV.get(0).setItemNum(m.itemV.get(0).getItemNum() - ad_View.scroll_inven1.getValue());
				ad_View.scroll_inven1.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_minus2) {// 2번 재고수량 회수 버튼
			
			if(m.itemV.get(1).getItemNum() - ad_View.scroll_inven2.getValue()<0){
				ad_View.showMsg("재고 최소수량은0개 입니다\n"
						+(m.itemV.get(1).getItemNum()+"개까지 회수 가능합니다"));
			}else {
				m.itemV.get(1).setItemNum(m.itemV.get(1).getItemNum() - ad_View.scroll_inven2.getValue());
				ad_View.scroll_inven2.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_minus3) {// 3번 재고수량 회수 버튼
			
			if(m.itemV.get(2).getItemNum() - ad_View.scroll_inven3.getValue()<0){
				ad_View.showMsg("재고 최소수량은0개 입니다\n"
						+(m.itemV.get(2).getItemNum()+"개까지 회수 가능합니다"));
			}else {
				m.itemV.get(2).setItemNum(m.itemV.get(2).getItemNum() - ad_View.scroll_inven3.getValue());
				ad_View.scroll_inven3.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_minus4) {// 4번 재고수량 회수 버튼
			
			if(m.itemV.get(3).getItemNum() - ad_View.scroll_inven4.getValue()<0){
				ad_View.showMsg("재고 최소수량은0개 입니다\n"
						+(m.itemV.get(3).getItemNum()+"개까지 회수 가능합니다"));
			}else {
				m.itemV.get(3).setItemNum(m.itemV.get(3).getItemNum() - ad_View.scroll_inven4.getValue());
				ad_View.scroll_inven4.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_minus5) {// 5번 재고수량 회수 버튼
			
			if(m.itemV.get(4).getItemNum() - ad_View.scroll_inven5.getValue()<0){
				ad_View.showMsg("재고 최소수량은0개 입니다\n"
						+(m.itemV.get(4).getItemNum()+"개까지 회수 가능합니다"));
			}else {
				m.itemV.get(4).setItemNum(m.itemV.get(4).getItemNum() - ad_View.scroll_inven5.getValue());
				ad_View.scroll_inven5.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_minus6) {// 6번 재고수량 회수 버튼
			if(m.itemV.get(5).getItemNum() - ad_View.scroll_inven6.getValue()<0){
				ad_View.showMsg("재고 최소수량은0개 입니다\n"
						+(m.itemV.get(5).getItemNum()+"개까지 회수 가능합니다"));
			}else {
				m.itemV.get(5).setItemNum(m.itemV.get(5).getItemNum() - ad_View.scroll_inven6.getValue());
				ad_View.scroll_inven6.setValue(0);	
			}
			remainderItems();
		}//관리자 button 추가, 삭제
	}// actionPerformed
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		int one = ad_View.scroll_inven1.getValue();
		int two = ad_View.scroll_inven2.getValue();
		int three = ad_View.scroll_inven3.getValue();
		int four = ad_View.scroll_inven4.getValue();
		int five = ad_View.scroll_inven5.getValue();
		int six = ad_View.scroll_inven6.getValue();
		
		ad_View.tf_inven1.setText("");
		ad_View.tf_inven1.setText(""+one);
		ad_View.tf_inven2.setText("");
		ad_View.tf_inven2.setText(""+two);
		ad_View.tf_inven3.setText("");
		ad_View.tf_inven3.setText(""+three);
		ad_View.tf_inven4.setText("");
		ad_View.tf_inven4.setText(""+four);
		ad_View.tf_inven5.setText("");
		ad_View.tf_inven5.setText(""+five);
		ad_View.tf_inven6.setText("");
		ad_View.tf_inven6.setText(""+six);
	}
	public static void main(String[] args) {
		new Controller();
	}// main

	class MThread extends Thread { // 스레드 클래스 생성
		public void run() { // 스레드 run 메소드
			try {
				for (int i = 0; i < 8; i++) {
					m_View.la_ticket.setBackground(Color.BLUE);
					Thread.sleep(100);
					m_View.la_ticket.setBackground(Color.MAGENTA);
					Thread.sleep(100);
				}
				m_View.la_ticket.setBackground(Color.MAGENTA);
				Thread.sleep(800);
				m_View.la_ticket.setBackground(Color.DARK_GRAY);
				System.out.println(this.getState());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//run
	}//Thread
}
