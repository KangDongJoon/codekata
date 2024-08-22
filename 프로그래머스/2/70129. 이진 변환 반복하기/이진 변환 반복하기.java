class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int n = s.length();
        int remove = 0;
        int i = 0;
        while (!s.equals("1")){
            s = s.replaceAll("0","");
            int zeroRemove = n - s.length();
            remove += zeroRemove;
            s = toBinary(s.length());
            n = s.length();
            i++;
        }
        answer[0] = i;
        answer[1] = remove;
        return answer;
    }

    public static String toBinary(int n){
        StringBuilder sb = new StringBuilder();
        while(n > 1){
            if(n % 2 == 0){
                sb.append(0);
            }else{
                sb.append(1);
            }
            n /= 2;
        }
        if(n == 1){
            sb.append(1);
         }
        return sb.reverse().toString();
    }
}