package com.exec;

import java.util.ArrayList;
import java.util.List;

import org.omg.PortableServer.ServantActivator;

class Node implements Comparable<Node>
{
	public String value;
	public int frequency;
	public Node left;
	public Node right;
	
	public Node(String value, int frequency)
	{
		this.value = value;
		this.frequency = frequency;
	}

	@Override
	public int compareTo(Node node1) {
		// TODO Auto-generated method stub
		return this.frequency - node1.frequency;
	}

	
}

class PriorityQueue
{
	List<Node> nodeList;
	
	public PriorityQueue() {
		nodeList = new ArrayList<Node>();
	}
	
	public void insert(Node node)
	{
		nodeList.add(node);
		this.bubbleUp(nodeList.size()-1);
	}
	
	public Node extractMinimum()
	{
		// swap node with last element
		Node lastNode = nodeList.remove(nodeList.size()-1);
		Node minNode = null;
		if(nodeList.size() > 0)
		{
			minNode = nodeList.remove(0);
			nodeList.add(0,lastNode);

			heapify(0);
		}
		else
		{
			minNode = lastNode;
		}
		
		return minNode;
	}
	
	private void heapify(int index)
	{ 
		Node node = nodeList.get(index);
		int nodeFrequecy = node.frequency;
		int leftNodeFrequecy = Integer.MAX_VALUE;
		int rightNodeFrequecy = Integer.MAX_VALUE;
		Node leftNode = null;
		Node rightNode = null;
		
		int leftIndex = this.getLeftIndex(index);
		if(leftIndex > -1)
		{
			leftNode = nodeList.get(leftIndex);
			leftNodeFrequecy = leftNode.frequency;
		}
		
		int rightIndex = this.getRightIndex(index);
		if(rightIndex > -1)
		{
			rightNode = nodeList.get(rightIndex);
			rightNodeFrequecy = rightNode.frequency;
		}
		
		if(nodeFrequecy  > leftNodeFrequecy)
		{
			if(leftNodeFrequecy > rightNodeFrequecy)
			{
				// swap with right
				nodeList.remove(rightIndex);
				nodeList.add(rightIndex, node);
				
				nodeList.remove(index);
				nodeList.add(index, rightNode);
				
				heapify(rightIndex);			
			}
			else
			{
				// swap with left
				nodeList.remove(leftIndex);
				nodeList.add(leftIndex, node);
				
				nodeList.remove(index);
				nodeList.add(index, leftNode);
				
				heapify(leftIndex);
			}
		}
		else if(nodeFrequecy > rightNodeFrequecy)
		{
			// swap with right
			nodeList.remove(rightIndex);
			nodeList.add(rightIndex, node);
			
			nodeList.remove(index);
			nodeList.add(index, rightNode);
			
			heapify(rightIndex);
		}
		
	}
	
	private void bubbleUp(int index)
	{
		int parentIndex = this.getParentIndex(index);
		Node  node = nodeList.get(index);
		
		while(parentIndex >= 0 && nodeList.get(parentIndex).frequency > node.frequency)
		{
			node = nodeList.remove(index);
			Node parentNode = nodeList.remove(parentIndex);
			nodeList.add(parentIndex, node);
			nodeList.add(index, parentNode);
			index = parentIndex;
			parentIndex = this.getParentIndex(index);
		}
	}
	
	private int getParentIndex(float index)
	{
		return (int) ((Math.ceil(index/2))-1);
	}
	
	 private int getLeftIndex(int index){
		int left = 2*index + 1;
		if(left >= nodeList.size())
		{
			left = -1;
		}
		return left;
	}
	
	private int getRightIndex(int index){
		int right = 2*index + 2;
		if(right >= nodeList.size())
		{
			right = -1;
		}
		return right;
	}
	
	
	
	void print()
	{
		for (int i=0 ; i<nodeList.size(); i++)
		{
			System.out.print(" " + nodeList.get(i).frequency);
		}
		
//		while(nodeList.isEmpty() == false)
//		{
//			System.out.println("  ");
//			System.out.print(this.extractMinimum().frequency);
//		}
	}
	
}
public class HuffmanCoding {

	public static void printNodeTree(Node root, int level, int offset)
	{
		if(root != null)
		{
			System.out.println(" ");
			for(int i =0; i < (level*offset)/2 ; i++)
			{
				System.out.print(" ");
			}
			System.out.print(root.value + "(" + root.frequency + ")");
			printNodeTree(root.left, level+1, offset-3);
			printNodeTree(root.right, level+1, offset+3);	
		}
	}
	
	public static void printCodeTree(Node root, int level, String code)
	{
		if(root != null)
		{
			if(root.value.length() == 1)
			{
				System.out.println("\nCharacter: " + root.value +"  Freq: "+ root.frequency +"   Code: "+ code);
			}
			else
			{
				printCodeTree(root.left, level+1, code + "0");
				printCodeTree(root.right, level+1, code + "1");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue priorityQueue = new PriorityQueue();
		priorityQueue.insert(new Node("a", 8));
		priorityQueue.insert(new Node("b", 3));
		priorityQueue.insert(new Node("c", 5));
		priorityQueue.insert(new Node("d", 2));
		priorityQueue.insert(new Node("e", 9));
		priorityQueue.insert(new Node("f", 1));
		priorityQueue.insert(new Node("g", 1));

		priorityQueue.print();
		
		while(priorityQueue.nodeList.size() > 1)
		{
			Node min1 = priorityQueue.extractMinimum();
			Node min2 = priorityQueue.extractMinimum();

			Node node = new Node(min1.value+ min2.value, min1.frequency+min2.frequency);
			node.left = min1;
			node.right = min2;
			priorityQueue.insert(node);
		}
	
		printNodeTree(priorityQueue.extractMinimum(), 1, 8);
		printCodeTree(priorityQueue.extractMinimum(), 1, "");
	}

}
