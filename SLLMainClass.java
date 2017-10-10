import java.util.Scanner;
import java.io.File;

public class SLLMainClass {

	public static SortedSLLClass ParseArray(String file_name){
	    Scanner sc = null;
	    int tmpi;	    
	    SortedSLLClass myssll = new SortedSLLClass();
	    try {
	        sc = new Scanner(new File(file_name));
		    while (sc.hasNext()) {
		    	tmpi = sc.nextInt(); 
		    	myssll.insert(tmpi);
		    	System.out.print(tmpi + " ");
		    }
		    System.out.println("");
		    sc.close();
		    return myssll;
	    } catch (Exception e) {
	        return null;
	    }
	}
	
	public static void main(String[] args) {
		int n = args.length;	// number of lists to read
		if(n <= 0)
			return;

		long startTime, endTime, totalTime;
		String fname;
		
		startTime = System.currentTimeMillis();

		SortedSLLClass[] ssll_list = new SortedSLLClass[n];
		for(int i = 0; i < n; ++i){
			fname = args[i];
		    System.out.println("Input "+i + ": ");
			ssll_list[i] = ParseArray(fname); // read one list
			if(ssll_list[i] == null){	
				// if invalid input file, print NULL and exit
				System.out.println("NULL");
				System.out.println("Error parsing file: "+fname);
				return;
			}
		}
		
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("List constructing time: " + totalTime );
		
		// naive implementation
		startTime = System.currentTimeMillis();
		SortedSLLClass merged_naive = new SortedSLLClass( ssll_list[0] ); // copy the first list into merged_naive
		for(int i = 1; i < n; ++i)
			merged_naive.merge_naive(ssll_list[i]);
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Naive merging result: ");
		
		// output the final result
		int[] naive_result = merged_naive.getAllElements();
		for(int i = 0; i < naive_result.length; i++)
			System.out.print(naive_result[i] + " ");
		System.out.println(" ");
		System.out.println("Naive merging time: " + totalTime );

		// smart implementation
		startTime = System.currentTimeMillis();
		SortedSLLClass merged_smart = new SortedSLLClass( ssll_list[0] ); // copy the first list into merged_naive
		for(int i = 1; i < n; ++i)
			merged_smart.merge_smart(ssll_list[i]);
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Smart merging result: ");
		
		// output the final result
		int[] smart_result = merged_smart.getAllElements();
		for(int i = 0; i < smart_result.length; i++)
			System.out.print(smart_result[i] + " ");
		System.out.println(" ");
		System.out.println("Smart merging time: " + totalTime );

	}
}
