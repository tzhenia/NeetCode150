// Time complexity: O(n²)
// Space complexity:
//   O(1) or O(n) extra space depending on the sorting algorithm.
//   O(m) space for the output list.

class Solution {
    public static final int TARGET = 0; // Task requirement
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // After sorting the input nums, the solution's idea will be similar to "167. Two Sum II - Input Array Is Sorted"

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > TARGET) { // After sorting, the first element can't be bigger than zero (TARGET).
                break;
            }

            if (i > 0 && nums[i - 1] == nums[i]) { // Trick: left and right numbers can't be the same.
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > TARGET) {
                    r--;
                } else if (sum < TARGET) {
                    l++;
                } else {
                    List<Integer> triplet = List.of(nums[i], nums[l], nums[r]);
                    ans.add(triplet);
                    l++;
                    r--; // Сan work without r--

                    // Trick: left and right number can't be the same.
                    while (l < r && nums[l - 1] == nums[l]) {
                        l++;
                    }
                }
            }
        }

        return ans;
    }
}
