// Monotonic Decreasing Queue
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        
        Deque<Integer> q = new LinkedList<>(); // indexes
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            // Remove all smaller elements from queue
            // We don’t need those elements anymore — the current element is larger, 
            // which means it will “live” longer in the deque.
            // This keeps the deque in a strictly decreasing order of values.
            while (!q.isEmpty() && nums[r] > nums[q.getLast()]) {
                q.removeLast();
            }

            q.addLast(r);

            // Remove the element from the front if it has moved out of the window.
            if (l > q.getFirst()) {
                q.removeFirst();
            }

            // Once the window becomes full, we save the maximum value.
            if ((r + 1) >= k) {
                ans[l] = nums[q.getFirst()];
                l++;
            }

            r++;
        }

        return ans;
    }
}
