class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < phone_number.length() - 4; i++){
            answer.append("*");
        }
        for(int j =  phone_number.length() - 4; j <  phone_number.length(); j++){
            answer.append(phone_number.charAt(j));
        }
        return answer.toString();
    }
}