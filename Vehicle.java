package ds;

public class Vehicle {
	int a;
	double pi=3.14;
	char c;
	String s;
	static int count;
	
	Vehicle(){
		count++;
	}
	Vehicle(int a){
		this.a=a;
		c='A';
		s="Some string";
	}
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	public void printing() {
	}
	public static void main(String args[])
	{
		System.out.println("Hello World");
	}
}

class Car extends Vehicle{
	int a;
	public void printing() {
		System.out.println(super.a);
	}
}
interface inf{
	public abstract void printing();
}

class extendedinf implements inf{
	public void printing() {
		//code
	}
}




