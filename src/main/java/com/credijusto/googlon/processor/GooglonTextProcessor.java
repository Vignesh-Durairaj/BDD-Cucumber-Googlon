package com.credijusto.googlon.processor;

import static com.credijusto.googlon.utils.GooglonUtils.getGooglonMap;
import static com.credijusto.googlon.utils.GooglonUtils.isFooAlphabet;
import static com.credijusto.googlon.utils.IConstants.WHITE_SAPCE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.credijusto.googlon.pojo.GooglonText;
import com.credijusto.googlon.utils.GooglonUtils;

public class GooglonTextProcessor {

	public GooglonText getProcessedText (final String inputString) {
		GooglonText googlonText = new GooglonText();
		googlonText.setGooglonString(inputString);
		
		if (null != inputString) {
			List<String> inputStrList = Arrays.asList(inputString.toLowerCase().trim().split(WHITE_SAPCE));
			List<String> verbsList = inputStrList
					.stream()
					.filter(GooglonUtils::isVerb)
					.collect(Collectors.toList());
			
			googlonText.setPrepositionCount(getPrepositionCount(inputStrList));
			googlonText.setVerbCount(verbsList.size());
			googlonText.setSubjunctivesCount(getSubjunctiveCount(verbsList));
			googlonText.setOrderedVocabularySet(getListItemsAsString(getDistinctVocabulary(inputStrList)));
			googlonText.setPrettyNosCount(getDistinctPrettyNosCount(inputStrList));
		}
		
		return googlonText;
	}
	
	private long getPrepositionCount(final List<String> inputStrList) {
		return inputStrList
				.stream()
				.filter(GooglonUtils::isPreposition)
				.count();
	}
	
	private long getSubjunctiveCount(final List<String> verbsList) {
		return verbsList
				.stream()
				.filter(verb -> !isFooAlphabet(verb.charAt(0)))
				.count();
	}
	
	private List<String> getDistinctVocabulary(final List<String> inputStrList) {
		
		return inputStrList
				.stream()
				.distinct()
				.sorted((s1, s2) -> {

						int indexOne = 0;
						int indexTwo = 0;
						
						for (int i = 0; i < Math.min(s1.length(), s2.length()) && indexOne == indexTwo; i ++) {
							indexOne = getGooglonMap().get(s1.charAt(i));
							indexTwo = getGooglonMap().get(s2.charAt(i));
						}
						
						if (indexOne == indexTwo && s1.length() != s2.length()) {
							return s1.length() - s2.length();
						}
						
						return indexOne - indexTwo;
					})
				.collect(Collectors.toList());
	}
	
	private String getListItemsAsString (final List<String> inputList) {
		return inputList
				.stream()
				.collect(Collectors.joining(WHITE_SAPCE))
				.trim();
	}
	
	private long getDistinctPrettyNosCount (final List<String> inputList) {
		return inputList
				.stream()
				.distinct()
				.mapToLong(GooglonUtils::getGooglonNumber)
				.filter(GooglonUtils::isPrettyNumber)
				.count();
	}
}
