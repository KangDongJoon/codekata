import java.io.*;
import java.math.BigInteger;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        // 입력 처리
        int input = Integer.parseInt(br.readLine());
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= input; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String n = factorial.toString();
        int count = 0;

        for(int i = n.length() - 1; i > 0; i--){
            char c = n.charAt(i);
            if(c != '0'){
                break;
            }else{
                count++;
            }
        }
        System.out.println(count);
    }
}
