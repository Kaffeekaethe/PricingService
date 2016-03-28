package com.db.systel.bachelorproject2016.pricingservice.domainmodel;

public class PriceCalculator {

	public static float calculatePrice(Seat seat) {
		
		float price = 0.0f;
		if (seat.getSeatClass() == 2) {
			price = 4.5f;
		}
		
		return price;
	}
}
