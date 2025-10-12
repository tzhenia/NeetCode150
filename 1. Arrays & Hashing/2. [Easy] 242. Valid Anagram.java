// Time complexity: O(n+m)
// Space complexity: O(1) since we have at most 26 different characters.

class Solution {
    private static final char OFFSET = 'a';

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - OFFSET]++;
            count[t.charAt(i) - OFFSET]--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}
