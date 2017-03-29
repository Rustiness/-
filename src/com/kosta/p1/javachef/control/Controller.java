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

public class Controller  extends Thread implements ActionListener {
	MainView m_View;
	AdminView ad_View;
	
	Model m;
	Vector<String> iv, mv;//iv:�޴� ��� �����ϴ� ����, mv:�� ��� �����ϴ� ����

	public Controller() {
		m_View = new MainView();
		ad_View = new AdminView();
		
		m = new Model();
		iv = new Vector<>();
		mv = new Vector<>();
		
		start();
		
		this.eventUp();
	}
	
	public void run(){
		try {
	         BufferedReader ibr = new BufferedReader(new FileReader("data/item.txt"));//�޴����� ���� ������ �����´�.
	         //FileWriter fw = new FileWriter("item.txt");
	         
	         do{
	            String iread = ibr.readLine();//�޴� ������ ���پ� �д´�
	            if(iread==null) break;//���� ������ ���̻� ���� �ʴ´�
	            
	            String iread2[] = iread.split("=");//������ =�� �������� ���� ������
	            
	            iv.add(iread2[1]);//�ε���1�� itemV���Ϳ� ���ʴ�� �ִ´�

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
	         
	         this.itemView(); //���Ǳ� ��ǰ���� ǥ��	         
	            
	         BufferedReader mbr = new BufferedReader(new FileReader("data/money.txt"));//���� ���� ����(���� ����)�� �����´�.

	         do{
	            String mread = mbr.readLine();//�� ������ ���پ� �д´�
	            if(mread==null) break;//���� ������ ���̻� ���� �ʴ´�
	            
	            String mread2[] = mread.split("=");//������ =�� �������� ���� ������
	            
	            mv.add(mread2[1]);//�ε���1�� itemV���Ϳ� ���ʴ�� �ִ´�

	            if(mv.size()==4){//itemV�� ũ�Ⱑ 4�� �Ǹ�
	            	int manwon_num = Integer.parseInt(mv.get(0));
	            	int ohchunwon_num = Integer.parseInt(mv.get(1));
	            	int chunwon_num = Integer.parseInt(mv.get(2));
	            	int ohbaekwon_num = Integer.parseInt(mv.get(3));
	            	//int 
	            	
	            	Money money = new Money(manwon_num, ohchunwon_num, chunwon_num, ohbaekwon_num);
	            	
	            	m.insert(money);
	               
	            	mv.removeAllElements();//�ϳ��� �޴� itemV�� �����Ǹ� ��� ���� �ٸ� �޴��� ���� �غ� �Ѵ�.
	            }
	            
	         }while(true);
	         
	         Vector<Money> iii = m.selectmoneyAll();
	            for(int i=0; i<iii.size(); i++){
	    			Money p = iii.get(i);
//	    			System.out.print(p.getManwon_num()+" ");
//	    			System.out.print(p.getOhchunwon_num()+" ");
//	    			System.out.print(p.getChunwon_num()+" ");
//	    			System.out.print(p.getOhbaekwon_num()+"\n");
	    		}

	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	}
	
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
		} else if (ob == ad_View.bt_mainView) {
			ad_View.setVisible(false); // ������ ����
			m_View.setLocation(600, 50);
			m_View.setVisible(true); // ���� ǥ��
		}
	} // changeView

	private void eventUp(){	//������ �޼ҵ�
		m_View.bt_adminView.addActionListener(this); //���� -> ������ ����
		ad_View.bt_mainView.addActionListener(this); //������ -> ���Ǳ� ����
	}// eventUp

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		System.out.println(ob.toString()); //������Ʈ Ȯ��
		this.changeView(ob);
	}// actionPerformed

	public static void main(String[] args) {
		new Controller();
	}// main
}
