import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] arr = new int[21];
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "add":
                    add(Integer.parseInt(command[1]));
                    break;
                case  "remove":
                    remove(Integer.parseInt(command[1]));
                    break;
                case "check":
                    bw.write(Integer.toString(check(Integer.parseInt(command[1]))));
                    bw.newLine();
                    break;
                case "toggle":
                    toggle(Integer.parseInt(command[1]));
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }

        }
        bw.flush();
    }

    static void add(int x) {
        if(arr[x] == x){
            return;
        }
        arr[x] = x;
    }

    static void remove(int x) {
        if(arr[x] == 0){
            return;
        }
        arr[x] = 0;
    }

    static int check(int x) {
        if(arr[x] == x){
            return 1;
        }else{
            return 0;
        }
    }

    static void toggle(int x) {
        if(arr[x] == x){
            arr[x] = 0;
        }else{
            arr[x] = x;
        }
    }
    
    static void all() {
        arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    }

    static void empty() {
        arr = new int[21];
    }

}

