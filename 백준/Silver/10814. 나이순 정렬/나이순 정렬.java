import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        List<Auth> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            Auth auth = new Auth(i, Integer.parseInt(arr[0]), arr[1]);
            list.add(auth);
        }

        list.sort(Comparator.comparing(Auth::getAge).thenComparing(Auth::getId));

        StringBuilder sb = new StringBuilder();
        for (Auth auth : list) {
            sb.append(auth.age).append(" ").append(auth.name).append("\n");
        }

        System.out.println(sb);
    }

    static class Auth {
        int id;
        int age;
        String name;

        Auth(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        // getter
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

    }
}
