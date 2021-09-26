package com.example.algorithm.easy;

import java.util.Stack;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName MergeTwoLists.java
 * @Description 最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @createTime 2021年06月29日 15:55
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(1);
        minStack.push(5);
        minStack.push(7);

        int min = minStack.getMin();
        System.out.println(min);
    }

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 压栈
     * @param val
     */
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        }else {
            minStack.push(minStack.peek());
        }
    }

    /**
     * 弹栈
     */
    public void pop() {
        stack.pop();
        minStack.pop();
    }

    /**
     * 获取栈顶
     * @return
     */
    public int top() {
        return stack.peek();
    }

    /**
     * 获取栈中最小的值
     * @return
     */
    public int getMin() {
        return minStack.peek();
    }
}