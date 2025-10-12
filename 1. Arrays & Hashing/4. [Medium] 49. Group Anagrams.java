// Hash Table
// Time complexity: O(m*n)
// Space complexity: 
//     O(m) extra space. 
//     O(m*n) space for the output list.
// Where m is the number of strings and is the length of the longest string.

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }

        return new ArrayList<>(res.values());
    }
}
