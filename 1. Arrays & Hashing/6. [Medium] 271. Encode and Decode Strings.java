// Encoding & Decoding
// Time complexity: O(m) for each encode() and decode()
// Space complexity: O(m+n) for each encode() and decode()
//   Where m is the sum of lengths of all the strings and n is the number of strings.

public class Codec {
    private static final char DELIMETR = '#';

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length());
            sb.append(DELIMETR);
            sb.append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < str.length()) {
            while (str.charAt(j) != DELIMETR) {
                j++; // count how many numbers 1 or 2 or 3 ...(Ex: 1 vs 10 vs 101)
            }

            int length = Integer.parseInt(str.substring(i, j)); // parse number

            i = j + 1; // move left pointer + skip DELIMETR. Index of starting word.
            j = i + length; // index of ending word.
            String word = str.substring(i, j);
            ans.add(word);

            i = j; // move pointer to next word;
        }

        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
