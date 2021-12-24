package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInfo {
	
	public ValidateInfo() {
		
	}
	public boolean validateProvince(String province) {
    	if (province == "Hà Nội" ) return true;
        return false;
    }
	
    public boolean validatePhoneNumber(String phoneNumber) {
    	if (phoneNumber == null ||phoneNumber.length() != 10) return false;
        if (!phoneNumber.startsWith("0")) return false;
        
        try {
        	Integer.parseInt(phoneNumber);
        } catch (Exception e) {
			// TODO: handle exception
        	return false;
		}
        return true;
    }
    
    public boolean validateName(String name) {
    	if (name == null || name.length() == 0) return false;
        String pattern = "[^a-zA-Z\\s]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(name);

        if (m.find()) return false;
    	return true;
    }
    
    public boolean validateAddress(String address) {
    	if (address == null || address.length() == 0) return false;
        String pattern = "[^a-zA-Z0-9\\s,\\./]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(address);

        if (m.find()) return false;
    	return true;
    }
}
