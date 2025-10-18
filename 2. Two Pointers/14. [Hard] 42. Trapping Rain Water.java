// Two Pointers. Hint: formula
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int trap(int[] height) {
        int ans = 0;

        if (height.length <= 2) { // For trapping Rain Water should be at least 3 items.
            return ans;
        }

        int l = 0;
        int lMax = height[l];

        int r = height.length - 1;
        int rMax = height[r];

        while (l < r) {
            if (height[l] < height[r]) {
                l++;
                lMax = Math.max(lMax, height[l]);
                ans += lMax - height[l]; // formula
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                ans += rMax - height[r]; // formula
            }
        }

        return ans;
    }
}
