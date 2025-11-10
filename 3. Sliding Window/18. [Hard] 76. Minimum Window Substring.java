// Sliding Window + 2 HashMaps (countT, window) + have + need
// compare have == need in O(1) time without comparing all elements on every step.

// Time complexity: O(n+m)
// Space complexity: O(m)
//   Where n is the length of the string s and m is the total number of unique characters in the strings t and s.
  
class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = countT.size();
        int[] ans = {-1, -1};
        int ansLength = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            // positive case when we can remove from left
            while (have == need) {

                // case for updating answer
                if ((r - l + 1) < ansLength) {
                    ansLength = r - l + 1;
                    ans[0] = l;
                    ans[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }

                l++;
            }
            
            r++;
        }
        
        return ansLength == Integer.MAX_VALUE ? "" : s.substring(ans[0], ans[1] + 1);
    }
}
