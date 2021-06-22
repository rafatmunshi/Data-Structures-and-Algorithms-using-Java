package ds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class FractionalKnapsack {
	 public static void main(String[] args) 
	    { 
	        int[] weights = {1, 4, 2, 3}; 
	        int[] values = {6, 4, 10, 12};  // 6 1 5 4    6 5 4 1
	        int capacity = 5; 				//6 10 8 = 24
	  
	        double maxValue = maxValue(weights, values, capacity); 
	        System.out.println("Maximum value using greedy approach " + maxValue); 
	  
	    } 
	 
	 private static double maxValue(int[] weights, int[] values, int capacity) {
		 FractionalKnapsack f= new FractionalKnapsack();
		Item[] items=new Item[weights.length];
		for(int i=0; i<weights.length; i++) {
			items[i]=f.new Item(weights[i], values[i]);
		}
		Arrays.sort(items, Comparator.comparingDouble(Item::getVbyw).reversed());
		
		double maxValue=0;
		for(Item i:items) {
			//fill knapsack until remaining capacity-weight of current item >=0
			//calculate fraction of last item remaining capacity/current weight
			//maxvalue= fraction*current item value
			double currWeight= i.weight;
			double currValue= i.value;
			if(capacity-currWeight >=0) {
				maxValue+=currValue;
				capacity=(int) (capacity-currWeight);
			}
			else {
				double fraction=capacity/currWeight;
				maxValue+=currValue*fraction;
				break;
			}
				
		}
		return maxValue;
	}

	class Item{
		 double weight;
		 double value;
		 double vbyw;
		 public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		public double getValue() {
			return value;
		}
		public void setValue(double value) {
			this.value = value;
		}
		public double getVbyw() {
			return vbyw;
		}
		public void setVbyw(double vbyw) {
			this.vbyw = vbyw;
		}
		Item(double weight, double value){
			 this.weight=weight;
			 this.value=value;
			 this.vbyw= value/weight;
		 }
	 }
}
