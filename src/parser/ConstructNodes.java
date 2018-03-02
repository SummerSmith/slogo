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
import slogo_team12.Display;
import turtle.Turtle;
import error.Error;

public class ConstructNodes {

	private List<String> input;
	private List<Node> nodes;
	private String language;
	private Map<String, String> commandTranslations;
	private List<Entry<String, Pattern>> mySymbols;
	List<Node> headNodes;
	Turtle turtle;
	
	DetermineNodeType determineNodeType;
	TraverseNodes traverse;
	Executor executor;
	private Map<String, Integer> commandArguments;
	private final String path = "resources.languages/";
	private final String file = "resources.nodes/NumArguments";
	private final String syntaxPath = path + "syntax";
	
	
	public ConstructNodes(Turtle t, List<String> strings, String CurrLanguage) throws Exception{
		input = strings;
		turtle = t;
		turtle.getNextPoints().clear();
		turtle.addNextPoint(turtle.getLocation());
		language = CurrLanguage;
		mySymbols = new ArrayList<>();
		commandTranslations = new HashMap<>();
		determineNodeType = new DetermineNodeType();
		nodes = new ArrayList<>();
		headNodes = new ArrayList<>();
		executor = new Executor(); 
		parse();
	}
	
	private void parse() throws Exception{
		try {
			System.out.println("enter parse");
			//clean errors information at the beginning of execution of each commands
			Error.clearString();
			makeCommandArgumentsMap();
			makeCommandMap(path + language);
			addPatterns(syntaxPath);
			int res = createNodeList();
			//if there is an unknown command, stop execution
			if(res == -1) {
				return;
			}
			traverse = new TraverseNodes(turtle, nodes);
			res = traverse.createTree(nodes.get(0));
			//if there is a command which does not have enough argument, stop execution
			if(res == -1) {
				return;
			}
			headNodes.addAll(traverse.getTemp());
	
			for(Node curr : headNodes) {
				//System.out.println("headnode: " + curr);
				for(Node child : curr.getChildren()) {
					//System.out.println("child: " + child);
				}
			}
			//System.out.println("headnodes: " + headNodes);
			executor.executeCommands(headNodes);
		}catch(Exception e) {
			e.printStackTrace();
		}
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
	    	//        return ERROR;
	    	return text; //this is for user defined commands, because they'll be words that don't match with file
    }				//error will have to be returned in another area

	
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
	
	private int createNodeList() throws Exception {
		for(int i = 0; i<input.size(); i++) {
			String identity = getSymbol(input.get(i).toLowerCase());
			if(identity.equalsIgnoreCase("command")) {
				input.set(i, makeEnglish(input.get(i)));
			}
			Node temp = determineNodeType.getNodeType(identity, input.get(i), turtle);
			if(temp == null) {
				return -1;
			}
			addNode(temp);
			if(commandArguments.containsKey(temp.getType())) {
				temp.setNumChildren(commandArguments.get(temp.getType()));
			}
			else {
				temp.setNumChildren(0);
			}
		}
		return 0;
	}
	//does this make a new map from arguments to numArgs every time you run a command? :(
	private void makeCommandArgumentsMap() {
		commandArguments = new HashMap<>();
		ResourceBundle resources = ResourceBundle.getBundle(file);
		Enumeration<String> iter = resources.getKeys();
	    while (iter.hasMoreElements()) {
	            String key = iter.nextElement();
	            String Args = resources.getString(key);
	            int numArgs = Integer.parseInt(Args);
	            	commandArguments.put(key, numArgs);
	    }
	}
	
	protected void addNode(Node toAdd) {
		nodes.add(toAdd);
	}
}
