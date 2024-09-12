import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            if(!map.containsKey(i)){
                map.put(i, 1);
            }else{
                map.put(i, map.get(i) + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entryList 
            = new ArrayList<>(map.entrySet());

        entryList.sort(Map.Entry.comparingByValue());

        int i = entryList.toArray().length - 1;
        int n = 0;
        
        while(k > 0){
            int a = entryList.get(i).getValue();
            k -= a;
            n++;
            if(i != 0){
                i--;     
            }else{
                break;
            }
        }
        return n;
    }
}