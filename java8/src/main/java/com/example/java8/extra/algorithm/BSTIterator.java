package com.example.java8.extra.algorithm;

import java.util.ArrayList;

public class BSTIterator {

    ArrayList<Integer> nodesSorted;
    int index;

    public BSTIterator(AlgorithmMedium.TreeNode root) {

        this.nodesSorted = new ArrayList<Integer>();
        
        this.index = -1;
        
        this._inorder(root);
    }

    private void _inorder(AlgorithmMedium.TreeNode root) {

        if (root == null) {
            return;
        }

        this._inorder(root.left);
        this.nodesSorted.add(root.val);
        this._inorder(root.right);
    }

    public int next() {
        return this.nodesSorted.get(++this.index);
    }

    public boolean hasNext() {
        return this.index + 1 < this.nodesSorted.size();
    }
}
