// Sliding Window
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    private static final char OFF_SET = 'a';
    private static final int ENGLISH_LENGHT_ALPHABET = 26;

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[ENGLISH_LENGHT_ALPHABET];
        int[] s2Count = new int[ENGLISH_LENGHT_ALPHABET];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - OFF_SET]++;
            s2Count[s2.charAt(i) - OFF_SET]++;
        }

        int matches = 0;
        for (int i = 0; i < s1Count.length; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int l = 0; // Begin of sliding window
        int r = s1.length(); // End of sliding window
        while (r < s2.length()) {
            if (matches == ENGLISH_LENGHT_ALPHABET) {
                return true;
            }

            int index = s2.charAt(r) - OFF_SET;
            s2Count[index]++; // Add into sliding window (right pointer)
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            index = s2.charAt(l) - OFF_SET;
            s2Count[index]--; // Remove from sliding window (left pointer)
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }

            l++;
            r++;
        }

        return matches == ENGLISH_LENGHT_ALPHABET;
    }
}
