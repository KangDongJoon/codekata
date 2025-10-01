import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] cranes = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] boxes = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        // 크레인, 박스 모두 내림차순 정렬
        Arrays.sort(cranes);
        Arrays.sort(boxes);
        reverse(cranes);
        reverse(boxes);

        if (boxes[0] > cranes[0]) {
            System.out.println(-1); // 옮길 수 없는 물건이 존재
            return;
        }

        boolean[] moved = new boolean[M]; // 박스 이동 여부
        int count = 0;
        int movedCount = 0;

        while (movedCount < M) {
            int j = 0; // 박스 인덱스
            for (int i = 0; i < N; i++) { // 각 크레인
                while (j < M) {
                    if (!moved[j] && cranes[i] >= boxes[j]) {
                        moved[j] = true;
                        movedCount++;
                        j++;
                        break; // 다음 크레인으로
                    }
                    j++;
                }
            }
            count++; // 한 턴 끝
        }

        System.out.println(count);
    }

    // 배열 내림차순
    static void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n/2; i++) {
            int tmp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = tmp;
        }
    }
}
