import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 세 각을 입력받는다.
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        // 세 각의 합이 180인지 확인
        if (a + b + c != 180) {
            System.out.println("Error");
        } else {
            // 세 각이 모두 60이면 Equilateral
            if (a == 60 && b == 60 && c == 60) {
                System.out.println("Equilateral");
            } 
            // 두 각이 같으면 Isosceles
            else if (a == b || a == c || b == c) {
                System.out.println("Isosceles");
            } 
            // 모두 다르면 Scalene
            else {
                System.out.println("Scalene");
            }
        }
        
        sc.close();
    }
}