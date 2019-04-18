package com.kzl.leetcode.problem_1_50;


/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] a = new int[]{1,2};
        int[] b = new int[]{3,4};

        System.out.println(findMedianSortedArrays(a,b));

    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int media = (n1 + n2) / 2;
        int[] num = new int[n1 ];

        int i = 0, j = 0;
        int count = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                num[count++] = nums1[i];
                i++;
            } else {
                num[count++] = nums2[j];
                j++;
            }
        }

        if (count > media) {
            if (media % 2 == 0) {
                return (num[media - 1] + num[media]) / 2.0;
            } else {
                return 1.0 * num[media];
            }
        }

        // 说明num1遍历完了
        if (i == n1) {
            if (media % 2 == 0) {
                return (nums2[j + media - count-1] + nums2[j + media - count]) /2.0;
            } else {
                return 1.0 * nums2[j + media - count];
            }
        }

        if (j == n2) {
            if (media % 2 == 0) {
                return (nums1[i + media - count-1] + nums1[i+ media - count]) /2.0;
            } else {
                return 1.0 * nums1[i + media - count];
            }
        }

        return 0.0;
    }
}
