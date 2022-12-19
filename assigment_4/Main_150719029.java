import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int totalNumWords = 0;
		int totalNumLetters = 0;
		
		while(true) { // works until pressed 5 on menu
			
			System.out.println("Menu: \n" + "1. Chance Case \n" + "2. Count occurrences \n"
					+ "3. Encryption \n" + "4. Statistics \n" + "5. Exit \n"); 
			System.out.print("Please select an option: ");
			
			int option  = scan.nextInt();
			scan.nextLine(); // we used this to avoid error in using nextLine with while loop
			
			if (option == 1) {
				System.out.print("Please enter an input String: ");
				String s = scan.nextLine();
				
				System.out.println(changeCase(s));
				totalNumWords = updateWordCount(totalNumWords,s);
				totalNumLetters = updateLetterCount(totalNumLetters,s);
			}
			
			if (option == 2) {
				System.out.print("Please  enter  an  input  sentence: ");
				String sentence = scan.nextLine();
				
				totalNumWords = updateWordCount(totalNumWords,sentence);
				totalNumLetters = updateLetterCount(totalNumLetters,sentence);
				
				System.out.print("Please enter an input word: ");
				String word = scan.nextLine();
				
				totalNumWords = updateWordCount(totalNumWords,word);
				totalNumLetters = updateLetterCount(totalNumLetters,word);
				
				int count = 0;  
		          
		        for(int i = 0; i < sentence.length()-1; i++) {  // we will find the size of the array
		        	if (sentence.charAt(i) == ' ' && Character.isLetter(sentence.charAt(i+1)) && (i > 0)) {  
		                count = count + 1;  
		            }  
		        }  
		        
		        count = count + 1;
		    
		        String[] arr = new String[count]; // we created array that will be used as parameter
		        int index = 0;
		        
		        for (int i = 0; i < sentence.length()-1;){ // we assigned the splitted words to array
		        	int lengh = sentence.indexOf(" ",i); 
		        	
		        	if (lengh == -1){
		        		lengh = sentence.length();
		        	}
		        	
		        	arr[index] = sentence.substring(i,lengh);
		        	index = index + 1;
		    		i = lengh+1;
		       }
		        int result = countOccurences(arr,word);
		        System.out.println(word + " appears " + result + " time(s) in the sentence.");
				
			}
			
			if (option == 3) {
				System.out.print("Please enter an input String: ");
				String sentence = scan.nextLine();
				
				System.out.print("Enter an integer pattern: ");
				int pattern = scan.nextInt();
				
				totalNumWords = updateWordCount(totalNumWords,sentence);
				totalNumLetters = updateLetterCount(totalNumLetters,sentence);
				
				String returnedStr = encryption(sentence,pattern);
				
				System.out.println("Source: " + sentence);
				System.out.println("Encrypted: " + returnedStr);
				
			}
			
			if (option == 4) {
				printStat(totalNumWords,totalNumLetters);
			}
			
			if (option == 5) {
				System.out.println("Program ends. Bye :)");
				break;
			}
		}
	}
	
	public static String changeCase (String str) {
		String s = ""; // we will return this value
		
		for (int i = 0; i < str.length(); i++) { 
			char buffer = str.charAt(i);
			
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') { //check if it is lowercase
				s = s + Character.toUpperCase(buffer);
			}
			else {
				s = s + Character.toLowerCase(buffer); //check if it is uppercase
			}
			
		}
		return s;
	}

	public static int countOccurences (String[] sentence, String word) {
		int counter = 0 ;
		
	    for (int i = 0; i < sentence.length; i++) {
	    	if ( sentence[i].equalsIgnoreCase(word)) { // check if its occurs
	    		counter = counter + 1;
	    	}
	    }
	    return counter;
	}
	
	public static int updateWordCount(int count, String str) {
		for(int i = 0; i < str.length()-1; i++) {  
			if(str.charAt(i) == ' ' && Character.isLetter(str.charAt(i+1)) && (i > 0)) {  
				count = count + 1;  
	        }  
	    }  
	        
		count = count + 1; 
		return count;
	}
	
	public static int updateLetterCount(int count, String str) {
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i)))
				count = count + 1;
			}

		return count;
	}
	
	public static void printStat (int wordCount, int letterCount) {
		System.out.println("The number of words: " + wordCount);
		System.out.println("The number of alphabetic letters: " + letterCount);
	}
	
	public static String encryption (String str, int pattern) {
		int letter = 0;
    	String newStr = "";
    	String lastStr ="";
    	
    	
    	for (int i = 0; i < str.length(); i++) {
    		
    		if (str.charAt(i) != ' ') {	
    			char buffer = str.charAt(i);
    			
    			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
    				newStr = newStr + Character.toUpperCase(buffer);
    			}
    			else {
    				newStr = newStr + buffer;
    			}
  
    			letter += 1;
    		}
    		
    	}
    
    	char[][] arr = new char[pattern][letter];
    	int row = 0;
    	int column = 0;
    	int buffer = 0;
    	int flag = 0;
    	
    	if (pattern == 2) {
    		for (int i = 0; i < newStr.length(); i = i + 2) {
    			lastStr = lastStr + newStr.charAt(i);
    		}
    		
    		for (int i = 1; i < newStr.length(); i = i + 2) {
    			lastStr = lastStr + newStr.charAt(i);
    		}
    	}
    	
    	else {
	    	
	    	for (int i = 0; i < newStr.length(); i++) {
	    		
	    		if (buffer < pattern) {
	    	
	    			arr[row][column] = newStr.charAt(i);
	    			row = row + 1;
	    			column = column + 1;
	    			buffer = buffer + 1;
					
					if (buffer == pattern) {
						flag = 1;
						row = row - 2;
						continue;
					}
	    		}
	    		
	    		
	    		if (flag == 1) {
				
	    			arr[row][column] = newStr.charAt(i);
	    			row = row - 1;
	    			column = column + 1;
	    		
	    		
	    			if (row == 0) {
	    				buffer = 0;
	    				flag = 0;
	    			}	
	    		}	
	    	}
    	}
    	

    	for (int m = 0 ; m < arr.length; m ++) {
    		for ( int j = 0; j < arr[0].length; j++) {
    			if ( arr[m][j] != '\0') {
    				lastStr = lastStr + (arr[m][j]);
    			}
    		}
    	}
    	return lastStr;
    }
		
	}

