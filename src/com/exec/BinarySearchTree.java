package com.exec;


class TreeNode{
	
	TreeNode(int data)
	{
		this.value = data;
	}
	
	int value;
	TreeNode left;
	TreeNode right;
}

public class BinarySearchTree {

	public static TreeNode insertNode(TreeNode root, int number){
		
		if(root == null)
		{
			TreeNode nodeToInsert = new TreeNode(number);
			root = nodeToInsert;
		}
		else if (root.value > number)
		{
			root.left = insertNode(root.left, number);
		}
		else
		{
			root.right = insertNode(root.right, number);
		}
		
		return root;
	}
	
	public static void printInOrder(TreeNode root){
		if(root != null)
		{
			printInOrder(root.left);
			System.out.print(" " + root.value);
			printInOrder(root.right);
		}	
	}
	
	public static TreeNode search(TreeNode root, int number){
		
		if(root == null)
		{
			return null;
		}
			
		if(root.value == number)
		{
			return root;
		}
		else if(root.value > number)
		{
			return search(root.left, number);
		}
		else
		{
			return search(root.right, number);
		}
		
	}
	
	public static void printArray(int[] array)
	{
		for(int i =0; i<array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
	
	public static void deleteNode(int number)
	{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {10,20,60,30,90,40,50,80};
		System.out.println("Original Array: ");
		printArray(array);
		
		TreeNode root = null;
		for(int i=0; i<array.length; i++)
		{
			root = insertNode(root, array[i]);
		}
		
		System.out.println("\n\nSorted Array:");
		printInOrder(root);
		
		
		
		int numberToSearch = 70;
		if(search(root, numberToSearch) != null)
		{
			System.out.println("\nNumber " + numberToSearch + " found in the BST.");
		}
		else
		{
			System.out.println("\nNumber " + numberToSearch + " NOT found in the BST.");
		}
	}

}
