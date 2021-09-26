package com.example.algorithm.structure;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName TreeNode.java
 * @Description 树 节点对象
 * @createTime 2021年06月29日 09:06
 */
public class TreeNode<E> {

    public TreeNode left;

    public TreeNode right;

    public E val;

    public TreeNode(E val) {
        this.val = val;
    }
}
