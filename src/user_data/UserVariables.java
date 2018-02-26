package user_data;

import java.util.HashMap;
import java.util.Map;

public class UserVariables {
	private Map<String, Double> myVariables;
	
	public UserVariables() {
		myVariables = new HashMap(); //implementation can be whatever
	}
	
	public void add(String varName, double varVal) {
		myVariables.put(varName, varVal); //I don't think we need if tree because put will just override old vals
	}
}
