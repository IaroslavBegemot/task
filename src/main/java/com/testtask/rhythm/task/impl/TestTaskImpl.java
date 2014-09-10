package com.testtask.rhythm.task.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.testtask.rhythm.task.TestTask;

public class TestTaskImpl implements TestTask {

	public List<Integer> findHighestSums(int[][] lists, int n) {
		
		 List<Integer> diff = getDifference(lists);
		 Collections.sort(diff);
		 

		return null;
	}

	private List<Integer> getDifference(int[][] lists) {
		List<Integer> diffList = new ArrayList<Integer>();
		for (int i = 0; i < lists.length; i++)
			for (int j = 1; j < lists[i].length; j++) {
				diffList.add(lists[i][0] - lists[i][j]);
			}
		return diffList;
	}

}
