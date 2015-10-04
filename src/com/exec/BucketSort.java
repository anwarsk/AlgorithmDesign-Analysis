package com.exec;

import java.util.Random;

 class Node{
	
	public Node(double number, Node nextNode){
		data = number;
		next = nextNode;
	}
	
	double data;
	Node next;
}


public class BucketSort {
	

	/* This function genrates the random float numbers in range 0 to 1 */
	public static double[] generateRandomValues(int count){
	
		double[] numbers = new double[count];
		for(int i =0; i < count; i++)
		{
			Random random = new Random();
			numbers[i] = random.nextFloat();
		}
		return numbers;
	}
	
	public static Node insertNode(Node root, double number)
	{
		Node node = root;
		Node currentNode = new Node(number, null);
		
		if(node != null)
		{
			Node prev = null;
			while(node != null && node.data < number){ // Finding the 2 nodes between which we have to insert node. 
				prev = node;
				node = node.next;
			}
			
			currentNode.next = node;
			if(prev != null)
			{
				prev.next = currentNode;
			}
			else // If previous is null then its the first element to add.
			{
				root = currentNode;
			}
		}
		else{
			root = currentNode;
		}
		
		return root;
	}
	
	public static void print(double[] array){
		
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
	
	public static void bucketSort(double[] array)
	{
		Node[]sortedArray = new Node[array.length];
		
		for(int i=0; i<array.length; i++)
		{
			sortedArray[i] = null;
		}
		
		for(int i=0; i<array.length; i++)
		{
			int index = (int)Math.floor(array[i] * array.length);
			sortedArray[index] = insertNode(sortedArray[index], array[i]);
		}
		
		//Print sorted array
		System.out.println("\nSorted Array: ");
		for(int i=0; i<sortedArray.length; i++)
		{
				Node node = sortedArray[i];
				while(node != null)
				{
				  System.out.print(node.data + " ");
				  node = node.next;
				}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] array = generateRandomValues(10);
		System.out.println("Original Array: ");
		print(array);
		bucketSort(array);
		
	}

}
