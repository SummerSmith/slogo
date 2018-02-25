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

public class ConstructNodes {

	private List<String> input;
	private List<Node> nodes;
	private String language;
	private Map<String, String> commandTranslations;
	private List<Entry<String, Pattern>> mySymbols;
	
	private final String path = "resources.languages/";
	private final String syntaxPath = path + "syntax";
	
	
	public ConstructNodes(List<String> strings, String CurrLanguage) {
		input = strings;
		language = CurrLanguage;
		mySymbols = new ArrayList<>();
		commandTranslations = new HashMap<>();
		makeCommandMap(path + language);
		addPatterns(syntaxPath);
		createNodeList();
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
	            String[] notEnglish = translated.split("|");
	            for(int i = 0; i<notEnglish.length; i++) {
	            		commandTranslations.put(notEnglish[i].toLowerCase(), key.toLowerCase());
	            }
	    }

	}
	
	private String makeEnglish(String notEnglish) {
		if(commandTranslations.keySet().contains(notEnglish)) {
			return commandTranslations.get(notEnglish);
		}
		else {
			//FIXME: throw invalid command error
			return "invalid command";
		}
	}
	
	private void createNodeList() {
		for(int i = 0; i<input.size(); i++) {
			String identity = getSymbol(input.get(i).toLowerCase());
			System.out.println(identity);
		}
	}
}
