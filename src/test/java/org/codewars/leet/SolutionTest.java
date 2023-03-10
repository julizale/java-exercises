package org.codewars.leet;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void testLengthOfLongestSubstring() {
        //Given
        Solution solution = new Solution();

        //When & Then
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
        assertEquals(2, solution.lengthOfLongestSubstring("aab"));
        assertEquals(3, solution.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    void testRomanToInt() {
        //Given
        Solution solution = new Solution();

        //When & Then
        assertEquals(3, solution.romanToInt("III"));
        assertEquals(58, solution.romanToInt("LVIII"));
        assertEquals(1994, solution.romanToInt("MCMXCIV"));
        assertEquals(1794, solution.romanToInt("MDCCXCIV"));
    }

    @Test
    void testLongestPalindrome() {
        //Given
        Solution solution = new Solution();

        //When & Then
        assertEquals("bab", solution.longestPalindrome("babad"));
        assertEquals("bb", solution.longestPalindrome("cbbd"));
        assertEquals("ibawpzhrunsgfobmenlqlxnprtgijgbeicsuoihnmcekzmvtffmlpzuwlimuuzjhkzppmpqqrfwyrjrsltkypjpcjffpvhtdiwjdonutobpecsiqubiusvwsyhrddqjeqqpgofifmwvmcdjixjvjxrvyabqaqumfqiiqxizmhzevhxutsbgzcfggyyvolwaxfcpjhfpksxvgyxhddcssnxhygzvmyxrxqizzhpluxkautjmieximoskcffimctsfzgmihtoxkltopwobtfjvjymtuknxmsgevkeklprcaudidywwkfuhtatpeeiewczpwiegmpjquayfleczrvzekikbaeocpcurtxhcsysbbsyschxtrucpcoeabkikezvrzcelfyauqjpmgeiwpzcweieeptathufkwwydiduacrplkekvegsmxnkutmyjvjftbowpotlkxothimgzfstcmiffcksomixeimjtuakxulphzziqxrxymvzgyhxnsscddhxygvxskpfhjpcfxawlovyyggfczgbstuxhvezhmzixqiiqfmuqaqbayvrxjvjxijdcmvwmfifogpqqejqddrhyswvsuibuqiscepbotunodjwidthvpffjcpjpyktlsrjrywfrqqpmppzkhjzuumilwuzplmfftvmzkecmnhiousciebgjigtrpnxlqlnembofgsnurhzpwabi", solution.longestPalindrome("ibawpzhrunsgfobmenlqlxnprtgijgbeicsuoihnmcekzmvtffmlpzuwlimuuzjhkzppmpqqrfwyrjrsltkypjpcjffpvhtdiwjdonutobpecsiqubiusvwsyhrddqjeqqpgofifmwvmcdjixjvjxrvyabqaqumfqiiqxizmhzevhxutsbgzcfggyyvolwaxfcpjhfpksxvgyxhddcssnxhygzvmyxrxqizzhpluxkautjmieximoskcffimctsfzgmihtoxkltopwobtfjvjymtuknxmsgevkeklprcaudidywwkfuhtatpeeiewczpwiegmpjquayfleczrvzekikbaeocpcurtxhcsysbbsyschxtrucpcoeabkikezvrzcelfyauqjpmgeiwpzcweieeptathufkwwydiduacrplkekvegsmxnkutmyjvjftbowpotlkxothimgzfstcmiffcksomixeimjtuakxulphzziqxrxymvzgyhxnsscddhxygvxskpfhjpcfxawlovyyggfczgbstuxhvezhmzixqiiqfmuqaqbayvrxjvjxijdcmvwmfifogpqqejqddrhyswvsuibuqiscepbotunodjwidthvpffjcpjpyktlsrjrywfrqqpmppzkhjzuumilwuzplmfftvmzkecmnhiousciebgjigtrpnxlqlnembofgsnurhzpwabi"));
    }

    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "the_Stealth_Warrior";
        System.out.println("input: "+input);
        assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }
    @Test
    public void testSomeDashLowerStart() {
        //Given
        String input = "the-Stealth-Warrior";
        System.out.println("input: "+input);

        //When & Then
        assertEquals("theStealthWarrior", Solution.toCamelCase(input));
    }

    @Test
    public void testCountLettersInGoodWords() {
        //Given
        Solution solution = new Solution();
        String[] arr = new String[] {"cat","bt","hat","tree"};

        //When & Then
        assertEquals(6, solution.countCharacters(arr, "atach"));
    }

    @Test
    public void testTwoSum() {
        //Given
        Solution solution = new Solution();
        int[] arr1 = new int[] {2,7,11,15};
        int[] arr2 = new int[] {3,2,4};
        int[] arr3 = new int[] {3,3};

        //When & Then
        assertTrue(Arrays.stream(solution.twoSum(arr1, 9)).anyMatch(i -> i == 0)
                && Arrays.stream(solution.twoSum(arr1, 9)).anyMatch(i -> i == 1));
        assertTrue(Arrays.stream(solution.twoSum(arr2, 6)).anyMatch(i -> i == 1)
                && Arrays.stream(solution.twoSum(arr2, 6)).anyMatch(i -> i == 2));
        assertTrue(Arrays.stream(solution.twoSum(arr3, 6)).anyMatch(i -> i == 0)
                && Arrays.stream(solution.twoSum(arr3, 6)).anyMatch(i -> i == 1));
    }


}