class Solution {
    public int[] solution(long n) {
        String S = Long.toString(n);
        
        int[] answer = new int[S.length()];
        int j = 0;
        
        for(int i = S.length() - 1; i >= 0; i--){
            char c = S.charAt(i);
            answer[j] = Character.getNumericValue(c);
            j++;
        }
        return answer;
    }
}