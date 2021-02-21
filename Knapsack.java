package knapsack;

public class Knapsack {
	public static void main(String[] args) {
		int N = 13; //number of items
		int W =700; //max weight of knapsack
		
		int[] rating = {0,5,9,6,8,8,4,2,8,5,9,7,4};
		int[] weight = {0,36,264,188,203,104,7,90,65,75,170,80,27};
		
		
		//opt[n][w] = max rating of packing items 1..n with weight limit w
		//solution[n][w] = does opt solution to pack items 1..n with weight limit w include item n?
		int[][] opt = new int[N+1][W+1];
		boolean[][] solution = new boolean[N+1][W+1];
		
		for(int n=1; n < N; n++) {
			for(int w = 1; w <= W; w++) {
				//don't take item n
				int option1 = opt[n-1][w];
				
				//take item n
				int option2 = Integer.MIN_VALUE;
				if(weight[n] <= w) option2 = rating[n] + opt[n-1][w-weight[n]];
				
				//select better of two options
				opt[n][w] = Math.max(option1, option2);
				solution[n][w] = (option2 > option1);
			}
		}
		
		//determine which items to take
		boolean[] take = new boolean[N];
		for(int n = N-1, w = W; n > 0; n--) {
			if(solution[n][w]) {
				take[n] = true;
				w = w-weight[n];
			} else take[n] = false;
		}
		
		System.out.println("item\trating\tweight\ttake\n-----------------------------");
		for(int n = 0; n < N; n++) {
			System.out.println((n) + "\t" + rating[n] + "\t" + weight[n] + "\t" + take[n]);	
		}
		System.out.println();
		int totalW = 0;
		int totalR = 0;
		for(int i =0; i < take.length; i++) {
			if(take[i]) {
				System.out.println("item: " + i + " rating: " + rating[i] + " weight: " + weight[i]);
				totalW += weight[i];
				totalR += rating[i];
			}
		}
		System.out.println("\nTotal Weight: " + totalW + "\nTotal Rating: " + totalR);
	}
}
