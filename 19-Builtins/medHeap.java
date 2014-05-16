import java.util.*;
import java.io.*;

public class medHeap{

    private int median;
    private PriorityQueue minheap;
    private PriorityQueue maxheap;

    public medHeap(){
	PriorityQueue minheap = new PriorityQueue();
	PriorityQueue maxheap = new PriorityQueue();
	int median = 0;
    }

    public int findMedian(){
	return median;
    }

    public void add(int x){ //no duplicates assumed
	if(x < med){
	    minheap.add(x);
	}else{
	    maxheap.add(x);
	}
	if(minheap.size() - maxheap.size() > 1){
	    //remove the root of minheap and insert it into maxheap
	    int temp = minheap.peek();
	    minheap.poll();
	    maxheap.add(temp);
	}else if(maxheap.size() - minheap.size() > 1){
	    //remove the root of maxheap and insert it into minheap
	    int temp = maxheap.peek();
	    maxheap.poll();
	    minheap.add(temp);
	}
	update();
    }

    public int removeMedian(){
	if(median == minheap.peek())
	    minheap.poll();
	else if(median == maxheap.peek())
	    maxheap.poll();
	else{
	    minheap.poll();
	    maxheap.poll();
	}
	int temp = median;
	update();
	return temp;
    }

    private void update(){
	if(minheap.size() == maxheap.size())
	    median = (minheap.peek() + maxheap.peek()) / 2;
	else if(minheap.size() > maxheap.size())
	    median = minheap.peek();
	else
	    median = maxheap.peek();
    }
    public static void main(String[] arrrgs){
	medHeap a = new medHeap();
	a.add(10);
	a.add(3);
	a.add(18);
	a.add(13);
	a.add(16);
	a.add(1);
	a.add(7);
	a.add(24);
	System.out.println(a.remove());
    }

}