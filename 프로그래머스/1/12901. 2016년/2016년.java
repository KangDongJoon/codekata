import java.util.*;
class Solution {
    public String solution(int a, int b) {
        String answer = week(day(a,b));
        return answer;
    }
    public static int day(int a, int b) {
		int day = 0;
		if(a == 1) {
			return b;
		}else {
			for(int i = 1; i < a; i++) {
				if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
					day += 31;
				}else if(i == 4 || i == 6 || i == 9 || i == 11) {
					day += 30; 
				}else {
					day += 29;
				}
			}
			day += b;
		}return day;
	}
	
	public static String week(int d) {
		Map<Integer, String> wek = new HashMap<>();
		wek.put(1, "FRI");
		wek.put(2, "SAT");
		wek.put(3, "SUN");
		wek.put(4, "MON");
		wek.put(5, "TUE");
		wek.put(6, "WED");
		wek.put(0, "THU");
		
		return wek.get(d % 7);
	}
}