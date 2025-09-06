import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // '1'을 기준으로 쪼개면 0 덩어리 개수를 셀 수 있음
        StringTokenizer zeroToken = new StringTokenizer(s, "1");
        // '0'을 기준으로 쪼개면 1 덩어리 개수를 셀 수 있음
        StringTokenizer oneToken = new StringTokenizer(s, "0");

        int zeroCount = zeroToken.countTokens();
        int oneCount = oneToken.countTokens();

        System.out.println(Math.min(zeroCount, oneCount));
    }
}
