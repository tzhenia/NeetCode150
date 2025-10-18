// Dynamic Programming (One Pass)
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int minPrice = prices[0];
        for (int currPrice : prices) {
            minPrice = Math.min(minPrice, currPrice);
            maxProfit = Math.max(maxProfit, currPrice - minPrice);
        }

        return maxProfit;
    }
}
