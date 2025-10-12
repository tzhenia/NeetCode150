// Hash Set
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();

        for (var i : nums) {
            if (seen.contains(i)) {
                return true;
            }
            seen.add(i);
        }

        return false;
    }
}
