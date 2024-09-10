class Solution {
    public long solution(int n) {
        long answer = 0;

        long[] arr = new long[3];
        arr[0] = 1;
        arr[1] = 2;
        
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else{
            for(int i = 2; i < n; i++ ){
                arr[2] = arr[0] % 1234567 + arr[1] % 1234567;
                arr[0] = arr[1] % 1234567;
                arr[1] = arr[2] % 1234567;
            }  
        }
        
       return answer = arr[2] % 1234567;
    }
}