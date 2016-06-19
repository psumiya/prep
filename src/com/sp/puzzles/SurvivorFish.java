package com.sp.puzzles;

/**
 * <p>
 * There is a stream with fishes flowing upstream and downstream.
 * </p>
 * <p>
 * Each fish attacks and kills the one going in the opposite direction, the
 * weaker fish gets killed.
 * </p>
 * <p>
 * Fishes going in same direction continue to survive since they all swim at the
 * same speed.
 * </p>
 * <p>
 * Given an Array A representing Power, an Array B representing direction of the
 * flow of a fish (0 = Upstream, 1 = Downstream), and a number N representing
 * the Number of fishes initially, find how many fishes will survive once they
 * start swimming.
 * </p>
 * <p>
 * Fish at Location <code>i</code> has Strength <code>A[i]</code> and is
 * swimming <code>B[i]</code>.
 * </p>
 * <p>
 * <code>A = { 4, 3, 2, 1, 5}; B = { 0, 1, 0, 0, 0}; N = 5; </code> The number
 * of survivors here = 2.
 * </p>
 * 
 * @author sumiyapathak
 *
 */
public class SurvivorFish {

	/**
	 * 
	 * @param A
	 *            an array representing Strength of Fish
	 * @param B
	 *            an array representing swim flow
	 * @param N
	 *            total number at beginning
	 * @return the number of survivors
	 */
	private static int survivors(int A[], int B[], int N) {
		int index = 0;
		int kill = 0;
		while (index < N - 1) {
			int currDir = B[index];
			int nextDir = B[index + 1];
			// A Kill Happens Only when Fishes go in Opposite direction
			if (isDownUp(currDir, nextDir)) {
				if (A[index] > A[index + 1]) {
					A[index + 1] = A[index];
					B[index + 1] = B[index];
				}
				kill++;
			}
			index++;
		}
		return N - kill;
	}

	/**
	 * 
	 * @param currDir
	 * @param nextDir
	 * @return true if the current and next fishes in the array are swimming
	 *         downstream and upstream respectively
	 */
	private static boolean isDownUp(int currDir, int nextDir) {
		return currDir == 1 && nextDir == 0;
	}

	/** Test Run this Class **/
	public static void main(String[] args) {
		int[] A = new int[] { 4, 3, 2, 1, 5, 6, 8 };
		int[] B = new int[] { 0, 1, 0, 0, 0, 0, 0 };
		System.out.println(survivors(A, B, 7));
	}

}
