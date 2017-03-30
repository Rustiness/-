package com.kosta.p1.javachef.model;

import java.util.Vector;

import com.kosta.p1.javachef.control.MyFile;

public class Model{
	public Vector<Item> itemV;
	Item it;
	public Total t;
	
	public Model() {
		itemV = new Vector<>();

	}
	
	public void inserttotal(int total){
		t = new Total(total);
		System.out.println(t.getTotal());
	}

	public void insertitem(Item item) {
		itemV.add(item);
	}

	public Vector selectitemAll() {
		return itemV;
	}	
	
	public void updateItem(String itemName, int itemAcc){
		
		for(int i=0;i<itemV.size();i++){
			
			it=itemV.get(i);
			     
			  if(it.getItemName().equals(itemName)){
				  it.setItemNum(it.getItemNum()-itemAcc);
				  it.setItemAcc(it.getItemAcc()+itemAcc);  
				  
			  }//if			
		}//for
	}//updateItem
	

}