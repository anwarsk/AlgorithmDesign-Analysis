package com.exec;

import java.awt.PageAttributes.PrintQualityType;
import java.util.ArrayList;
import java.util.List;

public class FloydWarshallAlgorithm {

	static int[][]d = new int[10][10];
	static int[][] inter = new int[10][10];
	static List<Edge> edgeList = new ArrayList<Edge>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nodeCount  = 5;
		
		edgeList.add(new Edge(1, 2, 10));
		edgeList.add(new Edge(1, 5, 50));
		edgeList.add(new Edge(2, 3, 10));
		edgeList.add(new Edge(2, 4, 10));
		edgeList.add(new Edge(3, 4, 50));
		edgeList.add(new Edge(4, 5, 10));
		
		for(int i =0; i<10; i++)
		{
			for(int j =0; j<10; j++)
			{
				if(i==j)
				{
					d[i][j] = 0;
				}
				else
				{
					d[i][j] = getEdgeWt(i,j);
				}
				inter[i][j] = j;	
			}
		}
		
		for(int i=1; i<=nodeCount; i++)
		{
			for(int j=1; j<=nodeCount; j++)
			{
				for(int k=1; k<=nodeCount; k++)
				{
					if(d[i][j] > d[i][k]+d[k][j])
					{
						d[i][j] = d[i][k]+d[k][j];
						inter[i][j] = k;
					}
				}
			}
		}
		
		for(int i =1; i<=nodeCount; i++)
		{
			for(int j =1; j<=nodeCount; j++)
			{
				System.out.print("\n Path " + i  + " TO " + j + ": " + i);
				printPath(i, j);
				
			}
		}
	}
	
	public static int getEdgeWt(int u, int v)
	{
		int wt =  999999;
		for(Edge e: edgeList)
		{
			if(e.source == u && e.dest == v)
			{
				wt = e.cost;
				break;
			}
		}
		return wt;
	}

	public static void printPath(int u, int v)
	{
		if(inter[u][v] == 999999)
		{
			return;
		}
		
		if(inter[u][v] == 0)
		{
			return;
		}
		
		if(inter[u][v] == v)
		{
			System.out.print("->" + v);
			return;
		}
		
		printPath(u, inter[u][v]);
		printPath(inter[u][v], v);
	}
}
