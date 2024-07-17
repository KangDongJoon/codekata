class Solution {
    public int solution(int num) {
        int i = 0;
        long n = (long)num;
        while(i <= 500){
            if(n != 1){
                if(n % 2 == 0){
                    n /= 2;
                }else{
                    n = (n * 3) + 1;
                } 
            }else{
                break;
            }
            if(i == 500){
                return -1;
            }
            i++;
        }
        return i;
    }
}
