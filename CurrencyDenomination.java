/*
You are a traveler and traveling to a country where the currency denominations are unknown and as you travel, 
you get to know about the denomination in random order. You want to make a payment of amount x, 
in such a way that the number of notes you give is minimum.
Assume that the denominations are in such a way that any amount can be paid.

*/


package com.support.currency.gl;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of currency denomination");
        int size = sc.nextInt();
        int[] denomination;
        denomination = new int[size];
        System.out.println("Enter the currency denomination values");

        for(int i=0;i<size;i++){
            denomination[i]= sc.nextInt();
        }
        System.out.println("Enter the amount you want to pay");
        int amount = sc.nextInt();
        int[] counter = new int[size];
        Arrays.sort(denomination);
        int leftOverAmount = countNotes(denomination, counter, 0, size-1, amount);
        if(leftOverAmount > 0){
            System.out.println("Sorry!! Amount cannot be paid in given denomination");
        }
        for(int i=size-1; i>=0;i--){
            if (counter[i]>0){
                System.out.println(denomination[i]+ " x "+":"+counter[i]+" = " + denomination[i]*counter[i]);
            }
        }
        System.out.println(Arrays.toString(denomination));
        System.out.println(Arrays.toString(counter));
        System.out.println(leftOverAmount);
        sc.close();

    }

    private static int countNotes(int[] denomination, int[] counter, int low, int high, int amount ){
        System.out.println("amount:" +amount+ "low:" +low+ "high:"+high+ "counter:" +Arrays.toString(counter));
        if (amount==0){
            return 0;
        }
        if (amount < denomination[0]){
            return amount;
        }
        if (amount >= denomination[high]){
            counter[high] = amount/denomination[high];
            amount = amount % denomination[high];
            return countNotes(denomination,counter,0,high-1,amount);
        }
        int mid = (low+high)/2;
        if (amount<=denomination[mid]){
            return countNotes(denomination, counter, 0, mid, amount);
        }
        return countNotes(denomination, counter, 0, high-1, amount);

    }
    
}
