package com.kosta.p1.javachef.model;

import java.util.Vector;

public class Model {
	Vector<Item> itemV;
	Vector<Money> moneyV;

	public Model() {
		itemV = new Vector<>();
		moneyV = new Vector<>();

	}
   public void insert(Item item){
	   itemV.add(item);
   }
	   public Vector selectitemAll(){
		return itemV;
   }
   
   public void insert(Money money){
	   moneyV.add(money);
   }
   
   public Vector selectmoneyAll(){
		return moneyV;
  }
}