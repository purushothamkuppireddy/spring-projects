package com.capg.restuarent;

public class Restuarent {

	IHotDrink hotDrink;
	

	public Restuarent(IHotDrink hotDrink) {
		
		this.hotDrink = hotDrink;
	}

	public void SethotDrink(IHotDrink hotDrink) {
		this.hotDrink=hotDrink;
	}
	
	public void display() {
		hotDrink.prepareHotDrink();
		
	}
	
	
}
