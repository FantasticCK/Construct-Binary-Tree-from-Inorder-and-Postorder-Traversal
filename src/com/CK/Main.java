package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, Integer> inIdx;
    int pi;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inIdx = new HashMap<>();
        int n = postorder.length;
        pi = n - 1;
        if (n == 0)
            return null;
        for (int i = 0; i < n; i++) {
            inIdx.put(inorder[i], i);
        }
        return helper(postorder, inorder, 0, n - 1);
    }

    private TreeNode helper(int[] postorder, int[] inorder, int inSt, int inEd) {
        if (inSt > inEd) {
            return null;
        }

        if (inSt == inEd) {
            pi--;
            return new TreeNode(inorder[inSt]);
        }
        int rootInInorder = inIdx.get(postorder[pi--]);
        TreeNode root = new TreeNode(inorder[rootInInorder]);
        root.right = helper(postorder, inorder, rootInInorder + 1, inEd);
        root.left = helper(postorder, inorder, inSt, rootInInorder - 1);
        return root;
    }
}