import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        List<person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new person(input[1], input[0]));
        }

        for(int j = 0; j < list.size(); j++){
            for(int k = 0; k < list.size(); k++){
                if(j == k){
                    continue;
                }
                if(list.get(j).getTall() < list.get(k).getTall() && list.get(j).getWeight() < list.get(k).getWeight()){
                    list.get(j).setRank();
                }
            }
        }

        for (person person : list) {
            bw.write(Integer.toString(person.getRank()));
            bw.newLine();
        }

        bw.flush();
    }

    public static class person {

        int tall;
        int weight;
        int rank = 1;

        person(String tall, String weight){
            this.tall = Integer.parseInt(tall);
            this.weight = Integer.parseInt(weight);
        }

        private void setRank(){
            this.rank++;
        }

        private int getRank(){
            return rank;
        }

        private int getTall(){
            return tall;
        }

        private int getWeight(){
            return weight;
        }

    }
}
