package com.testtask.rhythm.task.impl;

import java.util.ArrayList;
import java.util.List;

import com.testtask.rhythm.task.TestTask;

public class TestTaskImpl2 implements TestTask {

	public List<Integer> findHighestSums(int[][] lists, int n) {

		List<Integer> result = new ArrayList<Integer>();// result
		List<Integer> firstColumn = new ArrayList<Integer>();// first column of inputed matrix

		List<Integer> diffColumn = getFirstAndDiffColumnAndFirstHighestSum(lists, result, firstColumn);// column with difference from highest sum

		int i = 0;
		while (i < n - 1 && !diffColumn.isEmpty()) {// iterate over amount of needed highest sums or return all available (first highest sum
																								// we already have) 
			int minRowIndex = findMinColumnIndex(diffColumn);// finding index of row with minimum value of odds
			iteration(result, diffColumn, firstColumn, lists, minRowIndex);// main body of algorithm
			i++;
		}

		return result;
	}

	private List<Integer> getFirstAndDiffColumnAndFirstHighestSum(int[][] lists, List<Integer> result, List<Integer> firstColumn) {
		List<Integer> diffColumn = new ArrayList<Integer>();
		int summ = 0;

		for (int i = 0; i < lists.length; i++) {// iterate over columns, filling first column and calculating first highest sum
			firstColumn.add(lists[i][0]);
			summ += lists[i][0];

			if (lists[i].length <= 1) { // if row have only one element than going to next row
				continue;
			}
			if(lists[i][1] > 0){
				diffColumn.add(lists[i][0] - lists[i][1]);// filling column with difference from highest sum
			} else {
				diffColumn.add(lists[i][0] + Math.abs(lists[i][1]));
			}
			
		}
		result.add(summ);
		return diffColumn;
	}

	private void iteration(List<Integer> result, List<Integer> diffColumn, List<Integer> firstColumn, int[][] input, int rowIndex) {

		result.add(result.get(0) - diffColumn.get(rowIndex)); // calculating highest sum

		if (input[rowIndex].length > 0) { // if row have more than one element than remove first element in row
			int[] temp = new int[input[rowIndex].length - 1];
			System.arraycopy(input[rowIndex], 1, temp, 0, temp.length);
			input[rowIndex] = temp;
		}

		if (input[rowIndex].length > 1) {// if row have more than two elements calculate difference, otherwise remove
			if(input[rowIndex][1] > 0){
				diffColumn.set(rowIndex, firstColumn.get(rowIndex) - input[rowIndex][1]);
			} else {
					diffColumn.add(firstColumn.get(rowIndex) + Math.abs(input[rowIndex][1]));
				}
		} else {
			diffColumn.remove(rowIndex);
		}
	}

	private int findMinColumnIndex(List<Integer> a) {
		int minIndex = 0;
		int m = Integer.MAX_VALUE;
		for (int i = 0; i < a.size(); i++) {
			if (m > a.get(i)) {
				minIndex = i;
				m = a.get(i);
			}
		}
		return minIndex;
	}

}
