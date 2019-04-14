package arithmeticExercise;

public class Test_01 {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 1;i<200;i++) {
			boolean flag = true;
			for(int j=2;j<=Math.sqrt(i);j++) {
				if(i%j==0) {
					flag=false;
					break;
				}
			}
			if(flag==true) {
				count++;
				System.out.print(i+"\t");
				if(count%10==0) {
					System.out.println();
				}
			}
		}
		System.out.println("\n共有："+count+"个素数");
	}
}
