package user_data;

import java.util.ArrayList;
import java.util.List;

public class UserHistory {
	private List<String> myCommandHistory;
	
	public UserHistory() {
		myCommandHistory = new ArrayList<String>();
	}
	
	public void add(String s) {
		myCommandHistory.add(s);
	}
}
