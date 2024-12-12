import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int subAvg = (int)(Math.round(n * 0.15));

        double sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Comparator.comparing(Integer::intValue));

        for(int j = subAvg; j < n - subAvg; j++){
            sum += list.get(j);
        }

        int answer = (int) Math.round(sum / (n - subAvg * 2));

        System.out.println(answer);
    }
}
