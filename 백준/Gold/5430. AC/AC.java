import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int deleteCount;
    static int reverseCount;
    static boolean reverseFlag;
    static boolean error;

    public static void main(String[] args) throws IOException {

        // 횟수
        N = Integer.parseInt(br.readLine());

        // 입력처리
        for (int i = 0; i < N; i++) {

            String command = br.readLine(); // 명령어 입력

            int size = Integer.parseInt(br.readLine()); // 사이즈 입력 처리(미사용)

            String inputArr = br.readLine(); // 배열 입력
            inputArr = inputArr.substring(1, inputArr.length() - 1); // 대괄호가 입력되므로 자바문법에 맞게 처리
            String[] stringArr = inputArr.split(",");
            reverseFlag = false;
            error = false;

            deleteCount = 0; // commandD 처리 인덱스
            reverseCount = 0;

            commandInput(command, stringArr);
            bw.newLine();

        }

        bw.flush();
    }

    // 명령어가 입력되면 순차적으로 처리
    static void commandInput(String command, String[] arr) throws IOException {

        for (int i = 0; i < command.length(); i++) {
            if(error){
                return;
            }

            char c = command.charAt(i);

            switch (c) {

                case 'R':
                    commandR();
                    break;
                case 'D':
                    if(arr[0].equals("")){
                        bw.write("error");
                        return;
                    }
                    commandD(arr);
                    break;
            }
        }

        // 출력
        if(error){
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        if (!reverseFlag) {
            for (int i = 0; i < arr.length; i++) {
                if (!arr[i].equals("d")) {
                    sb.append(arr[i]).append(",");
                }
            }
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (!arr[i].equals("d")) {
                    sb.append(arr[i]).append(",");
                }
            }

        }
        if (sb.lastIndexOf(",") == sb.length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");

        bw.write(sb.toString());

    }

    static void commandR() {
        reverseFlag = !reverseFlag;
    }

    // 명령어 'D'
    static void commandD(String[] arr) throws IOException {

        if (deleteCount + reverseCount > arr.length - 1) {
            bw.write("error");
            error = true;
            return;
        }

        if (!reverseFlag) {
            arr[deleteCount] = "d";
            deleteCount++;
        } else {
            arr[arr.length - 1 - reverseCount] = "d";
            reverseCount++;
        }

    }
}
