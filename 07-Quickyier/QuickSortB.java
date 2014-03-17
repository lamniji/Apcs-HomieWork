//I am using the class code to do duplicates because my own doesn't work and is too different to compare and change

import java.util.*;
import java.io.*;

public class QuickSortB{
    private Random rnd = new Random();

    public int partition(int[] a, int l, int r) {
	int tmp;
	int pivotIndex = l+rnd.nextInt(r-l);
	int pivot = a[pivotIndex];
	tmp = a[r];
	a[r] = a[pivotIndex];
	a[pivotIndex]=tmp;

	int wall=l;
	int Rwall = 0;

	for (int j=wall;j<r;j++) {
	    Rwall = wall;
	    if(a[j] == pivot){
		tmp = a[j];
		a[j]=a[Rwall];
		a[Rwall]=tmp;
		Rwall++;
	    }else if (a[j]<=pivot) {
		tmp = a[j];
		a[j]=a[Rwall];
		a[Rwall]=tmp;
		wall++;Rwall++;
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
	QuickSortB a = new QuickSortB();
	int[] test1 = {24,15,4,7,1,2,4,6,7,156,147,158,1,45,2};
	a.qsort(test1);
	int [] test2 = new int[10000];
	    for(int i = 0; i<test2.length;i++){
		test2[i] = a.rnd.nextInt(1000);
	    }
	System.out.println(Arrays.toString(test1));
	int[] temp = test2;
	a.qsort(test2);
	Arrays.sort(temp);
	if(test2==temp)
	    System.out.println("WORKS");
	//System.out.println(Arrays.toString(test2));
    
    }

}
