// Stack + Map with matching
// Time complexity: O(n)
// Space complexity: O(n)

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> matching = Map.of(
                '(', ')',
                '{', '}',
                '[', ']'
        );

        Stack<Character> stack = new Stack<>();

        for (char curr : s.toCharArray()) {
            if (matching.containsKey(curr)) {
                stack.push(curr);
            } else {
                if (stack.empty()) {
                    return false; // In case we don't have any open parentheses in the stack. 
                }
                var prevOpen = stack.pop();
                var expectedClose = matching.get(prevOpen); // expected must be ")" or "]" or "}"
                if (curr != expectedClose) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
