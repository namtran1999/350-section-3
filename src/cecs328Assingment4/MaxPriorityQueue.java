package cecs328Assingment4;

import java.util.Scanner;

//Assignment: 4
//Names: Breesy Reyes, Nam Tran
public class MaxPriorityQueue {
	static int[] list; //the date will be updated if there are any changes 
	public static void main(String[] args) 
	{
		list = new int[args.length];
		for(int index = 0;index < args.length; index++) {
			list[index]=Integer.parseInt(args[index]);
		}
		
		buildHeap(list,list.length);
		print(list,list.length);
	
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		boolean next = true;
		while(next)
		{
			System.out.print("\nChoose from the following options:\n\n");
			System.out.print("\t1.   Insert\n");
			System.out.print("\t2.   Maximum\n");
			System.out.print("\t3.   Extract-Max\n");
			System.out.print("\t4.   Increase-Key\n");
			System.out.print("\t5.   Exit\n\n");
			int choice = in.nextInt();
			switch(choice)
			{
				case 1: System.out.print("\nInput the integer you want inserted: ");
					int key = in.nextInt();
					System.out.print("\n");
					insert (list, key);
					break;
				case 2: System.out.print("\nMaximum value is: ");
					int val = maximum(list);
					System.out.print(val + "\n");
					print(list, list.length);
					break;
				case 3:
					int extract_max = extractMax(list);
					System.out.println("Maximum value is: " + extract_max );
					print(list, list.length);
					break;
				case 4:
					System.out.print("Input the index of the node you want to increase: ");
					int key1 = in.nextInt();
					System.out.print("Input the new value: ");
					int value = in.nextInt();
					System.out.print("Outputted Max Heap: ");
					increaseKey(list,key1, value);
					
					break;
				case 5: next = false;
					break;
				default: 
					break;
			}
			
		}

	}

	/**
	 * This method checks if the parent is greater than 
	 * the child. if it is not it switches and recurses.
	 * @param a
	 * @param largest
	 */
	static void heapify(int a[], int largest) 
	{
		int l = largest;
		int left = 2 * largest + 1;
		int right = 2 * largest  + 2;
		
		if ( left < a.length && a[left] > a[l]) {
			l = left;
		}
		if ( right < a.length && a[right] > a[l]) {
			l = right;
		}
		if ( l != largest) {
			int x = a[largest];
			a[largest] = a[l];
			a[l] = x;
			
			heapify(a,l);
		}
	}
	
	/**
	 * This method goes through the remaining nodes and 
	 * runs heapify on the.
	 * @param arr
	 * @param length
	 */
	static void buildHeap(int arr[], int length) 
	{
		for(int i = (length / 2 -1 ); i >= 0 ; i--) {
			heapify(arr,i);
		}
	}
	
	/**
	 * This method prints out the max heap array.
	 * @param arr
	 * @param length
	 */
	static void print(int arr[], int length) 
	{
		System.out.print("Outputted Max Heap: ");
		for(int i = 0; i< length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}
	/**
	 * This method insert new key into the heap and it will automatically sort the maxheap 
	 * @param arr the array of nodes 
	 * @param key the value wanted to insert 
	 */
	static void insert(int arr[], int key)
	{
		
		int []temp = new int[arr.length + 1];
		for(int i = 0; i < arr.length; i++)
		{
			temp[i] = arr[i];
		}
		arr = temp;
		increaseKey(arr, arr.length, key);
	}
	/**
	 * return the maximum value in the heap 
	 * @param arr the list of nodes 
	 * @return the max node 
	 */
	static int maximum(int arr[]) {
		return arr[0];
	}
	/**
	 * return and remove the max node 
	 * @param arr the list of nodes 
	 * @return the max node 
	 */
	static int extractMax(int arr[])
	{
		if (arr.length < 1)
			System.out.println("heap underflow");

		int heapSize = arr.length;
		int max = arr[0];
		arr[0] = arr[heapSize-1];
		heapSize = heapSize -1 ;
		int []temp = new int[heapSize];
		for(int i = 0; i < heapSize; i++)
		{
			temp[i] = arr[i];
		}
		arr = temp;
		buildHeap(arr,heapSize);
		list = arr;
		return max;
	}
	/**
	 * increase the key with the a new value 
	 * @param arr the list of nodes 
	 * @param i index of the node 
	 * @param key the new value
	 */
	static void increaseKey(int arr[], int i, int key) {
		i--;
		if(key < arr[i])
		{
			System.out.print("ERROE: new key is smaller than current key");
		}
		else {
			arr[i] = key;
			buildHeap(arr, arr.length);	
			list = arr;
			print(arr, arr.length); 
		}
	}

}
