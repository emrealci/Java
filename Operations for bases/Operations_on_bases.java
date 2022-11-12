import java.util.Scanner;

public class Operations_on_bases {
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		  
		System.out.print("Enter the base of number system: ");
		int baseNum = scan.nextInt();
		  
		System.out.print("Enter the type of operation: ");
		char operation = scan.next().charAt(0);
		  
		System.out.print("Enter the input numbers: ");
		int num1 = scan.nextInt(); //It's integer but actually not decimal form (except 10 base)
		int num2 = scan.nextInt(); //It's integer but actually not decimal form (except 10 base)
		  
		int num1Int = 0;
		int num2Int = 0;
		int numResult = 0;
		String result = "";
		  
		for (int i =0; num1>0; i++) {
			num1Int += (num1%10) * Math.pow(baseNum,i);
			num1 /= 10;
		}
		  
		for (int i =0; num2>0; i++) {
			num2Int += (num2%10) * Math.pow(baseNum,i);
			num2 /=10;
		}
		
		// In the part up to here, the entered numbers are converted to decimal.
		
		if (operation=='a')
	    	numResult = num1Int + num2Int;
		
		if (operation=='s')
			numResult = num1Int - num2Int;
		
		if (operation=='m')
			numResult = num1Int * num2Int;
		
		if (operation=='d')
			numResult = num1Int / num2Int;
		  
		while (numResult !=0 ) { //convert decimal to other bases.
			result = (numResult % baseNum) + result;
			numResult /= baseNum;
		}
		  
		System.out.println(result);
	}
}		
