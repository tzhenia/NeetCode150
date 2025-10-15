// Hash Map (One Pass)
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                ans[0] = i;
                ans[1] = map.get(complement);
            }

            map.put(nums[i], i);
        }

        return ans;
    }
}
