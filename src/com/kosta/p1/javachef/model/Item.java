package com.kosta.p1.javachef.model;

public class Item {// �ڹٺ���
	private String itemName; // ��ǰ��
	private int itemPrice; // �ǸŰ�
	private int itemNum; // ����
	private int itemAcc; // �����Ǹż���

	public Item() {

	}

	public Item(String itemName, int itemPrice, int itemNum, int itemAcc) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemNum = itemNum;
		this.itemAcc = itemAcc;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public int getItemAcc() {
		return itemAcc;
	}

	public void setItemAcc(int itemAcc) {
		this.itemAcc = itemAcc;
	}
	
}