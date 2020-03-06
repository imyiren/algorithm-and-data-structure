package com.imyiren.swordoffer.q09;


import java.util.Queue;
import java.util.Stack;

/**
 * @author yiren
 */
public class StackQueue {
    public static void main(String[] args) {
    }

    private static class Queue {
        private Stack<String> inQueue;
        private Stack<String> outQueue;

        public Queue() {
            this.inQueue = new Stack<>();
            this.outQueue = new Stack<>();
        }

        public void add(String elem) {
            inQueue.add(elem);
        }

        public String poll() {
            if (outQueue.isEmpty() && inQueue.isEmpty()) {
                return null;
            }

            if (!outQueue.isEmpty()) {
                return outQueue.pop();
            }
            while (!inQueue.isEmpty()) {
                outQueue.push(inQueue.pop());
            }
            return outQueue.pop();
        }
    }
}
