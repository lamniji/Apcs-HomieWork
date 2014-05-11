public class heapSort{

    private static int[] data;
    private static int h;
    private static int right;
    private static int left;
    private static int max;

    public static void heap(int[] data, int x){
	right = 2 * x + 1;
	left = 2 * x;
	if(left <= h && data[left] > data[x])
	    max = left;
	else
	    max = x;
	if(right <= h && data[right] > data[max])
	    max = right;
	if(max != x){
	    int tmp = data[x];
	    data[x] = data[max];
	    data[max] = tmp;
	    heap(data, max);  
	}
    }
    public static void makeHeap(int[] data){
	h = data.length - 1;
	for(int i = h/2;i >= 0;i--){
	    heap(data, i);
	}
    }
    public static void sort(int[] newdata){
	data = newdata;
	makeHeap(data);
	for (int i = h;i>0;i--){
	    int tmp = data[0];
	    data[0] = data[i];
	    data[i] = tmp;
	    h = h - 1;
	    heap(data,0);
	}
    }



   
    public static void main(String[] arrrgs){
	//heapSort a = new heapSort();
	int[] ugh = {15,4,48,12,34,12,7,4,97,12};
	sort(ugh);
	for (int i = 0; i < ugh.length; i++)
	    System.out.print(ugh[i] + " ");
    }

}
