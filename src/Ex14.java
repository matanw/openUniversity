public class Ex14 {
	private static boolean isWay(int[] a, boolean[] isVisited, int start) {
		if (start < 0 || start >= a.length || isVisited[start]) {
			return false;
		}
		if (start == a.length - 1) {
			return true;
		}
		isVisited[start] = true;
		return isWay(a, isVisited, start + a[start]) || isWay(a, isVisited, start - a[start]);

	}

	public static boolean isWay(int[] a) {
		boolean[] isVisited = new boolean[a.length];
		return isWay(a, isVisited, 0);
	}

	public static int alternating(String s) {
		int countOf0inEvenIndexex = 0;
		for (int i = 0; i < s.length(); i += 2) {
			if (s.charAt(i) == '0') {
				countOf0inEvenIndexex++;
			}
		}
		int countOf0inOddIndexex = s.length() / 2 - countOf0inEvenIndexex;
		return getMin(countOf0inEvenIndexex, countOf0inOddIndexex);
	}

	private static int getMin(int num1, int num2) {
		if (num1 > num2) {
			return num2;
		}
		return num1;
	}

	private static int getGreatestIndex(int[] a, int x) {
		int begin = 0;
		int end = a.length - 1;
		while (end >= begin) {
			int middle = (begin + end) / 2;
			if (a[middle] < x) {
				begin = middle + 1;
			} else if (a[middle] > x) {
				end = middle - 1;
			} else {// a[middle]==x
				if (end == begin + 1) {
					if (a[end] == x) {
						return end;
					}
					return begin;
				}
				if (end == begin) {
					return begin;
				}
				begin = middle;

			}
		}
		return -1;

	}

	private static int getSmallastIndex(int[] a, int x) {
		int begin = 0;
		int end = a.length - 1;
		while (end >= begin) {
			int middle = (begin + end) / 2;
			if (a[middle] < x) {
				begin = middle + 1;
			} else if (a[middle] > x) {
				end = middle - 1;
			} else {// a[middle]==x
				if (end == begin + 1) {
					if (a[begin] == x) {
						return begin;
					}
					return end;
				}
				if (end == begin) {
					return begin;
				}
				end = middle;
			}
		}
		return -1;

	}

	public static int count(int[] a, int x) {
		int greatestIndex = getGreatestIndex(a, x);
		if (greatestIndex == -1) {
			return 0;
		}
		return greatestIndex - getSmallastIndex(a, x) + 1;
	}

	public static void printPath(int[][] mat) {
		printPath(mat, 0, 0);
		System.out.println();
	}

	private static void printPath(int[][] mat, int i, int j) {
		System.out.print("(" + i + "," + j + ")");
		if (isLegtimeWay(mat, i, j - 1, mat[i][j])) {
			printPath(mat, i, j - 1);
		} else if (isLegtimeWay(mat, i, j + 1, mat[i][j])) {
			printPath(mat, i, j + 1);
		} else if (isLegtimeWay(mat, i + 1, j, mat[i][j])) {
			printPath(mat, i + 1, j);
		} else if (isLegtimeWay(mat, i - 1, j, mat[i][j])) {
			printPath(mat, i - 1, j);
		}
	}

	private static boolean isLegtimeWay(int[][] mat, int i, int j, int valueComeFrom) {
		if (i < 0 || i > mat.length) {
			return false;
		}
		if (j < 0 || j > mat[0].length) {
			return false;
		}
		return (mat[i][j] > valueComeFrom);
	}

	public static void main(String[] args) {
		int[] a = { 2, 4, 1, 6, 4, 2, 4, 3, 5 };
		System.out.println(isWay(a) == true);
		int[] b = { 1, 4, 3, 1, 2, 4, 3 };
		System.out.println(isWay(b) == false);
		System.out.println(alternating("0101") == 0);
		System.out.println(alternating("00011011") == 2);
		int[] c = { 1, 1, 1, 2, 2, 4, 5, 5, 6 };
		for (int i = 0; i < c.length; i++) {
			System.out.println("c[" + i + "]=" + c[i]);
		}
		for (int i = 1; i < 7; i++) {
			System.out.println(i + " -" + getSmallastIndex(c, i) + "to" + getGreatestIndex(c, i));

		}

		int d[] = { 3, 3, 3, 3, 4, 5, 5, 5, 5, 5, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 };
		for (int i : d) {
			System.out.println(i + "- count:" + count(d, i));
		}
		System.out.println(count(d, -1));
		System.out.println(count(d, 10000));
		int[][] mat = { { 3, 8, 7, 1 }, { 5, 15, 2, 4 }, { 2, 1, 3, 2 }, { 4, 6, 7, 52 } };
		printPath(mat);
	}
}
