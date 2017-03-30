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
	Vector<String> iv;//iv:�޴� ��� �����ϴ� ����, mv:�� ��� �����ϴ� ����

	public Controller() {
		m_View = new MainView();
		ad_View = new AdminView();
		
		m = new Model();
		iv = new Vector<>();
		
		try {
	         BufferedReader ibr = new BufferedReader(new FileReader("data/item.txt"));//�޴����� ���� ������ �����´�.
	         //FileWriter ifw = new FileWriter("data/item.txt");
	         
	         do{
	            String iread = ibr.readLine();//�޴� ������ ���پ� �д´�
	            if(iread==null) break;//���� ������ ���̻� ���� �ʴ´�
	            
	            iv.add(iread);//�ε���1�� itemV���Ϳ� ���ʴ�� �ִ´�

	            if(iv.size()==4){//itemV�� ũ�Ⱑ 4�� �Ǹ�
	            	String itemName = iv.get(0);
	            	int itemPrice = Integer.parseInt(iv.get(1));
	            	int itemNum = Integer.parseInt(iv.get(2));
	            	int itemAcc = Integer.parseInt(iv.get(3));
	            	
	            	Item item = new Item(itemName, itemPrice, itemNum, itemAcc);
	            	
	            	m.insert(item);
	               
	            	iv.removeAllElements();//�ϳ��� �޴� itemV�� �����Ǹ� ��� ���� �ٸ� �޴��� ���� �غ� �Ѵ�.
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
	public void remainderItems(){//�������� ������ ��忡�� ǥ��
		Vector<Item> itemV = m.selectitemAll();
		for(int i=0; i<itemV.size(); i++){
			Item iv = itemV.get(i);
			ad_View.ta_inven_arr[i].setText(""+iv.getItemNum()); 
			ad_View.ta_add_arr[i].setText("��ǰ�̸�"+iv.getItemName()+"\n" +"������"+iv.getItemNum()+"\n" + "�Ǹż���"+iv.getItemAcc()+"\n");
		}
		
	}//remainderItems()

	public void salesStatement(){//1�� ���� 6������ ��ǰ�̸�, ������, �Ǹż��� in ū ȭ��
		Vector<Item> itemV = m.selectitemAll(); 
		for(int  i= 0 ; i< m.itemV.size(); i++){
			
				Item p = m.itemV.get(i);
				ad_View.ta_item.append("��ǰ�̸�"+"\t" +"������"+"\t" + "�Ǹż���\n"); 
				ad_View.ta_item.append(p.getItemName()+"\t" +p.getItemNum() +"\t" + p.getItemAcc()); 
				
				
				System.out.println(p.getItemName()+"\t" +p.getItemNum() +"\t" + p.getItemAcc()); //Debugging
						
		}//for TextArea (1-6)
		
	}//salesStatement()
	
	public void itemView(){ //���Ǳ� ��ǰ�� ���� ǥ�� �޼ҵ�
		Vector<Item> v = m.selectitemAll();
		for(int i=0; i<v.size(); i++){
			Item item = v.get(i);
			m_View.la_menu_arr[i].setText(item.getItemName() + "   " + item.getItemPrice()); 
		}
	}//itemView

	
	public void changeView(Object ob) {
		if (ob == m_View.bt_adminView) {
			m_View.setVisible(false); // ���� ����
			ad_View.setLocation(600, 50);
			ad_View.setVisible(true); // ������ ǥ��
			this.remainderItems(); //�����ڸ�尡 �ٲ��ڸ��� ������ ǥ��
			this.salesStatement();// ����ǥ_��ǰ�̸�_������_�Ǹż���
		} else if (ob == ad_View.bt_mainView) {
			ad_View.setVisible(false); // ������ ����
			m_View.setLocation(600, 50);
			m_View.setVisible(true); // ���� ǥ��
		}
	} // changeView
	
	
	private void selectMenu(Object ob) {
		if (ob == m_View.bt_menu1) {
			this.display();
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
	
	private void eventUp(){	//������ �޼ҵ�
		m_View.bt_adminView.addActionListener(this); //���� -> ������ ����
		ad_View.bt_mainView.addActionListener(this); //������ -> ���Ǳ� ����
		
		m_View.bt_menu1.addActionListener(this); //���� -> �޴�1 ��ư
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
			
			m.itemV.get(0).setItemNum(m.itemV.get(0).getItemNum()+ad_View.scroll_inven1.getValue());
		
		}else if(ob == ad_View.bt_add2){//2�� ������ �߰� ��ư
			
			m.itemV.get(1).setItemNum(m.itemV.get(1).getItemNum()+ad_View.scroll_inven2.getValue());
		
		}else if(ob == ad_View.bt_add3){//3�� ������ �߰� ��ư
			
			m.itemV.get(2).setItemNum(m.itemV.get(2).getItemNum()+ad_View.scroll_inven3.getValue());
		
		}else if(ob == ad_View.bt_add4){//4�� ������ �߰� ��ư
			
			m.itemV.get(3).setItemNum(m.itemV.get(3).getItemNum()+ad_View.scroll_inven4.getValue());
		
		}else if(ob == ad_View.bt_add5){//5�� ������ �߰� ��ư
			
			m.itemV.get(4).setItemNum(m.itemV.get(4).getItemNum()+ad_View.scroll_inven5.getValue());
		
		}else if(ob == ad_View.bt_add6){//6�� ������ �߰� ��ư
			
			m.itemV.get(5).setItemNum(m.itemV.get(5).getItemNum()+ad_View.scroll_inven6.getValue());
		
		}else if(ob == ad_View.bt_minus1){//1�� ������ ȸ�� ��ư
			
			m.itemV.get(0).setItemNum(m.itemV.get(0).getItemNum()-ad_View.scroll_inven1.getValue());
		
		}else if(ob == ad_View.bt_minus2){//2�� ������ ȸ�� ��ư
			
			m.itemV.get(1).setItemNum(m.itemV.get(1).getItemNum()-ad_View.scroll_inven2.getValue());
		
		}else if(ob == ad_View.bt_minus3){//3�� ������ ȸ�� ��ư
			
			m.itemV.get(2).setItemNum(m.itemV.get(2).getItemNum()-ad_View.scroll_inven3.getValue());
		
		}else if(ob == ad_View.bt_minus4){//4�� ������ ȸ�� ��ư
			
			m.itemV.get(3).setItemNum(m.itemV.get(3).getItemNum()-ad_View.scroll_inven4.getValue());
		
		}else if(ob == ad_View.bt_minus5){//5�� ������ ȸ�� ��ư
			
			m.itemV.get(4).setItemNum(m.itemV.get(4).getItemNum()-ad_View.scroll_inven5.getValue());
		
		}else if(ob == ad_View.bt_minus6){//6�� ������ ȸ�� ��ư
			
			m.itemV.get(5).setItemNum(m.itemV.get(5).getItemNum()-ad_View.scroll_inven6.getValue());
		
		}//������ button �߰�, ����
	}// actionPerformed

	public static void main(String[] args) {
		new Controller();
	}// main
}
