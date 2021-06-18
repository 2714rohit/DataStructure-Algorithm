package com.rohit.ds_algo;

import java.io.*;
import java.util.*;

public class RotateArray {
	/*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     
     [1,2,3,4,5,6] => d=2
      0 1 2 3 4 5
      small Array : [1,2]
      [3,4,5,6,5,6]
      [1,2,3,4,5,6] => d=4
      small Array : [5,6]
      [1,2,1,2,3,4]
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
    // Write your code here
    if(a==null || d==a.size() || a.size()==1){
        return a;
    }
    
    int size = a.size();
    
    List<Integer> list;
    if(d<size-d){
        list = new ArrayList(d);
        copySmallArray(0, d-1, list, a);
        rotateArrayLeft(d,a);
        for(int i=list.size()-1, j=size-1; i>=0; --i, --j){
            a.set(j, list.get(i));
        }
        
    }else{
        list = new ArrayList(size-d);
        copySmallArray(d, size-1, list, a);
        rotateArrayRight(d-1,a);
        for(int i=0; i<list.size(); ++i){
            a.set(i, list.get(i));
        }
    }
    return a;
    }
    private static void rotateArrayLeft(int ind, List<Integer> a){
        int lind = 0;
        while(ind<a.size()){
            a.set(lind, a.get(ind));
            ind++;
            lind++;
        }
    }
    private static void rotateArrayRight(int ind, List<Integer> a){
        int lind = a.size()-1;
        while(ind>=0){
            a.set(lind, a.get(ind));
            ind--;
            lind--;
        }
    }
    private static void copySmallArray(int sind, int lind, List<Integer> list, List<Integer> a){
        for(int i=sind; i<=lind; ++i){
            list.add(a.get(i));
        }
    }
    
    public static void main(String[] args) throws IOException {
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	list.add(5);
    	rotLeft(list, 2);
    	for(int val : list) {
    		System.out.print(val+" ");
    	}
    }

}
