package com.exec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Edge implements Comparable<Edge>{
	
	int source;
	int dest;
	int cost;
	
	public Edge(int source, int dest, int cost)
	{
		this.source = source;
		this.dest = dest;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge E1) {
		// TODO Auto-generated method stub
		return this.cost - E1.cost;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "U: " + this.source + "  V: " + this.dest + "  Cost: " + this.cost;
		return str;
	}

}

public class Kruskals {

	static int[] parent = new int[10];
	static List<Edge> edgeList = new ArrayList<Edge>();
	
	public static int findSet(int node)
	{
		while (parent[node] != node)
		{
			node = parent[node];
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		edgeList.add(new Edge(1, 2, 10));
		edgeList.add(new Edge(1, 5, 50));
		edgeList.add(new Edge(2, 3, 10));
		edgeList.add(new Edge(2, 4, 10));
		edgeList.add(new Edge(3, 4, 50));
		edgeList.add(new Edge(4, 5, 10));
		
		Collections.sort(edgeList);
		
		for(int i=0; i<edgeList.size(); i++)
		{
			parent[i] = i;
		}
		
		int totalCost = 0;
		List<Edge> mstEdgeList = new ArrayList<Edge>();
		for(int i =0; i < edgeList.size(); i++)
		{
			Edge edge = edgeList.get(i);
			int u = edge.source;
			int v = edge.dest;
			
			if(findSet(u) != findSet(v))
			{
				parent[v] = u;
				totalCost += edge.cost;
				mstEdgeList.add(edge);
			}
		}
		
		System.out.println("Total Wt of spanning Tree: " + totalCost);
		System.out.println("Edges: ");
		
		for(int i =0; i < mstEdgeList.size(); i++)
		{
			System.out.println("   " + mstEdgeList.get(i).toString());
		}
		
	}

}
