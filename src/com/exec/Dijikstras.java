package com.exec;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class GraphNode{
	
	public int number;
	public int distance;
	
	GraphNode(int number, int distance){
		this.number = number;
		this.distance = distance;
			
	}
}

class EdgeXX{
	public GraphNode sourceNode;
	public GraphNode destNode;
	public int weight;
	
	Edge(GraphNode sourceNode, GraphNode destNode, int weight){
		this.sourceNode = sourceNode;
		this.destNode = destNode;
		this.weight = weight;
	}
}

class GraphNodeComparator implements Comparator<GraphNode>
{

	@Override
	public int compare(GraphNode node1, GraphNode node2) {
		// TODO Auto-generated method stub
		return node1.distance - node2.distance;
	}
	
}
public class Dijikstras {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<GraphNode> nodeList = new ArrayList<GraphNode>();
		List<Edge> edgeList = new ArrayList<Edge>();
			
		// Create Nodes
		for(int i=0 ; i<5; i++)
		{
			nodeList.add(new GraphNode(i, Integer.MAX_VALUE));
		}
		
		int[] previous = new int[nodeList.size()];
		
		//Create Edges
		edgeList.add(new Edge(nodeList.get(0), nodeList.get(1), 10));
		edgeList.add(new Edge(nodeList.get(0), nodeList.get(3), 5));
		edgeList.add(new Edge(nodeList.get(1), nodeList.get(2), 1));
		edgeList.add(new Edge(nodeList.get(1), nodeList.get(3), 2));
		edgeList.add(new Edge(nodeList.get(2), nodeList.get(4), 4));
		edgeList.add(new Edge(nodeList.get(3), nodeList.get(1), 3));
		edgeList.add(new Edge(nodeList.get(3), nodeList.get(2), 9));
		edgeList.add(new Edge(nodeList.get(3), nodeList.get(4), 2));
		edgeList.add(new Edge(nodeList.get(4), nodeList.get(0), 7));
		edgeList.add(new Edge(nodeList.get(4), nodeList.get(2), 6));
		
	
		GraphNodeComparator graphNodeComparator = new GraphNodeComparator();
		PriorityQueue<GraphNode> nodeQueue = new PriorityQueue<GraphNode>(graphNodeComparator);

		// Add nodes to PQ
		nodeList.get(0).distance = 0;
		previous[0] = -1;

		for(int i=0 ; i<4; i++)
		{
			nodeQueue.add(nodeList.get(i));
		}
		
		while(nodeQueue.isEmpty() == false)
		{	
			GraphNode node = nodeQueue.poll();
			for(Edge edge : edgeList){
				
				if(edge.sourceNode == node)
				{
					GraphNode destNode = edge.destNode;
					int newDistance = node.distance + edge.weight;
					
					if(newDistance < destNode.distance)
					{		
						nodeQueue.remove(destNode);
						destNode.distance = newDistance;
						
						nodeQueue.add(destNode);
						previous[destNode.number] = node.number;
					}
				}		
			}
		}

		// Print distances and path for each node 
		for(int i=0 ; i<5; i++)
		{
			System.out.print("\n\n Node: " + i + "   Distance: " + nodeList.get(i).distance + "   Path: ");
			int j = i;
			do
			{
				System.out.print( j + " < ");
				j = previous[j];
					
			}
			while(j != -1);
		}

	}
}

/*
{0, 1, 10}
{0, 3, 5}
{1, 2, 1}
{1, 3, 2}
{2, 4, 4}
{3, 1, 3}
{3, 2, 9}
{3, 4, 2}
{4, 0, 7}
{4, 2, 6}
*/