import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

class HeapSortTop {
	private static Scanner sc;

	public static void main(String args[]) {
		
		Random rand = new Random();

		System.out.println("Enter no of terms");
		int n = rand.nextInt(100+1-1) + 1;

		System.out.println("Enter the terms");
		int arr[] = new int[n];
		for ( int i = 0; i < n; i++)
			
			arr[i] = rand.nextInt(1000+1+1000) -1000;

		System.out.println("The unsorted array is:");
		System.out.println(Arrays.toString(arr));

		buildheap(arr);
		System.out.println("heaped");
		System.out.println(Arrays.toString(arr));

		heap(arr);

		System.out.println("The sorted array is:");
		System.out.println(Arrays.toString(arr));
	}

	static void heapify(int a[], int n, int i) {
		int max, child;
		child = 2 * i + 1;
		max = i;
		if ( (child < n) )
			if (a[child] > a[max])
				max = child;

		if( child + 1 < n )
			if (a[child + 1] > a[max]){
				max = child + 1;
			}

		if (max != i) {
			int temp = a[i];
			a[i] = a[max];
			a[max] = temp;
			heapify(a, n, max);
		}
	}

	static void buildheap(int a[]) {
		int i = a.length / 2 - 1;
		if(i >= 0){
			headForHeap(a,i);
		}
	}
	static void headForHeap(int a[],int input){
		int feed=input;
		if(feed>=0){
			heapify(a,a.length,feed);
			feed--;
			headForHeap(a,feed);
		}
	}

	static void heap(int a[]) {
		buildheap(a);
		int i = a.length - 1;
		startToSort(a,i);
	}
	static void startToSort(int a[],int input){
		int i=input;
		if(i >= 1) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			/*from iteration to recursion,ALWAYS CALL THE FUNCTION THATS DONE WITHIN LOOP THEN ONLY CHANGE THE FLAG VARIABLE,AS DONE IN A LOOP*/
			heapify(a,i, 0);
			i--;
			/*FOR THE SAKE OF REPEATING AFTER INCREASING THE FLAG VARIABLE CALL THE SAME FUNCTION IN WHICH WE ARE AGAIN*/
			startToSort(a,i);
		}
	}
}