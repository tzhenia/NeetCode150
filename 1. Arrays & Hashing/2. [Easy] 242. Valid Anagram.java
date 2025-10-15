// Hash Table (Using Array)
// Time complexity: O(n+m)
// Space complexity: O(1) since we have at most 26 different characters.
//   Where n is the length of string s and m is the length of string t.

class Solution {
    private static final char OFFSET = 'a';

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Hash Table + counting 
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - OFFSET]++; // for first word count++
            count[t.charAt(i) - OFFSET]--; // for second word count--
        }

        for (int val : count) {
            if (val != 0) {
                return false; // in case: different amount of letters
            }
        }

        return true;
    }
}
