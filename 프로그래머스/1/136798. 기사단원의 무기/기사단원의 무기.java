class Solution {
    public int solution(int number, int limit, int power) {
        int[] factors = new int[number];
        factors[0] = 1;
        int answer = 0;

        for(int i = 2; i <= number; i++){
            int m = 0;
            int sqrt = (int) Math.sqrt(i);
            for(int j = 2; j <= sqrt; j++){
                if(i % j == 0){
                    m++;
                }
            }
            if(sqrt * sqrt == i){
                m = m * 2 + 1;
            }else{
                m = m * 2 + 2;
            }

            if(m <= limit){
                factors[i - 1] = m;
            }else{
                factors[i - 1] = power;
            }
        }
        for(int a : factors){
            answer += a;
        }
        return answer;
    }
}