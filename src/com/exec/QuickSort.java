package com.exec;

public class QuickSort {

	static int partition(int[]a, int start, int end){
		int i = start;
		int j = end;
		int pivot = a[(start + end)/2];
		
		while(i <= j){
			
			while(a[i] < pivot){
				i++;
			};
			
			while(a[j] > pivot){
				j--;
			};
			
			if(i <= j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		};
		
		return i;
	}
	
	
	static void quickSort(int[]a, int start, int end){
		
		//System.out.println(start + " " + end );
		int index = partition(a, start, end);
		
		if(start < index-1)
		{
			quickSort(a, start, index-1);
		}
		
		if(end > index)
		{
			quickSort(a, index, end);
		}
	}
	
	
	public static void print(int[] heapList) {
		
		//System.out.println("\n ARRAY - ");
		for(int i=0; i < heapList.length; i++)
		{
			System.out.print(" " + heapList[i]);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {2,8,6,3,9,4};
		System.out.println("\n Original Array: ");
		print(a);
		
		quickSort(a, 0, a.length-1);
		
		System.out.println("\n Sorted Array: ");
		print(a);

	}

}
