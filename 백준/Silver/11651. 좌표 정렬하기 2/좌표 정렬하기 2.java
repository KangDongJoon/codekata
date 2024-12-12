import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        List<point> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            list.add(new point(x ,y));
        }

        list.sort(Comparator.comparing(point::getY).thenComparing(point::getX));

        for (point point : list) {
            bw.write(point.getPoint());
            bw.newLine();
        }

        bw.flush();
    }

    static class point{
        int x;
        int y;

        point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private String getPoint(){
            return x + " " + y;
        }

        private int getX(){
            return x;
        }

        private int getY(){
            return y;
        }
    }
}
