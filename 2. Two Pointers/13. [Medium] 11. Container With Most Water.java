// Two Pointers
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int maxArea(int[] height) {
        int max = 0;

        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int currWidth = r - l; // Current distance between Left and Right lines (container width).
            int currMinHeight = Math.min(height[l], height[r]); // The maximum amount of water the current container can hold.
            int currentArea = currMinHeight * currWidth;
            max = Math.max(max, currentArea);

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return max;
    }
}
