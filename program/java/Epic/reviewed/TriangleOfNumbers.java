import java.util.List;
import java.util.ArrayList;

public class TriangleOfNumbers {
	public static void main(String[] args) {
		int[] input = new int[] { 4, 7, 3, 6, 7 };
        /*
		print(input);
		display(input);
        */
        List<List<Integer>> rst = genTriangle(input);
        for(List<Integer> x : rst){
            for(Integer y : x)
                System.out.print(y + ",");
            System.out.println();
        }
	}
    
    public static List<List<Integer>> genTriangle(int[] arr){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(arr == null || arr.length == 0) return output;
        List<Integer> entry = new ArrayList<Integer>();
        for(int x : arr) 
            entry.add(x);
        helper(arr, entry, output);
        output.add(entry);
        return output;
    }
    private static void helper(int[] arr, List<Integer> entry, List<List<Integer>> output){
        if(entry.size() == 1) return;
        List<Integer> newentry = new ArrayList<Integer>();
        for(int i = 0;i + 1 < entry.size();i++)
            newentry.add(entry.get(i) + entry.get(i + 1));
        helper(arr, newentry, output);
        output.add(newentry);
    } 

    /*
	static void print(int[] input) {
		if (input != null && input.length > 0) {
			int newLength = input.length - 1;
			int newArray[] = new int[newLength];
			for (int i = 0; i < input.length - 1; i++) {
				newArray[i] = input[i] + input[i + 1];
			}
			print(newArray);
			display(newArray);
		}
	}

	private static void display(int[] input) {
		if (input != null && input.length > 0) {
			for (int i = 0; i < input.length; i++) {
				System.out.print(input[i]);
				if (i + 1 < input.length) {
					System.out.print(", ");
				}
			}
		}
	}
    */
}
