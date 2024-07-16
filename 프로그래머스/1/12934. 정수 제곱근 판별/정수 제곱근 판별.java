class Solution {
    public long solution(long n) {
        
        double dn = n;
        double sqrt = Math.sqrt(dn);
        long lsqrt = (long)sqrt;
        double dsqrt = lsqrt;
        if(sqrt == dsqrt){
            return (long)Math.pow((sqrt+1), 2);
        }else{
            return -1;
        }
    }
}