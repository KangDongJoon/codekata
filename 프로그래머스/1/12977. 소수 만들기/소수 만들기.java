class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                    sum = nums[i] + nums[l] + nums[r];
                    answer += prime(sum);
                    l++;
                    if(l >= r){
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