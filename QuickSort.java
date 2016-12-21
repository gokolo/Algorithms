/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

import java.util.Random;

/**
 *
 * @author Keevah
 */
public class QuickSort {
    private static int[] A;
    
    private int arraySize;
    
    static int r= 2;

    static long startTime;

    static long endTime;
    
    static int f;
    static int l ;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] n = {2,10,100,1000,2000,3000,10000,100000};
        int [] m= {2,10,100,1000,2000,10000,100000};
            
        
            for(int i=0; i<n.length;i++){
               QuickSort array_inst = new QuickSort(n[i]);
		//System.out.println("n is: "+n[i]);
                for(int j=0;j<m.length;j++){
                    startTime = System.nanoTime();
                        for (int x = 0; x < r; x++) {
                            array_inst.generateRandomArray(m[j]);
                            quicksort(f,l);
                        }
                    endTime = System.nanoTime();
                    System.out.println("AVG RUN TIME " + (endTime - startTime)/r);
                }
            }
        
    }
    
    public static void quicksort(int first, int last) {
        if(first<last){
            int P;
            int l = first;
            int h = last-1;
            P= A[last];

            while(l<h)
            {
                if(A[l]<P){
                    l++;
                }
                else if(A[h]>=P){
                    h--;
                }
                else{
                    swapValues(h,l);
                    h--;
                    l++;
                }
            }

            if (l==h){
                if(A[l]>=P){
                    h--;
                }
                else{
                    l++;            
                }
            }

            if(h == first-1){
                swapValues(first,last);
                l= first +1;
                h= first;
            }
            else {
                swapValues(last, l);
            }

            quicksort(first, h);
            quicksort(l, last);
        }
    }

    public static void swapValues(int indexOne, int indexTwo) {
            int temp = A[indexOne];
            A[indexOne] = A[indexTwo];
            A[indexTwo] = temp;

    }

    
    QuickSort(int size) {
         arraySize = size;
	A = new int[size];
    }


    public void generateRandomArray(int m) {
        for (int i = 0; i < arraySize; i++) {
            Random rand = new Random();
            A[i] = rand.nextInt(m);
        }
    }
    
}
