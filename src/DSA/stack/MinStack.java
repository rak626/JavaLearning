package DSA.stack;

import java.util.Stack;

/**
 * Problem: Min Stack
 * Link: <a href="https://leetcode.com/problems/min-stack/description/">Click here</a>
 * Difficulty: Medium
 * Tags: stack
 * <p>
 * Approach:
 * -
 * <p>
 * Time: O()
 * Space: O()
 */

class StackContainer {
    private int val;
    private int curMinVal;

    StackContainer(int val, int curMinVal) {
        this.val = val;
        this.curMinVal = curMinVal;
    }

    public int getVal() {
        return val;
    }

    public int getCurMinVal() {
        return curMinVal;
    }
}

public class MinStack {
    private final Stack<StackContainer> st;
    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        int minVal = st.isEmpty() ? Integer.MAX_VALUE : st.peek().getCurMinVal();
        if (val < minVal) {
            minVal = val;
        }
        st.push(new StackContainer(val, minVal));
    }

    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        st.pop();
    }

    public int top() {
        return st.peek().getVal();
    }

    public int getMin() {
        return st.peek().getCurMinVal();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        minStack.top();    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}


