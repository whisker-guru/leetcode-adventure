package grind169.week1;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    /*
     *  Problem: https://leetcode.com/problems/implement-queue-using-stacks/description/
     *  Solution Editorial: https://leetcode.com/problems/implement-queue-using-stacks/editorial/
     */

    class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (!outStack.empty())
                return outStack.pop();
            while(!inStack.empty())
                outStack.push(inStack.pop());
            return outStack.pop();
        }

        public int peek() {
            if (!outStack.empty())
                return outStack.peek();
            while(!inStack.empty())
                outStack.push(inStack.pop());
            return outStack.peek();
        }

        public boolean empty() {
            return outStack.empty() && inStack.empty();
        }
    }
}

