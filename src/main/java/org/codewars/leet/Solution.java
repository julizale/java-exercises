package org.codewars.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= numRows; i++) {
            result.append(s.charAt(i-1));
            int j = 0;
            while (numRows + j*(numRows - i - 1) < s.length()) {
                result.append(s.charAt(numRows + j * (numRows - i - 1)));
                j++;
            }
        }
        return result.toString();
    }

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int minVal = nums.length / 3;
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > minVal) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if (goal.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    public int lengthOfLongestSubstring(String s) {
        StringBuilder sub = new StringBuilder();
        String longestSub = "";
        for (int i = 0; i < s.length(); i++) {
            if (sub.toString().indexOf(s.charAt(i)) == -1) {
                sub.append(s.charAt(i));
            } else {
                if (sub.length() > longestSub.length()) {
                    longestSub = sub.toString();
                }
                i -= sub.length() - sub.toString().indexOf(s.charAt(i));
                sub = new StringBuilder();
            }
        }
        if (sub.length() > longestSub.length()) {
            longestSub = sub.toString();
        }
        return longestSub.length();
    }

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                if (i < s.length() - 1 && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
                    result -= 1;
                } else {
                    result += 1;
                }
            }
            if (s.charAt(i) == 'V') {
                result += 5;
            }
            if (s.charAt(i) == 'X') {
                if (i < s.length() - 1 && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
                    result -= 10;
                } else {
                    result += 10;
                }
            }
            if (s.charAt(i) == 'L') {
                result += 50;
            }
            if (s.charAt(i) == 'C') {
                if (i < s.length() - 1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
                    result -= 100;
                } else {
                    result += 100;
                }
            }
            if (s.charAt(i) == 'D') {
                result += 500;
            }
            if (s.charAt(i) == 'M') {
                result += 1000;
            }
        }
        return result;
    }

    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i < longest.length()) {
                break;
            }
            for (int j = s.length(); j >= i; j--) {
                if (j - i < longest.length()) {
                    break;
                }
                if (isPalindrome(s, i, j)) {
                    if (j - i > longest.length()) {
                        longest = s.substring(i, j);
                    }
                    break;
                }
//                Approach above faster than below, cos of not creating substring in every test for palindrome

//                String sub = s.substring(i,j);
//                if (sub.equals(new StringBuilder(sub).reverse().toString())) {
//                    if (sub.length() > longest.length()) {
//                        longest = sub;
//                    }
//                    break;
//                }
            }
        }
        return longest;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end-1)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static String toCamelCase(String s){
        String[] words;
        if (s.indexOf('-') != -1) {
            words = s.split("-");
        } else if (s.indexOf('_') != -1) {
            words = s.split("_");
        } else {
            return s;
        }
        StringBuilder result = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++) {
            result.append(Character.toUpperCase(words[i].charAt(0)));
            result.append(words[i].substring(1));
        }
        return result.toString();
    }

    public int countCharacters(String[] words, String chars) {
        List<String> goodWords = new ArrayList<>();
        for (String word: words) {
            List<Character> characters = new ArrayList<>();
            for (char ch: chars.toCharArray()) {
                characters.add(ch);
            }
            boolean good = true;
            for (int i = 0; i < word.length(); i++) {
                if (characters.contains(word.charAt(i))) {
                    characters.remove((Character)word.charAt(i));
                } else {
                    good = false;
                    break;
                }
            }
            if (good) {
                goodWords.add(word);
            }
        }
        return sumLetters(goodWords);
    }

    private int sumLetters(List<String> words) {
        int result = 0;
        for (String word : words) {
            result += word.length();
        }
        return result;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String longest = "";
        for (int i = 1; i <= strs[0].length(); i++) {
            String prefix = strs[0].substring(0,i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < prefix.length()) {
                    return longest;
                }
                if (prefix.equals(strs[j].substring(0,i))) {
                    if (j == strs.length - 1) {
                        longest = prefix;
                    }
                } else {
                    return longest;
                }
            }
        }
        return longest;
    }

    //You have n dice, and each die has k faces numbered from 1 to k.
    //
    //Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.
    //
    //
    //
    //Example 1:
    //
    //Input: n = 1, k = 6, target = 3
    //Output: 1
    //Explanation: You throw one die with 6 faces.
    //There is only one way to get a sum of 3.
    //Example 2:
    //
    //Input: n = 2, k = 6, target = 7
    //Output: 6
    //Explanation: You throw two dice, each with 6 faces.
    //There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
    //Example 3:
    //
    //Input: n = 30, k = 30, target = 500
    //Output: 222616187
    //Explanation: The answer must be returned modulo 109 + 7.
    //
    //
    //Constraints:
    //
    //1 <= n, k <= 30
    //1 <= target <= 1000
}

