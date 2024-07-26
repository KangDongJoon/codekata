class Solution {
    public int solution(int number, int limit, int power) {
        int[] factors = new int[number + 1];
        int answer = 0;

        // 에라토스테네스의 체 변형을 사용하여 약수의 개수 계산
        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j += i) {
                factors[j]++;
            }
        }

        // 제한 및 파워 적용
        for (int i = 1; i <= number; i++) {
            if (factors[i] > limit) {
                factors[i] = power;
            }
            answer += factors[i];
        }

        return answer;
    }
}