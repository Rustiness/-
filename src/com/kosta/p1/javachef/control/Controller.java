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

		this.viewItemTable(); //���̺� ǥ��
		this.eventUp();
	}
	public void remainderItems(){//�������� ������ ��忡�� ǥ��
		Vector<Item> itemV = m.selectitemAll();
		for(int i=0; i<itemV.size(); i++){
			Item iv = itemV.get(i);
		//��������	ad_View.ta_inven_arr[i].setText(""+iv.getItemNum()); 
			ad_View.ta_add_arr[i].setText("��ǰ�̸�"+iv.getItemName()+"\n" +"������"+iv.getItemNum()+"\n" + "�Ǹż���"+iv.getItemAcc()+"\n");
		}
		
	}//remainderItems()

	public void salesStatement(){//1�� ���� 6������ ��ǰ�̸�, ������, �Ǹż��� in ū ȭ��
		Vector<Item> itemV = m.selectitemAll(); 
		for(int  i= 0 ; i< itemV.size(); i++){
			
				Item p = itemV.get(i);
				ad_View.ta_item.append("��ǰ�̸�"+"\t" +"�Ǹż���"+"\t" + i+"�Ǹž�"+"\n"); 
				ad_View.ta_item.append(p.getItemName()+" "+ p.getItemAcc()+"   "+ p.getItemPrice()*p.getItemAcc()); 
				
				
				System.out.println(p.getItemName()+"\t" +p.getItemNum() +"\t" + p.getItemAcc()); //Debugging
						
		}//for TextArea (1-6)
		
	}//salesStatement()
	
	
	public void viewItemTable() { // ��ǰ ���̺� ǥ�� �ʱ�ȭ
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

	
	public void selectItem(int number) {// ��ǰ ����
		Vector<Item> itemV = m.selectitemAll();
		Vector v;
		itemCount[number]++; // ī����

		v = new Vector();
		v.add(itemV.get(number).getItemName());
		v.add(itemCount[number]);
		v.add(itemV.get(number).getItemPrice() * itemCount[number]);

		System.out.println("���� ���� ��: " + tempV.toString());
		tempV.set(number, v);
		System.out.println("���� ���� ��: " + tempV.toString());
		m_View.dtm.setValueAt(itemCount[number], number, 1);
		m_View.dtm.setValueAt(itemV.get(number).getItemPrice() * itemCount[number], number, 2);
	} // selectItem

	public void selectReset() { // ��ǰ ���� ��ü �ʱ�ȭ
		Vector<Item> itemV = m.selectitemAll();
		Vector v;
		for (int i = 0; i < tempV.size(); i++) {
			itemCount[i] = 0;
			v = new Vector();
			v.add(itemV.get(i).getItemName());
			v.add(itemCount[i]);
			v.add(itemV.get(i).getItemPrice() * itemCount[0]);
			tempV.set(0, v);
			System.out.println("���� �ʱ�ȭ ��: " + tempV.toString());
			m_View.dtm.removeRow(0);
			m_View.dtm.addRow((Vector) tempV.get(0));
		}
	} // selectReset

	public void itemView() { // ���Ǳ� ��ǰ�� ���� ǥ�� �޼ҵ�
		Vector<Item> v = m.selectitemAll();
		for (int i = 0; i < v.size(); i++) {
			Item item = v.get(i);
			m_View.la_menu_arr[i].setText(item.getItemName() + "   " + item.getItemPrice());
		}
	}// itemView

	public void totalView(){  //�Ѹ��� ǥ�� �޼ҵ� in ������
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
			m_View.setVisible(false); // ���� ����
			ad_View.setLocation(600, 50);
			ad_View.setVisible(true); // ������ ǥ��
			this.remainderItems(); // �����ڸ�尡 �ٲ��ڸ��� ������ ǥ��
			this.salesStatement();// ����ǥ_��ǰ�̸�_������_�Ǹż���
		} else if (ob == ad_View.bt_mainView) {
			ad_View.setVisible(false); // ������ ����
			m_View.setLocation(600, 50);
			m_View.setVisible(true); // ���� ǥ��
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
	
	private void eventUp(){	//������ �޼ҵ�
		m_View.bt_adminView.addActionListener(this); //���� -> ������ ����
		ad_View.bt_mainView.addActionListener(this); //������ -> ���Ǳ� ����
		
		m_View.bt_menu1.addActionListener(this); //���� -> �޴�1 ��ư
		m_View.bt_menu2.addActionListener(this); //���� -> �޴�2 ��ư
		m_View.bt_menu3.addActionListener(this); //���� -> �޴�3 ��ư
		m_View.bt_menu4.addActionListener(this); //���� -> �޴�4 ��ư
		m_View.bt_menu5.addActionListener(this); //���� -> �޴�5 ��ư
		m_View.bt_menu6.addActionListener(this); //���� -> �޴�6 ��ư
		m_View.bt_final.addActionListener(this); //���� -> ��� ��ư
		m_View.bt_cash.addActionListener(this); //���� -> ���� ��ư
		m_View.bt_card.addActionListener(this); //���� -> ���� ��ư

		//addition
		ad_View.bt_add1.addActionListener(this);//�޴�1 ���� �߰���ư
		ad_View.bt_add2.addActionListener(this);
		ad_View.bt_add3.addActionListener(this);
		ad_View.bt_add4.addActionListener(this);
		ad_View.bt_add5.addActionListener(this);
		ad_View.bt_add6.addActionListener(this);//�޴�6 ���� �߰���ư
		ad_View.bt_minus1.addActionListener(this);//�޴�1 ���� ȸ����ư
		ad_View.bt_minus2.addActionListener(this);
		ad_View.bt_minus3.addActionListener(this);
		ad_View.bt_minus4.addActionListener(this);
		ad_View.bt_minus5.addActionListener(this);
		ad_View.bt_minus6.addActionListener(this);//�޴� 6 ���� ȸ����ư

	
	}// eventUp

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		System.out.println(ob.toString()); //������Ʈ Ȯ��
		this.changeView(ob);
		
		this.selectMenu(ob); //���κ��� �޴� ��ư ����
		this.clearMenu(ob); //���κ��� ��ҹ�ư ����
		this.payCash(ob); //���κ��� ���ݹ�ư ����
		this.payCard(ob); //���κ��� ī���ư ����
	
		Vector<Item> itemV = m.selectitemAll();
		
		if(ob == ad_View.bt_add1){//1�� ������ �߰� ��ư
			
			itemV.get(0).setItemNum(itemV.get(0).getItemNum()+ad_View.scroll_inven1.getValue());
		
		}else if(ob == ad_View.bt_add2){//2�� ������ �߰� ��ư
			
			itemV.get(1).setItemNum(itemV.get(1).getItemNum()+ad_View.scroll_inven2.getValue());
		
		}else if(ob == ad_View.bt_add3){//3�� ������ �߰� ��ư
			
			itemV.get(2).setItemNum(itemV.get(2).getItemNum()+ad_View.scroll_inven3.getValue());
		
		}else if(ob == ad_View.bt_add4){//4�� ������ �߰� ��ư
			
			itemV.get(3).setItemNum(itemV.get(3).getItemNum()+ad_View.scroll_inven4.getValue());
		
		}else if(ob == ad_View.bt_add5){//5�� ������ �߰� ��ư
			
			itemV.get(4).setItemNum(itemV.get(4).getItemNum()+ad_View.scroll_inven5.getValue());
		
		}else if(ob == ad_View.bt_add6){//6�� ������ �߰� ��ư
			
			itemV.get(5).setItemNum(itemV.get(5).getItemNum()+ad_View.scroll_inven6.getValue());
		
		}else if(ob == ad_View.bt_minus1){//1�� ������ ȸ�� ��ư
			
			itemV.get(0).setItemNum(itemV.get(0).getItemNum()-ad_View.scroll_inven1.getValue());
		
		}else if(ob == ad_View.bt_minus2){//2�� ������ ȸ�� ��ư
			
			itemV.get(1).setItemNum(itemV.get(1).getItemNum()-ad_View.scroll_inven2.getValue());
		
		}else if(ob == ad_View.bt_minus3){//3�� ������ ȸ�� ��ư
			
			itemV.get(2).setItemNum(itemV.get(2).getItemNum()-ad_View.scroll_inven3.getValue());
		
		}else if(ob == ad_View.bt_minus4){//4�� ������ ȸ�� ��ư
			
			itemV.get(3).setItemNum(itemV.get(3).getItemNum()-ad_View.scroll_inven4.getValue());
		
		}else if(ob == ad_View.bt_minus5){//5�� ������ ȸ�� ��ư
			
			itemV.get(4).setItemNum(itemV.get(4).getItemNum()-ad_View.scroll_inven5.getValue());
		
		}else if(ob == ad_View.bt_minus6){//6�� ������ ȸ�� ��ư
			
			itemV.get(5).setItemNum(itemV.get(5).getItemNum()-ad_View.scroll_inven6.getValue());
		
		}//������ button �߰�, ����
	}// actionPerformed

	public static void main(String[] args) {
		new Controller();
	}// main
}
