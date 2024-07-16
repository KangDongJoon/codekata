class Solution {
    public long solution(long n) {
        long sqrt = (long) Math.sqrt(n);
        
        // 제곱근의 제곱이 원래 숫자와 같다면, 정수 제곱근이다.
        if (sqrt * sqrt == n) {
            return (long)Math.pow((sqrt + 1), 2);
        } else {
            return -1;
        }
    }
}
