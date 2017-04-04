package com.kosta.p1.javachef.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.Vector;
import com.kosta.p1.javachef.model.Item;
import com.kosta.p1.javachef.model.Model;
import com.kosta.p1.javachef.model.Total;

public class MyFile {

	Vector<String> iv;
	Model m;

	public MyFile() {
		// iv = new Vector<>();
	}

	public MyFile(Model m) {
		iv = new Vector<>();
		this.m = m;
	}

	public void filereader() {
		try {
			BufferedReader ibr = new BufferedReader(new FileReader("data/item.txt"));// 메뉴들의 정보 파일을 가져온다.
			// FileWriter ifw = new FileWriter("data/item.txt");

			do {
				String iread = ibr.readLine();// 메뉴 파일을 한줄씩 읽는다
	            if(iread==null) break;//값이 없으면 더이상 읽지 않는다

				iv.add(iread);// 인덱스1을 itemV벡터에 차례대로 넣는다

				if (iv.size() == 4) {// itemV의 크기가 4가 되면
					String itemName = iv.get(0);
					int itemPrice = Integer.parseInt(iv.get(1));
					int itemNum = Integer.parseInt(iv.get(2));
					int itemAcc = Integer.parseInt(iv.get(3));

					Item item = new Item(itemName, itemPrice, itemNum, itemAcc);

					m.insertitem(item);

					iv.removeAllElements();// 하나의 메뉴 itemV가 생성되면 모두 지워 다른 메뉴를 넣을 준비를 한다.
				}

			} while (true);

			Vector<Item> ii = m.selectitemAll();
			for (int i = 0; i < ii.size(); i++) {
				Item p = ii.get(i);
				System.out.print(p.getItemName() + " ");
				System.out.print(p.getItemPrice() + " ");
				System.out.print(p.getItemNum() + " ");
				System.out.print(p.getItemAcc() + "\n");
			}

			ibr.close();

			// total읽기 시작
			BufferedReader tbr = new BufferedReader(new FileReader("data/total.txt"));

			int total = Integer.parseInt(tbr.readLine());

			m.inserttotal(total);

			tbr.close();

		} catch (IOException e) {
			e.printStackTrace();
		} // catch
	}// filereader

	public void filewrite() {
		try {

			FileWriter fw = new FileWriter("data/item.txt");

			String name1 = m.itemV.get(0).getItemName() + "\n";
			String price1 = m.itemV.get(0).getItemPrice() + "\n";
			String num1 = m.itemV.get(0).getItemNum() + "\n";
			String acc1 = m.itemV.get(0).getItemAcc() + "\n";

			String name2 = m.itemV.get(1).getItemName() + "\n";
			String price2 = m.itemV.get(1).getItemPrice() + "\n";
			String num2 = m.itemV.get(1).getItemNum() + "\n";
			String acc2 = m.itemV.get(1).getItemAcc() + "\n";

			String name3 = m.itemV.get(2).getItemName() + "\n";
			String price3 = m.itemV.get(2).getItemPrice() + "\n";
			String num3 = m.itemV.get(2).getItemNum() + "\n";
			String acc3 = m.itemV.get(2).getItemAcc() + "\n";

			String name4 = m.itemV.get(3).getItemName() + "\n";
			String price4 = m.itemV.get(3).getItemPrice() + "\n";
			String num4 = m.itemV.get(3).getItemNum() + "\n";
			String acc4 = m.itemV.get(3).getItemAcc() + "\n";

			String name5 = m.itemV.get(4).getItemName() + "\n";
			String price5 = m.itemV.get(4).getItemPrice() + "\n";
			String num5 = m.itemV.get(4).getItemNum() + "\n";
			String acc5 = m.itemV.get(4).getItemAcc() + "\n";

			String name6 = m.itemV.get(5).getItemName() + "\n";
			String price6 = m.itemV.get(5).getItemPrice() + "\n";
			String num6 = m.itemV.get(5).getItemNum() + "\n";
			String acc6 = m.itemV.get(5).getItemAcc() + "\n";

			fw.write(name1);
			fw.write(price1);
			fw.write(num1);
			fw.write(acc1);

			fw.write(name2);
			fw.write(price2);
			fw.write(num2);
			fw.write(acc2);

			fw.write(name3);
			fw.write(price3);
			fw.write(num3);
			fw.write(acc3);

			fw.write(name4);
			fw.write(price4);
			fw.write(num4);
			fw.write(acc4);

			fw.write(name5);
			fw.write(price5);
			fw.write(num5);
			fw.write(acc5);

			fw.write(name6);
			fw.write(price6);
			fw.write(num6);
			fw.write(acc6);

			fw.close();

			FileWriter bw = new FileWriter("data/total.txt");

			// total쓰기 시작
			// System.out.println(m.t.getTotal());
			String total = m.t.getTotal() + "";
			bw.write(total);

			bw.close();

		} catch (IOException e) {

			// e.printStackTrace();
		}

	}// filewrite

}// class
