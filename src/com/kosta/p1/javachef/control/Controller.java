package com.kosta.p1.javachef.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.kosta.p1.javachef.view.AdminView;
import com.kosta.p1.javachef.view.MainView;

public class Controller implements ActionListener {
	MainView m_View;
	AdminView ad_View;
	
	JButton bt_default;
	JTextField tf_num;
	JLabel la_default;

	public Controller() {
		m_View = new MainView();
		ad_View = new AdminView();
		
		this.eventUp();
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
