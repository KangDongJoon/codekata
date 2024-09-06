class Solution {
    public int solution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i + 1] = arr[i] * arr[i + 1] / getGcd(arr[i], arr[i + 1]);
        }
        
        return arr[arr.length -1];
    }


    public static int getGcd(int p, int q) {
        if (q == 0) return p;
        return getGcd(q, p % q);
    }
}