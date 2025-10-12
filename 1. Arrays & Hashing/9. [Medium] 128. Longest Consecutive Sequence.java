// Hash Map
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num : set) {
            // check if its the start of sequence (without left neighbor)
            if (!set.contains(num - 1)) {
                int length = 0;

                while (set.contains(num + length)) {
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
