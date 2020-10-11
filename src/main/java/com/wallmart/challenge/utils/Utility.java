package com.wallmart.challenge.utils;

public class Utility {

    private Utility() {

    }

    /**
     * Checks if is palindrome.
     *
     * @param word the word
     * @return true, if is palindrome
     */
    public static boolean isPalindrome(String word) {
	boolean result = false;
	int n = word.length();
	for (int i = 0; i < n / 2; i++) {
	    if (word.charAt(i) != word.charAt(n - 1 - i)) {
		result = false;
	    } else {
		result = true;
	    }
	}
	return result;
    }
}
