class Solution{
    public int solution(int n, int a, int b){
        int s = 1;
        int answer = 0; 
        if(a % 2 != 0){
            if(a + 1 == b){
                return 1;
            }
        }else{
            if(a - 1 == b){
                return 1;
            }
        }


        for(int i = 1; s != n; i++){
            s = (int)Math.pow(2, i);
            if(a % 2 != 0){
                a++;
                a /= 2;
            }else {
                a /= 2;
            }

            if(b % 2 != 0){
                b++;
                b /= 2;
            }else {
                b /= 2;
            }

            if(a % 2 != 0){
                if(a + 1 == b){
                    answer = i + 1;
                    break;
                }
            }else{
                if(a - 1 == b){
                    answer = i + 1;
                    break;
                }
            }
        }
        return answer;
    }
}