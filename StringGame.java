import java.util.*;

public class StringGame {

	public static void main(String[] args) {

		//Objects
		Scanner userinput = new Scanner(System.in); //scanner for user input
		Random random = new Random(); //Random object 
		
		//ints arrays, variables etc
		String wordList = "sheet,kettle,star,picture,heroes,oven,table";
		String[] wordListArray =  wordList.split(",");
		
		int randomise = random.nextInt(wordListArray.length);
		int counter = 1;
		
		String selectedWord = wordListArray[randomise];
		String userWord = "";
		
/*		selectedWord = scrambleWord(random, selectedWord);*/
		
		System.out.print("The word selected is: " + scrambleWord(random, selectedWord) + "\n");
		System.out.print("You have three attempts to guess the correct word. \n");
		System.out.print("");
		
		while(counter != 4){
			System.out.print("Attempt Number " + counter + ": ");
			userWord = userinput.nextLine();
			
			if(userWord.equals(selectedWord)){
				System.out.print("Congratulations you won!");
				System.exit(0);
			}

			counter++;
		}
	}
	
	public static String scrambleWord(Random random, String input){
		
		//Convert string to char array
		char array[] = input.toCharArray();
		
		//Scramble letters  using Fisher-Yates shuffle algorithm
		for (int i = 0; i < array.length-1; i++){
			int jumble = random.nextInt(array.length-1);
			char tempVariable = array[i]; 
								array[i] = array[jumble]; 
								array[jumble] = tempVariable;
		}
		
		return new String(array);
	}
}