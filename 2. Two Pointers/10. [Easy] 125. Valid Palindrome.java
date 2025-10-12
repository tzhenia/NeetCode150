// Two Pointers
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            char cl = Character.toLowerCase(s.charAt(l));
            char cr = Character.toLowerCase(s.charAt(r));

            if (!Character.isLetterOrDigit(cl)) {
                l++;
            } else if (!Character.isLetterOrDigit(cr)) {
                r--;
            } else if (cl == cr) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }
}
