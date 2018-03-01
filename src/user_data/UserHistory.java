package user_data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nodes.Node;

public class UserHistory {
	private static List<String> myCommandHistory;
	
	public UserHistory() {
		myCommandHistory = new ArrayList<String>();
	}
	
	public void add(String s) {
		myCommandHistory.add(s);
	}
	
	public List<String> getHistoryList(){
		return myCommandHistory;
	}
}
