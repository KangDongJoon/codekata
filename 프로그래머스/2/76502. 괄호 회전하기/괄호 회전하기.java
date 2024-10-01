import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        List<Character> open = Arrays.asList('(', '{', '[');
        List<Character> close = Arrays.asList(')', '}', ']');

        // s의 길이만큼 문자열을 회전
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (isValid(rotated, open, close)) {
                answer++;
            }
        }

        return answer;
    }

    // 괄호의 짝이 올바른지 체크하는 함수
    private static boolean isValid(String s, List<Character> open, List<Character> close) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (open.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastOpen = stack.pop();
                if (!isMatching(lastOpen, c, open, close)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 여는 괄호와 닫는 괄호가 짝이 맞는지 확인
    private static boolean isMatching(char openChar, char closeChar, List<Character> open, List<Character> close) {
        return open.indexOf(openChar) == close.indexOf(closeChar);
    }
}