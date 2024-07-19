class Solution {
    public int solution(int[][] sizes) {
        int arm = Integer.MIN_VALUE;
        int acm = Integer.MIN_VALUE;
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] > arm){
                arm = sizes[i][0];
            }if(sizes[i][1] > acm){
                acm = sizes[i][1];
            }
        }
        int a = arm * acm;

        spin(sizes);
        arm = Integer.MIN_VALUE;
        acm = Integer.MIN_VALUE;
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] > arm){
                arm = sizes[i][0];
            }if(sizes[i][1] > acm){
                acm = sizes[i][1];
            }
        }
        int b = arm * acm;

        int answer = Math.min(a, b);
        
        return answer;

    }

    public static int[][] spin(int[][] arr) {
        int tmp = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i][0] > arr[i][1]){
                tmp = arr[i][0];
                arr[i][0] = arr[i][1];
                arr[i][1] = tmp;
            }
        }
        return arr;
    }
}