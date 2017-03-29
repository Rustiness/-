package com.kosta.p1.javachef.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Model {
	Vector<Item> itemV;
	Vector<Money> moneyV;
	
	Vector<String> V;
	
	Item item;

	public Model() {
		itemV = new Vector<>();
		moneyV = new Vector<>();

		V = new Vector<>();
		
		item = new Item();

		try {
			BufferedReader br = new BufferedReader(new FileReader("item.txt"));//메뉴들의 정보 파일을 가져온다.
			//FileWriter fw = new FileWriter("item.txt");

			do {
				String read = br.readLine();// 파일을 한줄씩 읽는다
				if (read == null)
					break;// 값이 없으면 더이상 읽지 않는다

				String read2[] = read.split("=");// 읽으면 =을 기준으로 값을 나눈다

            V.add(read2[1]);//인덱스1을 itemV벡터에 차례대로 넣는다
            if(V.size()==4){//itemV의 크기가 4가 되면
					for (int i = 0; i < itemV.size(); i++) {
						Item I = itemV.get(i);
					}
					item.setItemName(V.get(0));//itemV의 인덱스0의 값을 itemName으로
					item.setItemPrice(Integer.parseInt(V.get(1)));//itemV의 인덱스1의 값을 itemPrice으로
					item.setItemNum(Integer.parseInt(V.get(2)));//itemV의 인덱스2의 값을 itemNum으로
					item.setItemAcc(Integer.parseInt(V.get(3)));//itemV의 인덱스3의 값을 itemAcc으로

					System.out.println(item.getItemName());
					System.out.println(item.getItemPrice());
					System.out.println(item.getItemNum());
					System.out.println(item.getItemAcc());

					V.removeAllElements();//하나의 메뉴 itemV가 생성되면 모두 지워 다른 메뉴를 넣을 준비를 한다.
				}

			} while (true);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}