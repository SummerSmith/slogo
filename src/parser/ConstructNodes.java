package parser;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

import nodes.Node;
import turtle.Turtle;

public class ConstructNodes {

	private List<String> input;
	private List<Node> nodes;
	private String language;
	private Map<String, String> commandTranslations;
	private List<Entry<String, Pattern>> mySymbols;
	List<Node> headNodes;
	
	DetermineNodeType determineNodeType;
	TraverseNodes traverse;
	private Map<String, Integer> commandArguments;
	private final String path = "resources.languages/";
	private final String file = "resources.nodes/NumArguments";
	private final String syntaxPath = path + "syntax";
	
	
	public ConstructNodes(Turtle t, List<String> strings, String CurrLanguage) throws Exception {
		input = strings;
		language = CurrLanguage;
		mySymbols = new ArrayList<>();
		commandTranslations = new HashMap<>();
		determineNodeType = new DetermineNodeType();
		nodes = new ArrayList<>();
		headNodes = new ArrayList<>();
		parse();
		traverse = new TraverseNodes(t, nodes);
		headNodes.add(nodes.get(0));
	}
	
	private void parse() throws Exception {
		makeCommandArgumentsMap();
		makeCommandMap(path + language);
		addPatterns(syntaxPath);
		createNodeList();
		System.out.println(nodes);
		headNodes.addAll(traverse.createTree(nodes.get(0), 0));
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
                return e.getKey();
            }
        }
        // FIXME: perhaps throw an exception instead
        return ERROR;
    }

	
    /**
     * Adds the given resource file to this language's recognized types
     */
    private void addPatterns (String syntax) {
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement();
            String regex = resources.getString(key);
            mySymbols.add(new SimpleEntry<>(key,
                           // THIS IS THE IMPORTANT LINE
                           Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
    }
    
	private void makeCommandMap(String file) {
		ResourceBundle resources = ResourceBundle.getBundle(file);
		Enumeration<String> iter = resources.getKeys();
	    while (iter.hasMoreElements()) {
	            String key = iter.nextElement();
	            String translated = resources.getString(key);
	            String notEnglish[] = translated.split("\\|");
	            for(int i = 0; i<notEnglish.length; i++) {
	            		commandTranslations.put(notEnglish[i].toLowerCase(), key);
	            }
	    }
	}
	
	private String makeEnglish(String notEnglish) {
		return commandTranslations.get(notEnglish);
	}
	
	private void createNodeList() throws Exception {
		System.out.println(input);
		for(int i = 0; i<input.size(); i++) {
			String identity = getSymbol(input.get(i).toLowerCase());
			if(identity.equalsIgnoreCase("command")) {
				input.set(i, makeEnglish(input.get(i)));
			}
			Node temp = determineNodeType.nodeType(identity, input.get(i));
			addNode(temp);
			System.out.println(temp.getType());
			if(commandArguments.containsKey(temp.getType())) {
				temp.setNumChildren(commandArguments.get(temp.getType()));
			}
			else {
				temp.setNumChildren(0);
			}
		}
	}
	
	private void makeCommandArgumentsMap() {
		commandArguments = new HashMap<>();
		ResourceBundle resources = ResourceBundle.getBundle(file);
		Enumeration<String> iter = resources.getKeys();
	    while (iter.hasMoreElements()) {
	            String key = iter.nextElement();
	            System.out.print(key);
	            String Args = resources.getString(key);
	            System.out.println(Args);
	            int numArgs = Integer.parseInt(Args);
	            	commandArguments.put(key, numArgs);
	    }
	}
	
	protected void addNode(Node toAdd) {
		nodes.add(toAdd);
	}
}
