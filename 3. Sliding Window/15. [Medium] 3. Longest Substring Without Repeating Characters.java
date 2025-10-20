// Sliding Window
// Time complexity: O(n)
// Space complexity: O(m)
//   Where n is the length of the string and m is the total number of unique characters in the string.

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int max = 0;
        Set<Character> set = new HashSet<>();

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) { // The right pointer checks whether an element exists in the Sliding Window. 
                set.remove(s.charAt(l)); // The left pointer removes an element from the Sliding Window.
                l++;
            }

            set.add(s.charAt(r));
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
