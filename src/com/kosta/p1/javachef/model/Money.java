package com.kosta.p1.javachef.model;

public class Money {
	private int manwon_num; // ¸¸¿ø °¹¼ö
	private int ohchunwon_num; // ¿ÀÃµ¿ø °¹¼ö
	private int chunwon_num; // Ãµ¿ø °¹¼ö
	private int ohbaekwon_num; // ¿À¹é¿ø °¹¼ö

<<<<<<< HEAD
   public Money() {
   }
   
   public Money(int manwon_num, int ohchunwon_num, int chunwon_num, int ohbaekwon_num){
	   this.manwon_num = manwon_num;
	   this.ohchunwon_num = ohchunwon_num;
	   this.chunwon_num = chunwon_num;
	   this.ohbaekwon_num = ohbaekwon_num;
   }
	
=======
	public Money() {
	}
>>>>>>> a9283a358bd5584a3e6f47885517a014dcf35a46

	public int getManwon_num() {
		return manwon_num;
	}

	public void setManwon_num(int manwon_num) {
		this.manwon_num = manwon_num;
	}

	public int getOhchunwon_num() {
		return ohchunwon_num;
	}

	public void setOhchunwon_num(int ohchunwon_num) {
		this.ohchunwon_num = ohchunwon_num;
	}

	public int getChunwon_num() {
		return chunwon_num;
	}

	public void setChunwon_num(int chunwon_num) {
		this.chunwon_num = chunwon_num;
	}

	public int getOhbaekwon_num() {
		return ohbaekwon_num;
	}

	public void setOhbaekwon_num(int ohbaekwon_num) {
		this.ohbaekwon_num = ohbaekwon_num;
	}

}