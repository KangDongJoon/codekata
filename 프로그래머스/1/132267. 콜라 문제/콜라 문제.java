class Solution {
    public int solution(int a, int b, int n) {
		int rest = 0;
		int answer = 0;
		while(n >= a) {
			rest = n % a;
			answer += (n / a) * b;
			n = (n / a) * b + rest;
			rest = 0;
		}
        return answer;
    }
}