
import java.util.Scanner;

public class pattern {
  public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);
		
	while(true) {
		
	  System.out.print("Enter an input string: ");
	  String s = scan.next();
	  
	  if (s.equals("QUIT")) {
	    System.out.print("OK. Good bye :-)");
	    break;
	  }
	  
	  for (int i = 0; i < s.length(); i++) {
		for (int j = 0; j < s.length()-i; j++) {
	      System.out.print(s.charAt(j));	
	    }
	    for (int k = 0; k <i*2; k++) {
		  System.out.print(" ");
	    }
	    for(int m = i; m < s.length(); m++ ) {
		  System.out.print(s.charAt(m));
	    }
	    System.out.println("");
	  }
			
	  for (int i = 0 ; i < s.length(); i++) {
				
		int buff = (s.length()*2-2) - 2*i; 
		for (int j = 0; j <= i; j++ ) {
		  System.out.print(s.charAt(j));
		}
				
		for (int m = buff; m > 0 ; m--) {
		  System.out.print(" ");
		}
		for (int m =s.length()-i-1 ; m <= s.length()-1 ; m++) {
		  System.out.print(s.charAt(m));
		}
				
		System.out.println("");
	  }
			
	}
  }
}
