class Solution {
    public String solution(int[] food) {
        int length = 0;
		for(int n : food) {
			length += n / 2;
		}
		length = length * 2 + 1;
		String[] arr = new String[length];
		int l = 0;
		int r = length - 1;
		int i = 1;
		int j = 0;
		while(length / 2 > l) {
			if(food[i] < 2) {
				i++;
			}else {
				arr[l] = Integer.toString(i); 
				arr[r] = Integer.toString(i);
				j++;
				l++;
				r--;
				if(j >= food[i] / 2) {
					j = 0;
					i++;
				}
			}
		}
		arr[length / 2] = "0";
		String answer = "";
		for(String s : arr) {
			answer += s;
		}
        return answer;
    }
}