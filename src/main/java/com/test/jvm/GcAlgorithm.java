package com.test.jvm;

public class GcAlgorithm {

	public Object instace = null;
	private static final int _1MB = 1024*1024;
	private byte[] bigSize = new byte[_1MB];

	public static void main(String args[]) {

		GcAlgorithm ga = new GcAlgorithm();
		GcAlgorithm gb = new GcAlgorithm();
		ga.instace = gb;
		gb.instace = ga;

		ga = null;
		gb = null;

		System.gc();
	}

}
