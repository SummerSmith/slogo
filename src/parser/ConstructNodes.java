package parser;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.ArrayList;

import nodes.Node;

public class ConstructNodes {

	private List<String> input;
	private List<Node> nodes;
	List<Node> headNodes;
	
	DetermineNodeType determineNodeType;
	
	private List<Entry<String, Pattern>> mySymbols;
	private Map<String, Integer> commandArguments;
	private Map<String, String> commandTranslations;
	
	
	public ConstructNodes(List<String> strings, List<Entry<String, Pattern>> symbols, Map<String, Integer> args, Map<String, String> translations) throws Exception{
		input = strings;
		mySymbols = symbols;
		commandArguments = args;
		commandTranslations = translations;
		determineNodeType = new DetermineNodeType();
		nodes = new ArrayList<>();
		headNodes = new ArrayList<>();
	}
	
	protected List<Node> getHeadNodes(){
		return headNodes;
	}
	
	 /**
     * Returns true if the given text matches the given regular expression pattern
     */
    private boolean match (String text, Pattern regex) {
        // THIS IS THE KEY LINE
        return regex.matcher(text).matches();
    }

	
    /**
     * Returns language's type associated with the given text if one exists 
     */
    public String getSymbol (String text) {
	    	final String ERROR = "NO MATCH";
	    	for (Entry<String, Pattern> e : mySymbols) {
	    		if (match(text, e.getValue())) {
//	    			System.out.println("Key: " + e.getKey());
	    			return e.getKey();
	    		}
	    	}
	    	// FIXME: perhaps throw an exception instead
	    	//        return ERROR;
	    	return ERROR; //if you click run without any commands it stores it in the user history
    }				

	
	private String makeEnglish(String notEnglish) {
		if(commandTranslations.containsKey(notEnglish)) {
			return commandTranslations.get(notEnglish);
		}
		else {
			return notEnglish;
		}
	}
	
	protected List<Node> createNodeList() throws Exception {
		for(int i = 0; i<input.size(); i++) {
			String identity = getSymbol(input.get(i).toLowerCase());
			if(identity.equalsIgnoreCase("command")) {
				input.set(i, makeEnglish(input.get(i).toLowerCase()));
			}
			Node temp = determineNodeType.getNodeType(identity, input.get(i));
			addNode(temp);
			if(commandArguments.containsKey(temp.getType())) {
//				System.out.println("numchildren before:" + temp.getNumChildren());
				temp.setNumChildren(commandArguments.get(temp.getType()));
//				System.out.println("numchildren after:" + temp.getNumChildren());
			}
		}
		return nodes;
	}

	
	protected void addNode(Node toAdd) {
		nodes.add(toAdd);
	}
}
