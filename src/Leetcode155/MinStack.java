package Leetcode155;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
class MinStack {

    private Stack<Integer> stk, temp;

    /** initialize your data structure here. */
    public MinStack() {
        stk = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        stk.push(x);
        if(temp.isEmpty() || x < temp.peek()){
            temp.push(x);
        }else if(x >= temp.peek()){
            temp.push(temp.peek());
        }
    }

    public void pop() {
        stk.pop();
        temp.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return temp.peek();
    }
}