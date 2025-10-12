// Hash Set
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        var set = new HashSet<Integer>();

        for (var i : nums) {
            if (set.contains(i)) {
                return true;
            }

            set.add(i);
        }

        return false;
    }
}
