import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sum = new Scanner(System.in);
		int x1,x2;
		int y1,y2;
		int r1,r2;
		int T = sum.nextInt();
		
		for(int i = 0; i < T; i++) {
			x1 = sum.nextInt();
			y1 = sum.nextInt();
			r1 = sum.nextInt();
			
			x2 = sum.nextInt();
			y2 = sum.nextInt();
			r2 = sum.nextInt();
			double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			
			if (d == 0 && r1 == r2) {
				System.out.println(-1);
			}else if (d > Math.abs(r2 - r1) && d < r1 +r2) {
				System.out.println(2);
			}else if (d == Math.abs(r2 - r1) || d == r2 + r1) {
				System.out.println(1);
			}else if (r1 + r2 < d || Math.abs(r2 - r1) > d || d == 0) {
				System.out.println(0);
			}
		}
	}
}