// Two Pointers
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] ans = new int[2];

        while (l < r) {
            int currSum = numbers[l] + numbers[r];
            if (currSum > target) {
                r--;
            } else if (currSum < target) {
                l++;
            } else {
                ans[0] = l + 1; // +1 The index in this task started from 1 (not as usual from 0)
                ans[1] = r + 1; // +1 The index in this task started from 1 (not as usual from 0)
                return ans;
            }
        }

        return ans;
    }
}
