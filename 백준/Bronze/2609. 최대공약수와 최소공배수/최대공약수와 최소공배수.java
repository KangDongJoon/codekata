import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 유클리드 호제법을 사용 재귀함수를 이용하여 구하기
    public static void main(String[] args) throws IOException {
        
        String[] input = br.readLine().split(" ");
        
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        
        int GCD = gcd(a, b);
        int LCM = a * b / GCD;

        System.out.println(GCD);
        System.out.println(LCM);
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}
