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
	MThread cThread; // ������ ����
	MainView m_View;
	AdminView ad_View;

	Model m;
	MyFile mf;
	int itemCount[] = new int[6];

	Vector<Object> tempV;
	Vector<Item> itemV;
	Vector<Object> v;
	Vector<Vector> accV;// �Ʒ��� ���͸� ���� ����(���� �������� ������������ ����)
	Vector<String> accV2;// ���� ������ �������̸��� ������ ��� ����

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
		
		this.viewItemTable(); // ���̺� ǥ��
		this.itemView(); //��ǰ �� ����
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

	public void remainderItems() {// �������� ������ ��忡�� ǥ��
//		System.out.println("itemV" + itemV);
		for (int i = 0; i < itemV.size(); i++) {
			Item iv = itemV.get(i);
	
			ad_View.ta_add_arr[i].setText("��ǰ�̸�:\n"+iv.getItemName()+ "\n"+"������:"+iv.getItemNum()+"\n" + "�Ǹż���:"+iv.getItemAcc()+"\n");
			}
		
	}//remainderItems()

	public void salesStatement(){//1�� ���� 6������ ��ǰ�̸�, ������, �Ǹż��� in ū ȭ��		
		ad_View.ta_item.setText("           ��"+"��ǰ�̸�"+"  "+ itemV.get(0).getItemName()+"\n"
								+"               "+"�Ǹż���"+"  "+  itemV.get(0).getItemAcc()+"\n"
								+"               "+"�Ǹűݾ�"+"  "+ itemV.get(0).getItemPrice()*itemV.get(0).getItemAcc()+"\n"
								+"\n "
								+"           ��"+"��ǰ�̸�"+"  "+ itemV.get(1).getItemName()+"\n"
								+"               "+"�Ǹż���"+"  "+  itemV.get(1).getItemAcc()+"\n"
								+"               "+"�Ǹűݾ�"+"  "+ itemV.get(1).getItemPrice()*itemV.get(1).getItemAcc()+"\n"
								+"\n "
								+"           ��"+"��ǰ�̸�"+"  "+ itemV.get(2).getItemName()+"\n"
								+"               "+"�Ǹż���"+"  "+  itemV.get(2).getItemAcc()+"\n"
								+"               "+"�Ǹűݾ�"+"  "+ itemV.get(2).getItemPrice()*itemV.get(2).getItemAcc()+"\n"
								+"\n "
								+"           ��"+"��ǰ�̸�"+"  "+ itemV.get(3).getItemName()+"\n"
								+"               "+"�Ǹż���"+"  "+  itemV.get(3).getItemAcc()+"\n"
								+"               "+"�Ǹűݾ�"+"  "+ itemV.get(3).getItemPrice()*itemV.get(3).getItemAcc()+"\n"
								+"\n "
								+"           ��"+"��ǰ�̸�"+"  "+ itemV.get(4).getItemName()+"\n"
								+"               "+"�Ǹż���"+"  "+  itemV.get(4).getItemAcc()+"\n"
								+"               "+"�Ǹűݾ�"+"  "+ itemV.get(4).getItemPrice()*itemV.get(4).getItemAcc()+"\n"
								+"\n "
								+"           ��"+"��ǰ�̸�"+"  "+ itemV.get(5).getItemName()+"\n"
								+"               "+"�Ǹż���"+"  "+  itemV.get(5).getItemAcc()+"\n"
								+"               "+"�Ǹűݾ�"+"  "+ itemV.get(5).getItemPrice()*itemV.get(5).getItemAcc()+"\n"
								+"\n ");
		
	}//salesStatement()
	
	
	public void viewItemTable() { // ��ǰ ���̺� ǥ�� �ʱ�ȭ
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
	
	
	public void selectItem(int number) {// ��ǰ ����
		if (itemV.get(number).getItemNum() - (Integer) m_View.dtm.getValueAt(number, 1) < 1){
				m_View.showMsg("��ǰ ��� �����մϴ�.");
				return;
		}
		
		itemCount[number]++; // ī����
		this.itemView(); //��ǰ �� ����
		v = new Vector<>();
		v.add(itemV.get(number).getItemName());
		v.add(itemCount[number]);
		v.add(itemV.get(number).getItemPrice() * itemCount[number]);
		v.add(String.format("%,d", itemV.get(number).getItemPrice() * itemCount[number]));

		//System.out.println("���� ���� �� : " + tempV.get(number).toString());
		tempV.set(number, v);
		//System.out.println("���� ���� �� : " + tempV.get(number).toString());
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
		
		m_View.bt_cash.setEnabled(true);	//���� ��ư ǥ��
		m_View.bt_card.setEnabled(true);
		m_View.bt_final.setEnabled(true);

	} // selectItem
	
	public void selectTotal(int total) { //���� �� ���� 
		m_View.tf_total.setText("�� ���� : " + String.format("%,d", total) + "��");
	}//selectTotal
	
	public void selectReset() { // ��ǰ ���� ��ü �ʱ�ȭ
		this.itemView(); // ��ǰ �� ����
		m_View.bt_cash.setEnabled(false); // ���� ��ư ����
		m_View.bt_card.setEnabled(false);
		m_View.bt_final.setEnabled(false);
		for (int i = 0; i < tempV.size(); i++) {
			itemCount[i] = 0;
			v = new Vector<>();
			v.add(itemV.get(i).getItemName());
			v.add(0);
			v.add(0);
			tempV.set(0, v);
			//System.out.println("���� �ʱ�ȭ ��: " + tempV.get(0).toString());
			m_View.dtm.removeRow(0);
			m_View.dtm.addRow((Vector) tempV.get(0));
			selectTotal(0);
		}
	} // selectReset
	
	public void itemView() { // ���Ǳ� ��ǰ�� ���� ǥ�� �޼ҵ�
		for (int i = 0; i < itemV.size(); i++) {
			Item item = itemV.get(i);
			m_View.la_menu_arr[i].setText(item.getItemName() + " | " + String.format("%,d", item.getItemPrice()) + "�� | " + item.getItemNum() +"��");
		}
	}// itemView
	
	public void totalView(){  //�Ѹ��� ǥ�� �޼ҵ� in ������
		   int sum=0;
		for(int i =0; i<itemV.size(); i++){
			Item iv = itemV.get(i);
			//salesMoney = iv.getItemAcc()* iv.getItemPrice();
			sum += iv.getItemAcc()* iv.getItemPrice();
			}//for
		//m.t.setTotal(total);
		ad_View.tf_total.setText("�� �����: "+sum+"��");
	}//totalView
	
	public void card(){ //ī�� ����
		int i = m_View.showConfMsg(m_View.tf_total.getText() + " �Դϴ�.\n ī������� �����Ͻðڽ��ϱ�?");
		if(i == 0){
			String str = m_View.tf_total.getText().replaceAll(",", "");
			String str2 = str.substring(7, str.length()-1);
			int total = Integer.parseInt(str2);
			m.t.setTotal(total);
			this.acc();
			this.sendAcc();
			this.selectReset(); // ��ǰ ���� ��ü �ʱ�ȭ
			m_View.showMsg("������ �Ϸ�Ǿ����ϴ�.");
			cThread = new MThread(); // ������ �ʱ�ȭ
			cThread.start(); // ������ ����
		}
		//System.out.println(m.t.getTotal());
	} // card
	
	public void acc() {
		accV2.clear();
		for (int i = 0; i < m_View.dtm.getRowCount(); i++) {
			// System.out.println("���̺����:"+m_View.dtm.getRowCount());

			int ii = (Integer) m_View.dtm.getValueAt(i, 1);
			if (ii > 0) {
				accV2.add(String.valueOf(m_View.dtm.getValueAt(i, 0)));
				//System.out.println("������ �̸�:"+String.valueOf(m_View.dtm.getValueAt(i, 0)));
				accV2.add(String.valueOf(m_View.dtm.getValueAt(i, 1)));
				//System.out.println("������ ����:"+String.valueOf(m_View.dtm.getValueAt(i, 1)));
				accV.add(accV2);
				//System.out.println("acc�� "+String.valueOf(m_View.dtm.getValueAt(i, 0))+"�߰���");
				for(int j=0; j<accV2.size(); j++){
					//System.out.println("accV�� ����"+accV2.get(j));
				}
			}
		}
		//System.out.println("=====================");
	}
	
	public void sendAcc(){ //��ǰ �Ǹ� ���� ���� 
		//System.out.println("accVũ��: "+accV.size());
		//System.out.println(String.valueOf(accV.get(0).get(0)));
		//System.out.println(String.valueOf(accV.get(1).get(0)));
		//System.out.println(String.valueOf(accV.get(2).get(0)));
		//System.out.println(String.valueOf(accV.get(3).get(0)));
		int count=0;
		for(int i=0; i<accV.size(); i++){
			for(int j=count; j<accV2.size(); j++){
				//System.out.println("��ǰ�� : "+String.valueOf(accV.get(i).get(j)));
				//System.out.println("���� : "+String.valueOf(accV.get(i).get(j+1)));
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
			m_View.setVisible(false); // ���� ����
			ad_View.setLocation(180, 20);
			ad_View.setVisible(true); // ������ ǥ��
			this.remainderItems(); // �����ڸ�尡 �ٲ��ڸ��� ������ ǥ��
			this.salesStatement();// ����ǥ_��ǰ�̸�_������_�Ǹż���
			this.totalView();
		} else if (ob == ad_View.bt_mainView) {
			ad_View.setVisible(false); // ������ ����
			m_View.setLocation(180, 20);
			m_View.setVisible(true); // ���� ǥ��
			this.itemView(); // ��ǰ �� ����
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
		//System.out.println(ob.toString()); //������Ʈ Ȯ��
		this.changeView(ob);
		
		this.selectMenu(ob); //���κ��� �޴� ��ư ����
		this.clearMenu(ob); //���κ��� ��ҹ�ư ����
		this.payCash(ob); //���κ��� ���ݹ�ư ����
		this.payCard(ob); //���κ��� ī���ư ����
		
		if (ob == ad_View.bt_add1) {// 1�� ������ �߰� ��ư
			
			if(m.itemV.get(0).getItemNum()+ ad_View.scroll_inven1.getValue() > 200) {
				ad_View.showMsg("��� �ִ������200�� �Դϴ�\n"
						+(200-m.itemV.get(0).getItemNum()+"���� �߰��ϼ���"));
			}else {
				m.itemV.get(0).setItemNum(m.itemV.get(0).getItemNum() + ad_View.scroll_inven1.getValue());
				ad_View.scroll_inven1.setValue(0);	
			}
			remainderItems();
		} else if (ob == ad_View.bt_add2) {// 2�� ������ �߰� ��ư
			
			if(m.itemV.get(1).getItemNum()+ ad_View.scroll_inven2.getValue() > 200) {
				ad_View.showMsg("��� �ִ������200�� �Դϴ�\n"
						+(200-m.itemV.get(1).getItemNum()+"���� �߰��ϼ���"));
			}else {
				m.itemV.get(1).setItemNum(m.itemV.get(1).getItemNum() + ad_View.scroll_inven2.getValue());
				ad_View.scroll_inven2.setValue(0);	
			}
			remainderItems();
		} else if (ob == ad_View.bt_add3) {// 3�� ������ �߰� ��ư
			if(m.itemV.get(2).getItemNum()+ ad_View.scroll_inven3.getValue() > 200) {
				ad_View.showMsg("��� �ִ������200�� �Դϴ�\n"
						+(200-m.itemV.get(2).getItemNum()+"���� �߰��ϼ���"));
			}else {
				m.itemV.get(2).setItemNum(m.itemV.get(2).getItemNum() + ad_View.scroll_inven3.getValue());
				ad_View.scroll_inven3.setValue(0);	
			}
			remainderItems();
			
			
		} else if (ob == ad_View.bt_add4) {// 4�� ������ �߰� ��ư
			if(m.itemV.get(3).getItemNum()+ ad_View.scroll_inven4.getValue() > 200) {
				ad_View.showMsg("��� �ִ������200�� �Դϴ�\n"
						+(200-m.itemV.get(3).getItemNum()+"���� �߰��ϼ���"));
			}else {
				m.itemV.get(3).setItemNum(m.itemV.get(3).getItemNum() + ad_View.scroll_inven4.getValue());
				ad_View.scroll_inven4.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_add5) {// 5�� ������ �߰� ��ư
			if(m.itemV.get(4).getItemNum()+ ad_View.scroll_inven5.getValue() > 200) {
				ad_View.showMsg("��� �ִ������200�� �Դϴ�\n"
						+(200-m.itemV.get(4).getItemNum()+"���� �߰��ϼ���"));
			}else {
				m.itemV.get(4).setItemNum(m.itemV.get(4).getItemNum() + ad_View.scroll_inven5.getValue());
				ad_View.scroll_inven5.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_add6) {// 6�� ������ �߰� ��ư
			if(m.itemV.get(5).getItemNum()+ ad_View.scroll_inven6.getValue() > 200) {
				ad_View.showMsg("��� �ִ������200�� �Դϴ�\n"
						+(200-m.itemV.get(5).getItemNum()+"���� �߰��ϼ���"));
			}else {
				m.itemV.get(5).setItemNum(m.itemV.get(5).getItemNum() + ad_View.scroll_inven6.getValue());
				ad_View.scroll_inven6.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_minus1) {// 1�� ������ ȸ�� ��ư
			if(m.itemV.get(0).getItemNum() - ad_View.scroll_inven1.getValue()<0){
				ad_View.showMsg("��� �ּҼ�����0�� �Դϴ�\n"
						+(m.itemV.get(0).getItemNum()+"������ ȸ�� �����մϴ�"));
			}else {
				m.itemV.get(0).setItemNum(m.itemV.get(0).getItemNum() - ad_View.scroll_inven1.getValue());
				ad_View.scroll_inven1.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_minus2) {// 2�� ������ ȸ�� ��ư
			
			if(m.itemV.get(1).getItemNum() - ad_View.scroll_inven2.getValue()<0){
				ad_View.showMsg("��� �ּҼ�����0�� �Դϴ�\n"
						+(m.itemV.get(1).getItemNum()+"������ ȸ�� �����մϴ�"));
			}else {
				m.itemV.get(1).setItemNum(m.itemV.get(1).getItemNum() - ad_View.scroll_inven2.getValue());
				ad_View.scroll_inven2.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_minus3) {// 3�� ������ ȸ�� ��ư
			
			if(m.itemV.get(2).getItemNum() - ad_View.scroll_inven3.getValue()<0){
				ad_View.showMsg("��� �ּҼ�����0�� �Դϴ�\n"
						+(m.itemV.get(2).getItemNum()+"������ ȸ�� �����մϴ�"));
			}else {
				m.itemV.get(2).setItemNum(m.itemV.get(2).getItemNum() - ad_View.scroll_inven3.getValue());
				ad_View.scroll_inven3.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_minus4) {// 4�� ������ ȸ�� ��ư
			
			if(m.itemV.get(3).getItemNum() - ad_View.scroll_inven4.getValue()<0){
				ad_View.showMsg("��� �ּҼ�����0�� �Դϴ�\n"
						+(m.itemV.get(3).getItemNum()+"������ ȸ�� �����մϴ�"));
			}else {
				m.itemV.get(3).setItemNum(m.itemV.get(3).getItemNum() - ad_View.scroll_inven4.getValue());
				ad_View.scroll_inven4.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_minus5) {// 5�� ������ ȸ�� ��ư
			
			if(m.itemV.get(4).getItemNum() - ad_View.scroll_inven5.getValue()<0){
				ad_View.showMsg("��� �ּҼ�����0�� �Դϴ�\n"
						+(m.itemV.get(4).getItemNum()+"������ ȸ�� �����մϴ�"));
			}else {
				m.itemV.get(4).setItemNum(m.itemV.get(4).getItemNum() - ad_View.scroll_inven5.getValue());
				ad_View.scroll_inven5.setValue(0);	
			}
			remainderItems();
			
		} else if (ob == ad_View.bt_minus6) {// 6�� ������ ȸ�� ��ư
			if(m.itemV.get(5).getItemNum() - ad_View.scroll_inven6.getValue()<0){
				ad_View.showMsg("��� �ּҼ�����0�� �Դϴ�\n"
						+(m.itemV.get(5).getItemNum()+"������ ȸ�� �����մϴ�"));
			}else {
				m.itemV.get(5).setItemNum(m.itemV.get(5).getItemNum() - ad_View.scroll_inven6.getValue());
				ad_View.scroll_inven6.setValue(0);	
			}
			remainderItems();
		}//������ button �߰�, ����
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

	class MThread extends Thread { // ������ Ŭ���� ����
		public void run() { // ������ run �޼ҵ�
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
