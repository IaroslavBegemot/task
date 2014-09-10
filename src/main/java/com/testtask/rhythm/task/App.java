package com.testtask.rhythm.task;

import com.testtask.rhythm.task.impl.TestTaskImpl2;

public class App {
	public static void main(String[] args) {
		
		int[][] lists = {{4,1},{5,0,0},{5,4,3,2,1},{6,4,2},{1}};
		
		TestTaskImpl2 task = new TestTaskImpl2();
		
		task.test(lists);

	}
}
