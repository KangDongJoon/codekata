import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        List<MeetingTime> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            list.add(new MeetingTime(start, end));
        }

        List<MeetingTime> sortedList = list.stream()
                .sorted(Comparator.comparing(MeetingTime::getEnd)
                                .thenComparing(MeetingTime::getStart))
                .collect(Collectors.toList());

        int count = 0;
        int nowEnd = -1;

        for (MeetingTime meetingTime : sortedList) {
            if(meetingTime.getStart() >= nowEnd){
                nowEnd = meetingTime.getEnd();
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();

    }


    static class MeetingTime {

        int start;
        int end;

        MeetingTime(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return this.start;
        }

        public int getEnd() {
            return this.end;
        }

    }
}
