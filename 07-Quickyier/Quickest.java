//I am using the class code to do duplicates because my own doesn't work and is too different to compare and change

import java.util.*;
import java.io.*;

public class QuickSortB{
    private Random rnd = new Random();

    public int partition(int[] a, int l, int r) {
	int tmp;
	int Rwall;
	int pivotIndex = l+rnd.nextInt(r-l);
	int pivot = a[pivotIndex];
	tmp = a[r];
	a[r] = a[pivotIndex];
	a[pivotIndex]=tmp;

	int wall=l;

	for (int j=wall;j<r;j++) {
	    Rwall = wall;
	    if(a[]j == pivot){
		tmp = a[Rwall];
		a[Rwall]=a[j];
		a[j]=tmp;
		Rwall++;
	    }else if (a[j]<pivot) {
		tmp = a[i];
		a[i]=a[wall];
		a[wall]=tmp;
		wall++;
	    }
	}
	tmp = a[wall];
	a[wall]=a[r];
	a[r]=tmp;
	return ((Rwall + wall)/2);
    }
    
    public void qsort(int[] a, int l, int r) {
	if (r-l <= 1)
	    return;
	else {
	    int pi = partition(a,l,r);
	    if (pi-1>l)
		qsort(a,l,pi-1);
	    if (pi+1<r)
		qsort(a,pi+1,r);

	}
    }
    public void  qsort(int[] a) {
	qsort(a,0,a.length-1);
    }
    public static void main(String[] arrrgs){
	Quickest a = new QuickSortB();
	int[] ans = a.(qsort({24,15,4,7,1,2,4,6,7,156,147,158,1,45,2}));
	System.out.println(Arrays.toString(ans));
    }
}
