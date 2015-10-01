package com.exec;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {

		static int[] heapList = {2,8,5,10,6};
		static int length = heapList.length;
	
	public static int getLeft(int index){
		int left = 2*index;
		if(left >= length)
		{
			left = -1;
		}
		return left;
	}
	
	public static int getRight(int index){
		int right = 2*index + 1;
		if(right >= length)
		{
			right = -1;
		}
		return right;
	}
	
	public static void max_heapify(int index) {
		
		int left = getLeft(index);
		int right = getRight(index);
		int max = index;
		
		if(left != -1 && heapList[left] > heapList[max])
		{
			max = left;
		}
		if(right != -1 && heapList[right] > heapList[max])
		{
			max = right;
		}
	
		if(max != index)
		{
			int temp = heapList[index];
			heapList[index] = heapList[max];
			heapList[max] = temp;
			
			max_heapify(max);
		}
	}
	
	public static void build_max_heap() {
		
		for(int i = (heapList.length/2)-1; i >= 0; i--)
		{
			max_heapify(i);
		}
	}
	
	public static void heap_sort() {
		build_max_heap();
		//print();
		for(int i = heapList.length-1; i > 0; i--)
		{
			int temp = heapList[0];
			heapList[0] = heapList[length-1];
			heapList[length-1] = temp;
			
			//print();
			length = length -1;
			
			max_heapify(0);
		}
		
	}
	
	public static void print() {
		
		//System.out.println("\n ARRAY - ");
		for(int i=0; i < heapList.length; i++)
		{
			System.out.print(" " + heapList[i]);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//heap_sort();
		System.out.println("Orignal Array- ");
		print();
		heap_sort();
		System.out.println("\nSorted Array- ");
		print();
	}

}
