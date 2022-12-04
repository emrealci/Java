import java.util.Scanner;

public class printer{
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to image printer program.");
		System.out.print("Please enter your sequence: ");
		
		String s = scan.next();
		
		for (int i = 0; i < s.length()-1; i++) {
			
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				if (s.charAt(i+1) == 'b') {
					for (int j = 0; j < s.charAt(i)-48; j++) {
						System.out.print(" ");
					}
				}
				if (s.charAt(i+1) == 's') {
					for (int j = 0; j < s.charAt(i)-48; j++) {
						System.out.print("*");
					}
				}
				if (s.charAt(i+1) == 'n') {
					for (int j = 0; j < s.charAt(i)-48; j++) {
						
						System.out.println("");
					}
				}
				
			}
			
			if (s.charAt(i) == 'b' || s.charAt(i) == 'n' || s.charAt(i) =='s' ) {
				if (s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') {
					continue;
				}
				else {
					if(s.charAt(i+1) == 'b') {
						System.out.print(" ");
					}
					else if(s.charAt(i+1) == 's') {
						System.out.print("*");
					}
					else {
						System.out.println("");
					}
				}
			}
			
		}
		
	}
}