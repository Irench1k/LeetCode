class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> matching = new HashMap();
        matching.put('(', ')');
        matching.put('[', ']');
        matching.put('{', '}');

        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            if (matching.containsKey(c[i])) {
                stack.push(c[i]);
            } else {
                if (stack.empty()) {
                    return false;
                }

                char lastChar = stack.pop();
                if (matching.get(lastChar) != c[i]) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}