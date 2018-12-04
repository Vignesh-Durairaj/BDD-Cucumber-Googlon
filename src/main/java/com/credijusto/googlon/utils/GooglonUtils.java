package com.credijusto.googlon.utils;

import static com.credijusto.googlon.utils.IConstants.FOO_ALPHABETS;
import static com.credijusto.googlon.utils.IConstants.GOOGLON_ALPHABETS;
import static com.credijusto.googlon.utils.IConstants.PREPOSITION_FILTER;
import static com.credijusto.googlon.utils.IConstants.PRETTY_NUMBER_DIVISOR;
import static com.credijusto.googlon.utils.IConstants.PRETTY_NUMBER_THRESHOLD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GooglonUtils {

	private static Map<Character, Integer> googlonMap = new HashMap<> ();
	private static Long googlonNumber;
	
	static {
		googlonMap = IntStream
				.range(0, GOOGLON_ALPHABETS.length)
				.boxed()
				.collect(Collectors.toMap(i -> GOOGLON_ALPHABETS[i], Integer::valueOf));
	}
	
	private GooglonUtils() {
		// To prevent invoking the static utility class anywhere.
	}
	
	public static Boolean isFooAlphabet (final Character c) {
		return (Arrays.stream(FOO_ALPHABETS).anyMatch(c::equals));
	}
	
	public static Boolean isPreposition (final String inWord) {
		return (inWord.length() == 6 
				&& isFooAlphabet(inWord.charAt(inWord.length() - 1))
				&& !inWord.contains(PREPOSITION_FILTER));
	}
	
	public static Boolean isVerb (final String inWord) {
		return (inWord.length() >= 6
				&& !isFooAlphabet(inWord.charAt(inWord.length() - 1)));
	}
	
	public static Long getGooglonNumber (final String inWord) {
		googlonNumber = 0L;
		char[] charArray = inWord.toCharArray();
		
		IntStream
			.range(0, inWord.length())
			.forEach(i -> googlonNumber = googlonNumber + ((long)Math.pow(20, i) * googlonMap.get(charArray[i])));
		
		return googlonNumber;
	}
	
	public static Boolean isPrettyNumber (final Long number) {
		return (number >= PRETTY_NUMBER_THRESHOLD && number%PRETTY_NUMBER_DIVISOR == 0);
	}
	
	public static Map<Character, Integer> getGooglonMap () {
		return googlonMap;
	}
}
