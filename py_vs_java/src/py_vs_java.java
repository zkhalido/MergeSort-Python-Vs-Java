import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class py_vs_java {

	void merge(int[] list, int l, int m, int r) {
		int num1 = m - l + 1;
		int num2 = r - m;
		
		int left[] = new int[num1];
		int right[] = new int[num2];
		
		for (int i = 0; i < num1; ++i) {
			left[i] = list[l + i];
		}
		
		for (int j = 0; j < num2; ++j) {
			right[j] = list[m + 1 + j];
		}
		
		int i = 0;
		int j = 0;
		
		int k = l;
		
		while (i < num1 && j < num2) {
			if (left[i] <= right[j]) {
				list[k] = left[i];
				i++;
			}
			else {
				list[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i < num1) {
			list[k] = left[i];
			i++; 
			k++;
		}
		
		while (j < num2) {
			list[k] = right[j];
			j++;
			k++;
		}
	}
	
	void sort(int[] list, int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			
			sort(list, l, m);
			sort(list, m + 1, r);
			
			merge(list, l, m, r);
		} 
    }


	public static void main(String args[]) throws FileNotFoundException{   
		py_vs_java myalgo = new py_vs_java();
		
		File numFile = new File("py_vs_X_assign2.txt");
		   
		Scanner scnr = new Scanner(numFile);
		   
		ArrayList<Integer> numList = new ArrayList<Integer>();
	
		while(scnr.hasNextLine()) {
			numList.add(Integer.parseInt(scnr.nextLine()));
		}
		   
		scnr.close();
		   
		int list[] = new int[numList.size()];
		int i = 0;
		   
		for(Integer s : numList) {
			list[i] = s;
			i++;
		}
		   
		System.out.print("before merge, list1[:10] = ");
		for(int j = 0; j < 10; j++) {
			System.out.print(list[j] + " ");
		}
		System.out.println();
		   
		long start = System.currentTimeMillis();
	    myalgo.sort(list, 0, list.length - 1);
	    long end = System.currentTimeMillis();      
	
	    System.out.print("after merge,  list1[:10] = ");
		for(int j = 0; j < 10; j++) {
			System.out.print(list[j] + " ");
		}
		System.out.println();
		   
	    System.out.println("Algorithm runtime (in milliseconds): " + (end-start));
	
	}
}