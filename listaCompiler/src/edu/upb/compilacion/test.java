package edu.upb.compilacion;

public class test {
	
	public static void show(int x) {
		System.out.println(x);
	}
	
	public static void show(String x) {
		System.out.println(x);
	}
	
	public static void show(boolean x) {
		System.out.println(x);
	}
	
	public static void show(int[] x) {
		System.out.print("[");
		for (int i = 0; i < x.length; i++) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(x[i]);
		}
		System.out.println("]");
	}
	
	public static int[] cons(int x, int[] l) {
	    int[] res = new int[l.length + 1];
	    res[0] = x;
	    for (int i = 1; i < l.length + 1; i++) {
	        res[i] = l[i - 1];
	    }
	    return res;
	}

	public static int car(int[] l) {
	    return l[0];
	}

	public static int[] cdr(int[] l) {
	    int[] res = new int[l.length - 1];
	    for (int i = 1; i < l.length ; i++) {
	        res[i - 1] = l[i];
	    }
	    return res;
	}

	public static boolean isEmpty(int[] l) {
	    return (l.length > 0) ? false : true;
	}

	public static int length(String s) {
	    return s.length();
	}
	
	public static void main(String[] args) {
        test x = new test();
        int a = 1;
        test.show(test.isEmpty(new int[]{a,2}));
        test.show(true);
    }
}
