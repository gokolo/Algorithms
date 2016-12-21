/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapsortalg;

import java.util.Random;

/**
 *
 * @author Keevah
 */
public class HeapSortAlg {
    private int[] H;
    
    static int r= 2;

    private int arraySize;

    static long startTime;

    static long endTime;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] n = {2,10,100,1000,2000,3000,10000,100000};
        int [] m= {2,10,100,1000,2000,10000,100000};
            
        
            for(int i=0; i<n.length;i++){
               HeapSortAlg array_inst = new HeapSortAlg(n[i]);
		//System.out.println("n is: "+n[i]);
                for(int j=0;j<m.length;j++){
                    startTime = System.nanoTime();
                        for (int x = 0; x < r; x++) {
                            array_inst.generateRandomArray(m[j]);
                            array_inst.heapsort();
                            array_inst.heapbuilding();
                        }
                    endTime = System.nanoTime();
                    System.out.println("AVG RUN TIME " + (endTime - startTime)/r);
                }
            }
        
    }
    
    
    public void heapsort() {
        int n = H.length;
        int i = n-1;
        while(i>0){
            swap(H, i, 0);
            moveDown(H,0,i);
            i--;
        }
    }
    
    public void heapbuilding() {
        int n = H.length;
        int i = ((n-1)/2)-1;
        while(i>=0){
            moveDown(H,i,n);
            i--;
        }
    }
 
    private void moveDown(int[] H, int i, int n) {
      int j = 2 * i + 1;
      int l = i;
      while (j < n) {
        // right child exists and is larger than left child
        if (j+1 < n && H[j] < H[j + 1]) {
          j++;
        }
        // right child is larger than parent
        if (H[j] > H[l]) {
          swap(H, j, l);
          // move down to largest child
          l = j;
          j = 2 * l + 1;
        } else {
          j=n;
        }
      }
    }
 
    private void swap(int[] H, int a, int b) {
      int tmp = H[a];
      H[a] = H[b];
      H[b] = tmp;
    }

    
    HeapSortAlg(int size) {
         arraySize = size;
	H = new int[size];
    }


    public void generateRandomArray(int m) {
        for (int i = 0; i < arraySize; i++) {
            Random rand = new Random();
            H[i] = rand.nextInt(m);
        }
    }
    
    
    }
