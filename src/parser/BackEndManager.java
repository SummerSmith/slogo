package parser;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import nodes.Node;
import turtle.Turtle;

public class BackEndManager {
	
	private String unparsed;
	private List<String> strings;
	private final String file = "resources.nodes/NumArguments";
	private final String path = "resources.languages/";
	private final String syntaxPath = path + "syntax";
	
	private List<Node> toTraverse;
	private List<Node> headNodes;
	
	private List<Entry<String, Pattern>> mySymbols;
	
	private List<Turtle> myTurtles;
	
	private Map<String, Integer> commandArguments;
	private Map<String, String> commandTranslations;
	
	ConstructNodes construct;
	TraverseNodes traverse;
	Executor executor;
	ProcessString process;
	
	public BackEndManager(String commands, String language) {
		myTurtles = new ArrayList<>();
		toTraverse = new ArrayList<>();
		myTurtles = TurtleManager.getActiveTurtles();
		unparsed = commands;
		executor = new Executor();
		process = new ProcessString();
		headNodes = new ArrayList<>();
		makeCommandArgumentsMap();
		makeCommandMap(path + language);
		addPatterns(syntaxPath);
	}

	public void parse() throws Exception {
		strings = process.processString(unparsed);
		construct = new ConstructNodes(strings, mySymbols, commandArguments, commandTranslations);
		toTraverse = construct.createNodeList();
		traverse = new TraverseNodes(toTraverse);
		traverse.createTree(toTraverse.get(0));
		headNodes.addAll(traverse.getTemp());
//		for (Node curr : headNodes) {
//			System.out.println("headnode: " + curr);
//			for (Node child : curr.getChildren()) {
//				System.out.println("child: " + child);
//			}
//		}
		if(!unparsed.startsWith("tell")) {
			for(Turtle t : myTurtles) {
				t.getNextPoints().clear();
				t.addNextPoint(t.getLocation());
				for(Node head : headNodes) {
					traverse.addTurtletoTree(head, t);
				}
				List<Double> res = executor.executeCommands(headNodes);
				//if there are wrong arguments values
				if(res == null) {
					System.out.println("there are wrong arguments values, sop execution.");
					return;
				}
			}
		}
		else {executor.executeCommands(headNodes);}
	}
	
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
	
	private void makeCommandMap(String file) {
		commandTranslations = new HashMap<>();
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
	
    /**
     * Adds the given resource file to this language's recognized types
     */
    private void addPatterns (String syntax) {
    		mySymbols = new ArrayList<>();
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
	
}
