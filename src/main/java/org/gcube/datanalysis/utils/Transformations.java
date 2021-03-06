package org.gcube.datanalysis.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transformations {

	public static List<String> parseCVSString(String row, String delimiter) throws Exception {

		List<String> elements = new ArrayList<String>();
		String phrase = row;
		int idxdelim = -1;
		boolean quot = false;
		phrase = phrase.trim();
		while ((idxdelim = phrase.indexOf(delimiter)) >= 0) {
			quot = phrase.startsWith("\"");
			if (quot) {
				phrase = phrase.substring(1);
				String quoted = "";
				if (phrase.startsWith("\""))
					phrase = phrase.substring(1);
				else{
					 Pattern p = Pattern.compile("[^\\\\]\"");
					 Matcher regexp  = p.matcher(phrase);
					 
					boolean matching = regexp.matches();

					if (matching) {
						int i0 = regexp.start(0);
						quoted = phrase.substring(0, i0 + 1).trim();
						phrase = phrase.substring(i0 + 2).trim();
					}
				}

				if (phrase.startsWith(delimiter))
					phrase = phrase.substring(1);

				elements.add(quoted);

			} else {
				elements.add(phrase.substring(0, idxdelim));
				phrase = phrase.substring(idxdelim + 1).trim();
			}
		}
		if (phrase.startsWith("\""))
			phrase = phrase.substring(1);

		if (phrase.endsWith("\""))
			phrase = phrase.substring(0, phrase.length() - 1);

		elements.add(phrase);

		return elements;
	}

}
