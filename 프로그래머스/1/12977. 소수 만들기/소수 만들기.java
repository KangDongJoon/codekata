import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        // 배열 정렬
        Arrays.sort(nums);

        // 첫 번째 숫자를 고정하고 두 번째와 세 번째 숫자를 포인터로 탐색
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (prime(sum) == 1) {
                    answer++;
                }

                // l과 r 포인터를 이동하여 모든 조합을 탐색
                l++;
                if (l >= r) {
                    r--;
                    l = i + 1;
                }
            }
        }
        return answer;
    }


    public static int prime(int sum) {
        int count = 0;
        int sqrt = (int) Math.sqrt(sum);
        for (int i = 1; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                count++;
            }
        }
        if (count > 1) {
            return 0;
        } else {
            return 1;
        }
    }
}