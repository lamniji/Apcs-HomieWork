//NOTE: I think I have found a solution to having to create seperate arrays. Last year I learned about temp variables and I think they can be implemented well here so we can swap values without losing them or creating a new array but it's not working. I think it's a minor issue but I just cannot find it.

//I don't understand why my methods must be static here.

import java.util.*;

public class Quicker{

    //Instead of returning 2 arrays/arraylists partition will change a and return the index of the pivot
    private static int partition(int[] A, int low, int high){
	Random rand = new Random();
	int pivot = A[rand.nextInt(high - low)];
	int i1 = low - 1;
	int i2 = high + 1;
	//while(true) will parse through this whole loop as long as there's something to parse through (I learned this while doing my final project last year and I think this is how it works :/)
	while (true){
	    i1++;
	    while(A[i1] < pivot && i1 < high){
		i1++;
	    }
	    i2--;
	    while(A[i2] > pivot && i2 > low){
		i2--;
	    }
	    if(i2 > i1){
		//store a[i1] into our tempvar to use it to replace a[i2]
		int tempvar = A[i1];
		A[i1] = A[i2];
		A[i2] = tempvar;
		
	    }else{
		return i2;
	    }
	}
    }



    //Calls itself for the left and right side but since theres no arraylists I just played around with low and high
    private static void quickSort(int[] A, int low, int high){
	if(high > low){
	    int pivot = partition(A,low,high);
	    quickSort(A, low, pivot);
	    quickSort(A, pivot + 1, high);
	}
    }

    public static void main(String[] arrrgs){
	Quicker a = new Quicker();
	int[] test = {14,587,4,7,454,31,5,6,12,52,16,73,95};
	a.quickSort(test,0,test.length -1);
	System.out.println(Arrays.toString(test));
    }

}
