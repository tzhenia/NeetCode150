// Prefix & Suffix (Optimal)
// Time complexity: O(n)
// Space complexity: 
//   O(1) extra space.
//   O(n) space for the output array.

// original
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= postfix;
            postfix *= nums[i];
        }

        return ans;
    }
}

// own example with comments
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arrLength = nums.length;
        
        int[] res = new int[arrLength];
        Arrays.fill(res, 1); // should override default value from 0 to 1

        // iterate from the start and save prefix
        int prefix = 1;
        for (int i = 0; i < arrLength; i++) {
            res[i] *= prefix;
            prefix *= nums[i];
        }

        // iterate from the end and save postfix
        int postfix = 1;
        for (int i = arrLength - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;
    }
}
