/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ParkingLot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Deepanshu
 */
public class Test {
    public static void main(String[] args) {
        
        List<Integer> asList = new ArrayList<Integer>();
            asList.add(2);
            asList.add(5);
            asList.add(1);
            asList.add(9);
            asList.add(3);
            asList.add(7);
            asList.add(2);
            asList.add(8);
            asList.add(9);
            asList.add(3);
        
            swap2max(asList, 6);
	}
 
  public static void swap2max(List<Integer> input, int k) {
//      System.out.println(input.size());
    if (input.size() < 2) {
        System.out.println(input);
        }
    
 ArrayList<Integer> maxi = new ArrayList<Integer>();
 for (int i = 0; i < input.size(); i++) {
     maxi.add(0);
 }
// System.out.println(" maxi 11" + Arrays.asList(maxi));
 getMax(input, k, maxi);
 
 
 for(int i = 0; i < maxi.size(); i ++) {
     System.out.print(maxi.get(i));
 }
}
    
    
  public static  void getMax(List<Integer> input, int k,List<Integer> maxi)
  {
      System.out.println(" maxi " + Arrays.asList(maxi));
 if (k == 0) 
 {
  int flag=0;
  for(int i=0;i<input.size();i++)
  {
      System.out.println(i + " : " + input.get(i) + " : " +maxi.get(i) );
   if(input.get(i)<=maxi.get(i))
   {
    flag=0;
    break;
   }
   else if(input.get(i)>maxi.get(i))
   {
    flag=1; 
    break;
   }
  }
  if(flag==1)
  { 
   for (int i = 0; i < input.size(); i ++) {
    maxi.set(i, input.get(i));
   }
  }
  return;
 }
 
 for (int i = 0; i < input.size() - 1; i++) {
  for (int j = i + 1; j < input.size(); j++) {
   swap(input , i , j);
   getMax(input, k-1, maxi);
   swap(input, i , j);
  }
 }
}
  
  public static void swap(List<Integer> l , int i , int j)
  {
      int temp = l.get(i);
      l.set(i, l.get(j));
      l.set(j, temp);
  }
	
}
