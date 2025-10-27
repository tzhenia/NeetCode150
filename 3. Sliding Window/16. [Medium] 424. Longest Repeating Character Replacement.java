// Sliding Window
// Time complexity: O(n)
// Space complexity: O(m)
//   Where n is the length of the string and m is the total number of unique characters in the string.

class Solution {
    private static final char OFF_SET = 'A';

    public int characterReplacement(String s, int k) {
        if (s.length() == k) {
            return k;
        }

        int[] hashTable = new int[26];
        int maxF = 0; // max frequency from hashTable
        int ans = 0;
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            char charRight = s.charAt(r);
            hashTable[charRight - OFF_SET]++;
            maxF = Math.max(maxF, hashTable[charRight - OFF_SET]);

            while (isWindowNotValid(r, l, maxF, k)) {
                char charLeft = s.charAt(l);
                hashTable[charLeft - OFF_SET]--;
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }

    // Case when we need to move left pointer.
    private static boolean isWindowNotValid(int r, int l, int maxF, int k) {
        return r - l + 1 - maxF > k;
    }
}
