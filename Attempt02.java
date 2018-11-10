package Mettl;

import java.util.HashMap;
import java.util.Map;

public class Attempt02 {

	public static void main(String[] args) {

		int input1 = 5;
		int[] input2 = new int[] { 5, 4, 3, 2, 1 };
		int[] input3 = new int[] { 1, 2, 3, 4, 5 };
		int input4 = 3;
		int input5 = 3;

		System.out.println(profit(input1, input2, input3, input4, input5));
	}

	public static int profit(int input1, int[] input2, int[] input3, int input4, int input5) {
		int i = 0, max = 0, index = 0, sum = 0;
		Map<String, Integer> map = new HashMap<>();

		// Handle second array input3
		while (i < input5) {
			max = input3[0];
			for (int j = 0; j < input1; j++) {
				if (input3[j] > max) {
					max = input3[j];
					index = j;
				}
			}
			// Handle index with same value
			map.put(index + "~" + max, max);
			// Replace max value with -1 to avoid recursion
			input3[index] = -1;
			i++;
		}

		i = 0; // Re-initialize to 0
		index = 0; // Re-initialize to 0
		// Handle first array input2
		while (i < input4) {
			max = input2[0];
			for (int j = 0; j < input1; j++) {
				if (input2[j] > max) {
					max = input2[j];
					index = j;
				}
			}
			// Handle index with same value
			map.put(index + "~" + max, max);
			// Replace max value with -1 to avoid recursion
			input2[index] = -1;
			i++;
		}

		// Add the values of the map to get the sum
		for (Map.Entry<String, Integer> entity : map.entrySet()) {
			sum += entity.getValue();
		}

		return sum; // Return sum
	}
}
