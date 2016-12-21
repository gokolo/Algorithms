/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchtreealg;

import java.util.Random;

/**
 *
 * @author Keevah
 */
public class SearchTreeAlg {
    static long startTime;

    static long endTime;
    
    private static int[] A;
    
    public static  Node root;
    
    //Constructor 
    public SearchTreeAlg(){
        this.root = null;
        A = new int[1000];
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int m= 1000;
                    
                startTime = System.nanoTime();
                    SearchTreeAlg t = new SearchTreeAlg();
                    t.generateRandomArray(m);
                    for(int j=0;j<A.length;j++){
                        t.insert(A[j]);
                        System.out.println(A[j]);
                    }
                    t.search(888);
                endTime = System.nanoTime();
                System.out.println("AVG RUN TIME " + (endTime - startTime));

    }
    
    class Node{
	int key;
	Node left;
	Node right;	
	public Node(int key){
		this.key = key;
		left = null;
		right = null;
	}    
    }
    
    
    public boolean search(int a){
        Node p = root;
        while(p!=null && p.key!=a){
                if(p.key>a){
                    p = p.left;
                }else if(p.key==a){
                        return true;
                    }
                else{
                    p = p.right;
                }
        }
        
        return false;
    }
    
    public void insert(int a){
        Node newNode = new Node(a);
        if(root==null){
                root = newNode;
                return;
        }

        Node p = root;
        Node q = null;
        while(p!=null && p.key!=a){
            q = p;
            if(p.key>a){				
                p = p.left;
            }else{
                p = p.right;                            
            }
        }

        if(p==null){
            p = newNode;
            p.key = a;
            p.left = null;
            p.right = null;
                        
            if(q.key>a){
                q.left = p;                
            } else{
                q.right = p;
            }
        }

    }
    
    public void eliminate(Node p, Node q){
        Node r;
        if(p.left==null){
            r= p.right;
        }else{
            r= p.left;
        }
        if(q.left==p){
            q.left =r;
        }else{
            q.right =r;
        }
        erase(p);
    }
    
    
     public void erase(Node p){
        p = null;
    }
    
     public void delete(int a){
        Node p = root;
        while(p!=null && p.key!=a){
                if(p.key>a){
                    p = p.left;
                }else{
                    p = p.right;
                }
        }
        //delete
        if(p!=null){
            Node q=null;
            Node r;
            if(p.left==null || p.right==null){
                eliminate(p,q);
            }
            else{
               r=p;
               q=p;
               p=p.right;
               while(p.left!=null){
                   q=p;
                   p=p.left;
               }
               r.key=p.key;
               eliminate(p,q);
            }
        }
        
    }
     
    public int height(Node p){
        int h;
        if(p.left!=null){
            h = height(p.left)+1;
        }
        if(p.right!=null){
            h = max(h, height(p.left)+1);
        }
        if(p.left==null && p.right==null){
            h=0;
        }
        return h;
    } 
     
    public void generateRandomArray(int m) {
        for (int i = 0; i < 1000; i++) {
            Random rand = new Random();
            A[i] = rand.nextInt(m);
        }
    }
     
    
}  //Finall closing brace