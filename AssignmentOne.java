package classes;

import java.util.HashSet;
import java.util.Set;

class AssignmentOne {

	public static void main(String as[]) {
		
		//Works for only 2 inputs
		String in1 = "AABAABAA";
		//String in1 = "AABAAAABAA";
		int in2 = 1;
		int in3 = 8;
		System.out.println(new AssignmentOne().maxDistance(in1, in2, in3));
		
	}
	
	public int maxDistance(String input1, int input2, int input3) {
		//String to CharArray
		char[] str = input1.toUpperCase().replaceAll("\\s", "").toCharArray();
		//Pass CharArray to Set to know different characters in String
		Set<String> uniqueDiffChars = new HashSet<String>();
		for(int i = 0; i < input3; i++){
			uniqueDiffChars.add(String.valueOf(str[i]));
		}
		
		//Calculations
		boolean isInput1Calculated = false;
		String chr = null;
		int difference = 0;
		int indexValue = 0;
		int position = 0;
		
		for( ; uniqueDiffChars.iterator().hasNext(); ) {
			int max = 0;
			//--------------------
			if (!isInput1Calculated) {
				position = input2;
				chr = String.valueOf(str[input2]);
				indexValue = position + 1;
			} else {
				position = input1.indexOf(uniqueDiffChars.iterator().next());
				chr = uniqueDiffChars.iterator().next();
				indexValue = position + 1;
			}
			//--------------------
			while ((indexValue < input3) && (!chr.equals(String.valueOf(str[indexValue])))) {
				max++;
				indexValue++;
			}
			//--------------------
			difference = position - max;
			isInput1Calculated = true;
			uniqueDiffChars.remove(chr);
		}
		
		return Math.abs(difference);
	}
}

