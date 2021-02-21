/**
 * 
 */
package review1;

import java.util.Scanner;

/**
 * Part 1 of Java Review. Creates a 1D array and finds index of the
 * value that the user inputs if valid.
 * @author Kim Harvey
 *
 */
public class PartOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[] {39,46,10,37,33,4,30,26,14,19,29,6,43,8,35,50,
				13,25,17,48,28,3,41,34,36,38,49,16,45,2,40,15,24,7,5,9,20,1,42,
				44,21,47,12,22,18,31,11,32,27,23};
		Scanner in = new Scanner(System.in);
		int val;
		Boolean valid = false;
		int index= -1;
		try {
			do {
				System.out.println("Please enter a number between 1 and 50: ");
				val = in.nextInt();
				if((val >= 1) && (val <=50)) {
					valid = true;
				}			
			}while(valid != true);
			
			for(int i = 0; i < nums.length; i++) {
				if(val == nums[i]) {
					index = i;
					System.out.println("The number " + val + " is found on index " + index + " of the array.");
					break;
				}
			}
		} catch(Exception e) {
			System.out.println("Not a valid number.");
		} finally {
			in.close();
		}
	}
}
