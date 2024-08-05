class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];
        for(int i = 0; i < targets.length; i++){
           int answer = 0;
           for(int j = 0; j < targets[i].length(); j++){
               char c = targets[i].charAt(j);
               int push = Integer.MAX_VALUE;
               for(int q = 0; q < keymap.length; q++){
                   if(keymap[q].indexOf(c) != -1 && push > keymap[q].indexOf(c)){
                       push = keymap[q].indexOf(c) + 1;
                   }
               }
               if(push == Integer.MAX_VALUE){
                   answer = -1;
                   break;
               }else{
                   answer += push;
               }
           }
           result[i] = answer;
       }
        return result;
    }
}