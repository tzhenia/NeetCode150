// Bucket Sort
// Time complexity: O(n)
// Space complexity: O(n)

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. count all nums
        var counts = new HashMap<Integer, Integer>();
        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        
        // 2. init arr (Hash Table) where
        // index == count of freq
        // values is empty List
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // 3. fill (sort) Hash Table with List of freq
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            var index = entry.getValue(); // count of freq
            var num = entry.getKey(); // num

            freq[index].add(num); // arr (Hash Table)
        }

        // 4. init result
        int[] res = new int[k];
        int index = 0;

        // 5. iterate from the end
        // first index is the smalest freq
        // last index is the bigest freq
        for (int i = freq.length - 1; i > 0; i--) {
            for (int n : freq[i]) {
                res[index] = n;
                index++;

                if (index == k) { // point where we should stop filling res
                    return res;
                }
            }
        }

        return res;
    }
}
