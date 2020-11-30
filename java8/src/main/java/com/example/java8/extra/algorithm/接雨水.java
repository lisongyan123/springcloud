package com.example.java8.extra.algorithm;

public class 接雨水 {
    //左边最高的  和  右边最高的 取最小值然后相减
    public int trap(int[] height) {
        int sum = 0;
        int left_max = 0;
        int length = height.length;
        int[] right_max = new int[length];
        for(int i = length - 2; i > 0; i--) {
            right_max[i] = Math.max(right_max[i+1],height[i+1]);
        }
        for(int i = 0;i < length-1;i++) {
            left_max = Math.max(left_max,height[i]);
            int min = Math.min(left_max,right_max[i]);
            if(min > height[i]) {
                sum = sum + min - height[i];
            }
        }
        return sum;
    }
}
