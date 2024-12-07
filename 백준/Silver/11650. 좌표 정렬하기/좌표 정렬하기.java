import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        List<XY> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String read = br.readLine();
            list.add(new XY(read));
        }

        list.sort(Comparator.comparing(XY::getX).thenComparing(XY::getY));

        for (XY xy : list) {
            bw.write(xy.getXY());
            bw.newLine();
        }

        bw.flush();
    }

    public static class XY {
        int x;
        int y;

        XY(String read){
            String[] reads = read.split(" ");
            this.x = Integer.parseInt(reads[0]);
            this.y = Integer.parseInt(reads[1]);
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }

        public String getXY(){
            return Integer.toString(x) + " " + Integer.toString(y);
        }
    }
}
