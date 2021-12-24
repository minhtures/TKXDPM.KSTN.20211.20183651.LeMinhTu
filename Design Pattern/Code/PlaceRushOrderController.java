package controller;

import entity.cart.Cart;
import entity.order.Order;
import shippingFee.Calculate1;
import shippingFee.CalculateRushOrder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;

/**
 * This class of UC place rush order in AIMS project
 * @author Le Minh Tú
 */
public class PlaceRushOrderController extends PlaceOrderController{
    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceRushOrderController.class.getName());

    /**
     * calculate Shipping Fee when place rush order
     * @param order
     * @return
     */
    public void validateDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException{
    	ValidateInfo validate = new ValidateInfo();
    	super.validateDeliveryInfo(info);
    	if (validate.validateProvince(info.get("province"))) {
    		throw new InterruptedException("Province not support rush order");
    	}

    }
    
    public int calculateShippingFee(Order order){
    	CalculateRushOrder calculator = new CalculateRushOrder();
    	int fees = calculator.calculateShippingFee(order);
    	LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees: " + fees);
        return fees;
    }
}
