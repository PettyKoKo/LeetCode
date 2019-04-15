package com.kzl.leetcode.problem_1_50;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] nums = new int[]{3,2,4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));

    }

    public static int[] twoSum(int[] nums, int target) {

        // 定义一个HashMap
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // 把数组中元素添加到map中,值作为key,下标作为value
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }

        // 进行查找
        for (int i = 0; i < length; i++) {
            int key = target - nums[i];
            //  map.get(key) != i 判断同一个元素只能加一次
            if (map.containsKey(key) && map.get(key) != i) {
               return new int[]{i, map.get(key)};
            }
        }

        return null;
    }
}
