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
			BufferedReader br = new BufferedReader(new FileReader("item.txt"));//�޴����� ���� ������ �����´�.
			//FileWriter fw = new FileWriter("item.txt");

			do {
				String read = br.readLine();// ������ ���پ� �д´�
				if (read == null)
					break;// ���� ������ ���̻� ���� �ʴ´�

				String read2[] = read.split("=");// ������ =�� �������� ���� ������

            V.add(read2[1]);//�ε���1�� itemV���Ϳ� ���ʴ�� �ִ´�
            if(V.size()==4){//itemV�� ũ�Ⱑ 4�� �Ǹ�
					for (int i = 0; i < itemV.size(); i++) {
						Item I = itemV.get(i);
					}
					item.setItemName(V.get(0));//itemV�� �ε���0�� ���� itemName����
					item.setItemPrice(Integer.parseInt(V.get(1)));//itemV�� �ε���1�� ���� itemPrice����
					item.setItemNum(Integer.parseInt(V.get(2)));//itemV�� �ε���2�� ���� itemNum����
					item.setItemAcc(Integer.parseInt(V.get(3)));//itemV�� �ε���3�� ���� itemAcc����

					System.out.println(item.getItemName());
					System.out.println(item.getItemPrice());
					System.out.println(item.getItemNum());
					System.out.println(item.getItemAcc());

					V.removeAllElements();//�ϳ��� �޴� itemV�� �����Ǹ� ��� ���� �ٸ� �޴��� ���� �غ� �Ѵ�.
				}

			} while (true);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}