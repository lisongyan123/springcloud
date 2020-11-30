package com.example.java8.extra.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 回溯剪枝 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<>();
        int len = candidates.length;
        dfs(candidates,res,combine,target,0,len);
        return res;
    }


// result.add(item)的话传的是baiitem的地址，所以如果更新item里面du的内容的话result里面也zhi会变；
// 而result.add(new ArrayList<String>(item))相当于deep copy，更新item并不会更dao新result里面的东西
// res.add(new ArrayList(item))
// 开辟一个独立地址，地址中存放的内容为item链表，后续item的变化不会影响到res
// res.add(item)
// 将res尾部指向了item地址，后续item内容的变化会导致res的变化。
    public void dfs(int[] candidates,List<List<Integer>> res,List<Integer> combine,int target,int start,int len) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<Integer>(combine));
            return;
        }
        for(int i = start; i < len;i++) {
            combine.add(candidates[i]);
            dfs(candidates,res,combine,target - candidates[i],i,len);
            combine.remove(combine.size() - 1);
        }
    }
}
