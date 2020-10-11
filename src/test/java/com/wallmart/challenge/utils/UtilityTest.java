package com.wallmart.challenge.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class UtilityTest {
    
    
    @Test
    public void isPalindromoTest() {
	boolean result = Utility.isPalindrome("121");
	assertThat(result).isTrue();
    }
    
    @Test
    public void isPalindromoTest2() {
	boolean result = Utility.isPalindrome("assadf");
	assertThat(result).isFalse();
    }

}
