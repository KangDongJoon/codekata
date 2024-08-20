class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        String[] sArr = s.split(" ");

        for (String a : sArr) {
            int n = Integer.parseInt(a);
            if(n > max){
                max = n;
            }
            if(n < min){
                min = n;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        
        return sb.toString();
    }
}