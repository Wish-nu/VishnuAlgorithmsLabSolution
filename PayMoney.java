/*
Problem statement: PayMoney. processes thousands of transactions daily amounting to crores of Rupees. 
They also have a daily target that they must achieve. 
Given a list of transactions done by PayMoney and a daily target, your task is to determine at which transaction PayMoney
achieves the same. 
If the target is not achievable, then display the target is not achieved.
*/

package com.support.paymoney;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of transaction array: ");
        int numOfTransactions = sc.nextInt();
        int[] txnValues = new int[numOfTransactions];
        int[] cltValues = new int[numOfTransactions];
        System.out.println("Enter the values of the array: ");

        for (int i=0; i<numOfTransactions; i++){
            txnValues[i] = sc.nextInt();
            cltValues[i] = ((i==0)?0: cltValues[i-1])+txnValues[i];
        }
        System.out.println("Cumulative Values: " + Arrays.toString(cltValues));
        System.out.println("Enter the total no. of targets that needs to be achieved: ");
        int numOfTargets = sc.nextInt();
        for (int i=0; i<numOfTargets; i++){
            System.out.println("Enter the value of Target"+ (i+1)+": ");
            int target = sc.nextInt();
            int reqNoOfTxnForTargt = getTxnForTarget(cltValues, 0, numOfTransactions-1, target);
            System.out.println(reqNoOfTxnForTargt < 0? "Target is not achievable ":"Target achieved in " + reqNoOfTxnForTargt + " transactions");

        }
        sc.close();
    }

    private static int getTxnForTarget(int[] cltValues, int i, int i1, int target) {
        if(cltValues[cltValues.length-1]<target){
            return -1;
        }
        if(cltValues[0]>target){
            return 1;
        }
        if(i<i1){
            return -1;
        }
        int mid = (i+i1)/2;
        if(target<= cltValues[mid]){
            return target>cltValues[mid-1]?mid+1:getTxnForTarget(cltValues, mid+1,i1, target);

        }

    return -1;
    }
}
