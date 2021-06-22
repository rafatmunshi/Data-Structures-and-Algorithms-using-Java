package ds;

public class BitManipulation {
//	Bitwise right shift, left shift
//	Bitwise AND
//	Bitwise OR
//	Bitwise EXOR
//	Bitwise NOT
//	Get a bit, set a bit, clear a bit using masks
	
//	x & (x-1) 
//	x & ~(x-1) 
//	x & (x + (1 << n))
//	x & ~(x + (1 << n)) 
//	x | (x + 1) 
//	x | ~(x + 1) 
//	x | (x - (1 << n))
//	x | ~(x - (1 << n))

	public static void main(String args[]) {
	//	System.out.println(2>>1); //000010 000001 Right shift - division by 2
	//	System.out.println(2<<1); // 000010 0000100 Left shift- Multiplication
		
	//	System.out.println(2&1); //00010 00001 0000000
	//	System.out.println(2|1); //00010 00001 0000011
	//	System.out.println(2^1); //00010 00001 0000011
	//	System.out.println(~2); //000010 111101 00010+1= 00011
	//	System.out.println(5 | 2); //00101 00010 = 00111
	//	System.out.println(~(1<<1) & 6);  //000110 000100
		int x=10;
	//	System.out.println(x & (x-1)); // 1010 1000
	//	System.out.println(x & ~(x-1)); //1010 0010
	//	System.out.println(x & (x + (1 << 1))); //1000

	}
}
