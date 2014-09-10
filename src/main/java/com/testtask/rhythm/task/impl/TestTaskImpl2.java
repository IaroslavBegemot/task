package com.testtask.rhythm.task.impl;

import java.util.List;

import com.testtask.rhythm.task.TestTask;

public class TestTaskImpl2 implements TestTask {

	public List<Integer> findHighestSums(int[][] lists, int n) {

		return null;
	}

	public void test(int[][] lists) {
		int[] column = new int[lists.length];
		for (int i = 0, j = 1; i < lists.length; j++) {
			for (; j < lists[i].length; i++) {
				column[i] = lists[i][0] - lists[i][j];
				System.out.println("column[i] = " + column[i]);

			}
		}
		int minCol = findMinColumnIndex(column);

		System.out.println("column = " + column);
		System.out.println("minCol = " + minCol);

	}

	private int findMinColumnIndex(int[] a) {
		int minIndex = 0;
		int m = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			// m = m <= a[i] ? m : a[i];
			minIndex = m <= a[i] ? minIndex : i;

		}
		return minIndex;
	}
}
