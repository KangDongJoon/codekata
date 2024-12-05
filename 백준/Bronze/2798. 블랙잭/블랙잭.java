import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        int max = 0;
        int sum = 0;

        String[] num = br.readLine().split(" ");

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    sum = Integer.parseInt(num[i]) + Integer.parseInt(num[j]) + Integer.parseInt(num[k]);
                    if(sum <= target){
                        if(max < sum){
                            max = sum;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
