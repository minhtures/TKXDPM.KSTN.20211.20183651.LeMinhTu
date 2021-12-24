package shippingFee;

import java.util.Random;

import entity.order.Order;

public class CalculateRushOrder implements ShippingFeeCalculator{
	public int CalculateRushOrder(Order order) {
		Random rand = new Random();
		int fees;
		double weight =(rand.nextFloat()*10);
		String province = order.getDeliveryInfo().get("province").toString();
		fees = 22000;
		if (weight >3) {
			fees += Math.floor((weight-3)/0.5)*2500;
		}
		fees+=10000;
        return fees;
	}
}
