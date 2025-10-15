// Hash Table
// Time complexity: O(m*n)
// Space complexity: 
//   O(m) extra space. 
//   O(m*n) space for the output list.
//   Where m is the number of strings and is the length of the longest string.

public class Solution {
    private static final char OFFSET = 'a';

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - OFFSET]++;
            }

            String key = Arrays.toString(count);
            ans.putIfAbsent(key, new ArrayList<>());
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());
    }
}
