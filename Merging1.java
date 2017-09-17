import java.util.*;
import java.util.Scanner;
import java.lang.*;
import java.util.Arrays;
import java.util.Random;

class Merging1 {
	public static void main(String[] args) {
		
		
		Random rand = new Random();
		int inp = rand.nextInt((1000+1-1)-1);
		int inputArr[] = new int[inp];
		for(int flag = 0; flag< inp ; flag++){
			inputArr[flag] = rand.nextInt(100000+1+100000) - 100000 ;
		}
		System.out.println(
		Arrays.toString(inputArr));
		splitArray(inputArr,0,inp-1);
		System.out.println("Sorted Array Is");
		System.out.println(
		Arrays.toString(inputArr));

	}

	static void swap(int inputArr[],int a,int b){
		inputArr[a]=inputArr[a]^inputArr[b];
		inputArr[b]=inputArr[a]^inputArr[b];
		inputArr[a]=inputArr[a]^inputArr[b];
	}

	
	static void upgrade(int inputArr[],int start,int middler){
		for(int sat=middler;sat>start;sat--){
			inputArr[sat]=inputArr[sat-1];
		}
	}

	static void splitArray(int inputArr[],int start,int size){
		if(start>=size){
			return;
		}
		else if(size-start==1){
			if(inputArr[start]>inputArr[size])
				swap(inputArr,start,size);
			return;
		}
		else{

			int middle = (start+size)/2;

			splitArray(inputArr,start,middle);
			splitArray(inputArr,middle+1,size);
			inPlaceMerge(inputArr,start,middle,size);
		}
		
	}

	static void inPlaceMerge(int inputArr[],int start, int middle, int size){
		while(start<=middle && middle+1 <=size){
			if( inputArr[start] > inputArr[middle+1]){
				int temp=inputArr[middle+1];
				upgrade(inputArr, start,middle+1);
				inputArr[start]=temp;
				start++;
				middle++;
			}
			else{
				start++;
			}
		}
	}
}