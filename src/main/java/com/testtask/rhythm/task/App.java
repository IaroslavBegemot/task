package com.testtask.rhythm.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.testtask.rhythm.task.impl.TestTaskImpl2;
import com.testtask.rhythm.task.utils.MergeSort;

public class App {
	public static void main(String[] args) {
		
		final int nm = 1000;

		// int[][] lists = { { 4, -1 }, { 5, 0, 0 }, { 5, 4, 3, 2, 1 }, { 6, 4, 2 },
		// { 1 } };

		int[][] lists = { { 4, -1 }, { 5, 0, 0 }, { 5, 4, -1, -2, -3 }, { 6, 4, 2 }, { 1 }, { 0, -1, -2, -3, -4 } };
		TestTask task = new TestTaskImpl2();

		List<Integer> result = task.findHighestSums(lists.clone(), 100);
		System.out.println("findHighestSums(lists, 100) = " + result);

		result = task.findHighestSums(lists.clone(), 5);
		System.out.println("findHighestSums(lists, 5) = " + result);

//		 Random integer test
		 Random random = new Random();
		
		 List<int[]> outer = new ArrayList<int[]>();
		
		 int rows = random.nextInt(nm) + 1;
		 System.out.println("Random generation start");
		
		 for (int i = 0; i < rows; i++) {
		 int cols = random.nextInt(nm) + 1;
		
		 int[] inner = new int[cols];
		 for (int j = 0; j < cols; j++) {
		 inner[j] = random.nextInt(100)-50;
		 }
		 int[] innerArray = MergeSort.mergeSort(inner);
		 outer.add(innerArray);
		 }
		
		 lists = new int[outer.size()][];
		 lists = outer.toArray(lists);
		
		 System.out.println("Random generation end");
		 System.out.println("Random generated lists");
		
		 for (int i = 0; i < lists.length; i++) {
		 for (int j = 0; j < lists[i].length; j++) {
		 System.out.format("%4d", lists[i][j]);
		 }
		 System.out.println();
		 }
		
		 result = task.findHighestSums(lists.clone(), 100);
		 System.out.print("result = " + result);

	}
}
