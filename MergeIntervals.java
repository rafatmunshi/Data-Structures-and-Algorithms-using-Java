package ds;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

	
class interval{
	public int start;
	public int end;
	interval(){
		start=0;
		end=0;
	}
	interval(int start, int end){
		this.start=start;
		this.end=end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}

public static void main(String args[]) {
	interval arr[]=new interval[3];
	MergeIntervals t=new MergeIntervals();
	for(int i=0;i<3;i++)
		arr[i]=t.new interval();
	//[4,8][2,7][4,10][6,8][8,9]
	arr[0].start=4;
	arr[0].end=9;
	arr[1].start=2;
	arr[1].end=8;
	arr[2].start=10;
	arr[2].end=15;
	MergeIntervals t1=new MergeIntervals();
	t1.mergeIntervals(arr);
}

private void mergeIntervals(interval[] arr) {
	if(arr.length<2) {
		for(interval k:arr) {
		System.out.println(k.start+" "+k.end);
		return;
		}
	}
	
	interval merged[]=new interval[3];
	MergeIntervals t=new MergeIntervals();
	for(int i=0;i<3;i++)
		merged[i]=t.new interval();
	int j=0;
	int i=0;

    Arrays.sort(arr,Comparator.comparingInt(interval::getStart)); 
	
	for(i=0;i<arr.length-1;i++) {
		if(arr[i+1].start<=arr[i].end) {
			interval c=new interval();
			c.start=arr[i].start;
			c.end=Math.max(arr[i].end,arr[i+1].end);
			merged[j++]=c;
			i++;
		}
		else
			merged[j++]=arr[i];
	}
	merged[j++]=arr[i];
	for(interval k:merged) {
		if(k.start!=0&&k.end!=0)
		System.out.println(k.start+" "+k.end);
	}
}
	
}
