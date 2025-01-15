package com.drzinks.recruitment_tasks;

import java.util.*;

public class RecruitFindTwoSum {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 11, 15, 7};
        System.out.println(getIndexesThatSumUpToTheValue(nums, 9));

    }

    public static List<Integer> getIndexesThatSumUpToTheValue(int[] arr, int target) {
        if(arr == null || arr.length <2){
            return new ArrayList<Integer>();
        }
        Map<Integer,Integer> valToIndex = new HashMap<>();
        int complement;

        for (int i = 0; i <arr.length; i++) {
            complement = target - arr[i];

            if(valToIndex.containsKey(complement)){
                return Arrays.asList(valToIndex.get(complement), i);
            }
            valToIndex.put(arr[i], i);
        }
        return new ArrayList<Integer>();
    }


}
