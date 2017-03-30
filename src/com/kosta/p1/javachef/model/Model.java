package com.kosta.p1.javachef.model;

import java.util.Vector;

public class Model{
	public Vector<Item> itemV;
	Item it;
	
	public Model() {
		itemV = new Vector<>();

	}

	public void insert(Item item) {
		itemV.add(item);
	}

	public Vector selectitemAll() {
		return itemV;
	}	
	
	public void updateItem(String itemName, int itemAcc, int total){
		
		for(int i=0;i<itemV.size();i++){
			
			it=itemV.get(i);
			     
			  if(itemName.equals(it.getItemName())){
				  
				  
				  it.setItemAcc(it.getItemAcc()+itemAcc);             
				  it.setItemNum(it.getItemNum()-itemAcc);
				  
				  //start();
				  
				  
			  }//if
			
			
		}//for
		
		
	}//updateItem
	
	public static void main(String[] args) {
		new Model();
	}
	
}