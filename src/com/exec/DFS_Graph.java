package com.exec;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DFS_Graph {

	static Map<Integer, ArrayList<Integer>> graphRep = new HashMap<Integer, ArrayList<Integer>>();
	static ArrayList<Integer> visitedMap = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<SimpleEntry<Integer, Integer>> graph = new ArrayList<SimpleEntry<Integer,Integer>>();
		graph.add(new SimpleEntry(1, 2));
		graph.add(new SimpleEntry(2, 3));
		graph.add(new SimpleEntry(3, 5));
		graph.add(new SimpleEntry(5, 4));
		graph.add(new SimpleEntry(4, 1));
		graph.add(new SimpleEntry(4, 6));
		graph.add(new SimpleEntry(6, 3));

		
		for(SimpleEntry<Integer, Integer> edge : graph)
		{
			int source = edge.getKey();
			int destination = edge.getValue();
			
			ArrayList<Integer> connectingNodes = null;
			if(graphRep.containsKey(source))
			{
				connectingNodes = graphRep.get(source);
				connectingNodes.add(destination);
			}
			else
			{
				connectingNodes = new ArrayList<Integer>();
				connectingNodes.add(destination);
				graphRep.put(source, connectingNodes);
			}
		}
		
		int point1 = 1;
		int point2 = 6;
		
		DFS(point1);
		
		if(visitedMap.contains(point2))
		{
			System.out.println("There Exists a Path between Node1: " + point1 + "  to Node2: " + point2);
		}
		else
		{
			System.out.println("There Exists NO Path between Node1: " + point1 + "  to Node2: " + point2);
		}
	}
	
	public static void DFS(int node)
	{
		if(visitedMap.contains(node))
		{
			return;
		}
		else
		{
			visitedMap.add(node);
			for(int connectionNode :graphRep.get(node))
			{
				DFS(connectionNode);
			}
		}
	}

}
