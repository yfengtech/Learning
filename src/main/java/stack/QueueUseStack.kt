package stack

import java.util.*

/**
 * 题号：232
 * 用栈实现一个队列
 */
class QueueUseStack {

    /** Initialize your data structure here. */

    private var mOutStack = Stack<Int>()
    private var mInStack = Stack<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        mInStack.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        if (mOutStack.empty()) {
            while (!mInStack.empty()) {
                mOutStack.push(mInStack.pop())
            }
        }
        return mOutStack.pop()
    }

    /** Get the front element. */
    fun peek(): Int {
        if (mOutStack.empty()) {
            while (!mInStack.empty()) {
                mOutStack.push(mInStack.pop())
            }
        }
        return mOutStack.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return mInStack.empty() && mOutStack.empty()
    }


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val queue = QueueUseStack()
            queue.push(1)
            queue.push(2)
            queue.push(3)
            queue.push(4)
            queue.push(5)
            println("pop:${queue.pop()}")
            println("pop:${queue.pop()}")
            println("pop:${queue.pop()}")
            println("pop:${queue.pop()}")
            println("pop:${queue.pop()}")
        }
    }
}