package com.kosta.p1.javachef.model;

public class Item {// 자바빈즈
	private String itemName; // 상품명
	private int itemPrice; // 판매가
	private int itemNum; // 수량
	private int itemAcc; // 누적판매수량

	public Item() {

   }
   
   public Item(String itemName, int itemPrice, int itemNum, int itemAcc){
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

	public static void main(String[] args) {
		new Item();
	}
}