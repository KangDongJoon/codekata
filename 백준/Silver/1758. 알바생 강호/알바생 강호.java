import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 사람 수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. 팁을 저장할 배열 선언 (Collections.reverseOrder를 사용하기 위해 Integer 배열 사용)
        Integer[] tip = new Integer[N];
        for(int i = 0 ; i < N ; i++){
            tip[i] = Integer.parseInt(br.readLine());
        }
        
        // 3. 내림차순 정렬 (가장 큰 팁을 주는 사람이 먼저 받도록)
        Arrays.sort(tip, Collections.reverseOrder());
        
        // 4. 팁의 총합을 계산 (N*팁의 최대값이 10^10이므로 long 타입 사용)
        long totalTip = 0;
        
        for(int i = 0; i < N; i++) {
            // 받은 등수 = i + 1
            // 팁 감소액 = (받은 등수 - 1) = i
            
            // 실제 받을 팁 계산: 원래 팁 - 감소액
            long realTip = (long)tip[i] - i; 
            
            // 5. 계산된 팁이 양수인 경우에만 합산 (음수면 팁 0원)
            if (realTip > 0) {
                totalTip += realTip;
            } else {
                // 내림차순 정렬했으므로, 한번 팁이 0 이하가 되면 이후의 팁도 모두 0 이하가 됨
                break;
            }
        }
        
        System.out.println(totalTip);
    }
}