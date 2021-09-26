package com.example.algorithm.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName TwoSum.java
 * @Description 两数相加
 * @createTime 2021年07月02日 14:23
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] array = new int[]{4, 3, 6, 8, 11};

        int[] ints = twoSumByViolence(array, 14);
        Arrays.stream(ints).forEach(value -> System.out.print(value + "  "));

        array = new int[]{2, 3, 4, 8, 11};

        ints = twoSumByViolence(array, 6);

        Arrays.stream(ints).forEach(value -> System.out.print(value + "  "));

        ints = twoSumByHashTable(array, 99);
        Arrays.stream(ints).forEach(value -> System.out.print(value + "  "));

    }

    /**
     * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     *
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     *
     * 空间复杂度：O(1)
     * 时间复杂度：O(n²)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumByViolence(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSumByHashTable(int[] nums, int target){

        HashMap<Integer, Integer> hashTable = new HashMap(nums.length);

        for(int i = 0; i < nums.length; i++){
            if(hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i], i);
        }

        return null;
    }




}
