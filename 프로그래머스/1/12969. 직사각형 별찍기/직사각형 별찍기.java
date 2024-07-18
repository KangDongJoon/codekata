import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < b; i++){
            if(i != 0){
                answer.append("\n");    
            }            
            for(int j = 0; j < a; j++){
                answer.append("*");
            }
        }
        System.out.println(answer);
    }
}