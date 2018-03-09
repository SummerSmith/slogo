package user_data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nodes.Node;

public class UserVariables {
	private static Map<String, Double> myVariables;
	
	public UserVariables() {
		myVariables = new HashMap<>(); //implementation can be whatever
	}
	
	public static double add(String varName, double varVal) {
		System.out.println("varName: " + varName + " varVal: " + varVal);
		myVariables.put(varName, varVal); //I don't think we need if tree because put will just override old vals
		return varVal;
	}
	
	public static double get(String varName) {
		if(myVariables.containsKey(varName)) {
				return myVariables.get(varName);
		}
		else {
			return 0;
		}
	}
	
	public static Map<String, Double> getVariablesMap(){
		return myVariables;
	}
}
