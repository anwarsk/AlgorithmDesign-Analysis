package com.exec;

import java.util.Random;

class Node{
	double data;
	Node next;
}

public class BucketSort {

	double[] generateRandomValues(int count){
	
		double[] numbers = new double[count];
		for(int i =0; i < count; i++)
		{
			Random random = new Random();
			numbers[i] = random.nextFloat();
		}
		return numbers;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
