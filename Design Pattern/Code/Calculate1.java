package shippingFee;

import java.util.Random;

import entity.order.Order;

public class Calculate1 implements ShippingFeeCalculator{
	public int calculateShippingFee(Order order) {
		Random rand = new Random();
		int fees;
		double weight =(rand.nextFloat()*10);
		String province = order.getDeliveryInfo().get("province").toString();
		if ( province== "Hà Nội" || province =="Hồ Chí Minh") {
			fees = 22000;
			if (weight >3) {
				fees += Math.floor((weight-3)/0.5)*2500;
			}
		}
		else {
			fees = 30000;
			if (weight >3) {
				fees += Math.floor((weight-0.5)/0.5)*2500;
			}
		}
        return fees;
	}
}
