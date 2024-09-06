package in.dsa.stack.impl;

public class DynamicArray{

	private int[] array;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10;
	
	//input size array constructor
	public DynamicArray(int size){
		this.array = new int[size];
	}
	//non input size array constructor
	public DynamicArray(){
		this.array = new int[DEFAULT_CAPACITY];
	}
	
	
	// For resizing the array if it is full.
	private void resize(){
		 
		int n = array.length;
		int resize = n*2;
		int[] resizedArray = new int[resize];
		
		//copying element
		for(int i = 0; i<n; i++){
			resizedArray[i] = array[i];
		}
		
		//referencing resized array to main array.
		array = resizedArray;
	}
	
	//Adding Data.............
	public void add(int data){
	
		if(capacity>array.length-1)
			resize();
	
		//System.out.println(capacity);
		array[capacity++] = data;
	}
	
	//Removing Data.......
	private int remove(){

		if(capacity<=0){
			capacity = 0;
			return -1;
		}
		int data = array[capacity];
		capacity--;
		return data;
	}	
	
	//Getting Data.......
	private int get(int index){

		if(index<0 || index>capacity){
			System.out.println("index can not be <0 or >array.length");
			return -1;
		}
		
		return array[index];
	}	
	
	//Getting size.......
	private int size(){
		return capacity;
	}
	
	//Checking Emptiness......
	private boolean isEmpty(){
		return capacity==0;
	}
	
	
	public void print(){
		
		for(int i=0; i<capacity; i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}

	
	

	public static void main(String[] args){
		
		DynamicArray da = new DynamicArray(5);
		
		System.out.println(da.size());
		System.out.println(da.isEmpty());
		System.out.println(da.get(0));
		
		da.add(1);
		da.add(2);
		da.add(3);
		da.add(4);
		da.add(5);
		da.add(6);
		da.print();
		System.out.println(da.size());
		System.out.println(da.isEmpty());
		System.out.println(da.get(0));
		System.out.println(da.get(10));
		System.out.println(da.get(-3));
		
		DynamicArray da1 = new DynamicArray();
		System.out.println(da1.size());
		System.out.println(da1.isEmpty());
		
		da1.remove();
		da1.remove();
		da1.remove();
		
		da1.add(10);
		da1.add(20);
		da1.add(30);
		da1.print();
		
		da1.remove();
		da1.remove();
		da1.remove();
		da1.remove();
		da1.remove();
		da1.remove();
		da1.add(100);
		da1.add(200);
		
		da1.print();
		
		System.out.println(da1.size());
		System.out.println(da1.isEmpty());
		System.out.println(da1.get(0));
		
	}
}

