class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        // 시작점 찾기
        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                answer[0] = i;
                answer[1] = park[i].indexOf("S");
                break;
            }
        }

        // routes 확인
        for (String r : routes) {
            String[] rArr = r.split(" ");
            String dir = rArr[0];
            int dis = Integer.parseInt(rArr[1]);
            boolean conX = true;

            switch (dir) {
                case "E":
                    if (answer[1] + dis < park[0].length()) {
                        if (!park[answer[0]].substring(answer[1] + 1, answer[1] + dis + 1).contains("X")) {
                            answer[1] += dis;
                        }
                    }
                    break;
                case "W":
                    if (answer[1] - dis >= 0) {
                        if (!park[answer[0]].substring(answer[1] - dis, answer[1]).contains("X")) {
                            answer[1] -= dis;
                        }
                    }
                    break;
                case "S":
                    if (answer[0] + dis < park.length) {
                        for (int i = answer[0] + 1; i <= answer[0] + dis; i++) {
                            if (park[i].charAt(answer[1]) == 'X') {
                                conX = false;
                                break;
                            }
                        }
                        if (conX) {
                            answer[0] += dis;
                        }
                    }
                    break;
                case "N":
                    if (answer[0] - dis >= 0) {
                        for (int i = answer[0] - 1; i >= answer[0] - dis; i--) {
                            if (park[i].charAt(answer[1]) == 'X') {
                                conX = false;
                                break;
                            }
                        }
                        if (conX) {
                            answer[0] -= dis;
                        }
                    }
                    break;
            }
        }
        return answer;
    }
}
