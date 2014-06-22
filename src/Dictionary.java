import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	String type;
	String text;
	String[] dictionary;

	public Dictionary(String type, String text) {
		this.type = type;
		this.text = text.toLowerCase();
	}

	public String translateSentence() {
		String[] split = text.split(" ");
		StringBuilder builder = new StringBuilder();
		
		for (String current : split)
			builder.append(getTranslation(current, type) + " ");
		
		return builder.toString();
	}

	public void populateDictionary() {
		if (dictionary == null) {	
			try {
				InputStream location = Dictionary.class.getClassLoader().getResourceAsStream("language.txt");
				Scanner sc = new Scanner(location);
				ArrayList<String> dict = new ArrayList<String>();
				
				while (sc.hasNextLine())
					dict.add(sc.nextLine().toLowerCase());
				
				dictionary = new String[dict.size()];
				for (int i = 0; i < dict.size(); i ++) 
					dictionary[i] = dict.get(i);
				
				sc.close();
			} catch (Exception e) {
				System.out.println("Error occured while reading: " + e);
			}
		}
	}
	
	public String getTranslation(String language, String type) {
		populateDictionary();
		
		for (int i = 0; i < dictionary.length; i ++) {
			if (dictionary[i].contains(language)) {
				String full = dictionary[i];
				int location = full.indexOf("=");
				
				if (type.equals("TOENG"))
					return full.substring(0, location);
				else
					return full.substring(location + 1, full.length());
			}
		}
		
		return language;
	}
}
