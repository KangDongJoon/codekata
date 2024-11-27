import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(String.valueOf(avg(arr)));
        bw.newLine();
        bw.write(String.valueOf(mid(arr)));
        bw.newLine();
        bw.write(String.valueOf(many(arr)));
        bw.newLine();
        bw.write(String.valueOf(range(arr)));
        bw.flush();
    }

    // 평균 구하기
    static int avg(int[] arr) {
        double sum = 0;

        for (int n : arr) {
            sum += n;
        }

        return (int) Math.round(sum / arr.length);
    }

    // 중간값 구하기
    static int mid(int[] arr) {
        Arrays.sort(arr);

        return arr[arr.length / 2];
    }

    // 최빈값 구하기
    static int many(int[] arr) {

        if (arr.length == 1) {
            return arr[0];
        }
        Arrays.sort(arr);

        int count = 1;
        int many = 1;
        int answer = arr[0];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
                if (count > many) {
                    many = count;
                    list = new ArrayList<>();
                    list.add(arr[i]);
                } else if (count == many) {
                    if (!list.contains(arr[i])) {
                        list.add(arr[i]);
                    }
                }
            } else {
                if (count == many) {
                    if (!list.contains(arr[i])) {
                        list.add(arr[i]);
                    }
                }
                count = 1;
            }
        }
        list.sort((a, b) -> a - b);
        return list.size() > 1 ? list.get(1) : list.get(0);
    }

    // 범위
    static int range(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n : arr) {
            if (n < min) min = n;
            if (n > max) max = n;
        }

        return max - min;
    }
}
