package stack

import java.util.*

/**
 * 题号155
 * 最小栈
 */
class MinStack {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
//            print(divisorGame(20))
            val s = MinStack()
            s.push(0)
            s.push(1)
            s.push(0)
            println("s.getMin():" + s.getMin())
            s.pop()
//            println("s.top():" + s.top())
            println("s.getMin():" + s.getMin())
        }
    }

    /** initialize your data structure here. */
    private val dataStack = Stack<Int>()
    private val minStack = Stack<Int>()

    fun push(i: Int) {
        dataStack.push(i)
        if (minStack.empty() || i <= minStack.peek()) {
            minStack.push(i)
        }
    }

    fun pop() {
        val i = dataStack.pop()
        if (i == minStack.peek()) {
            minStack.pop()
        }
    }

    fun top(): Int {
        return dataStack.peek()
    }

    fun getMin(): Int? {
        return if (minStack.empty()) null else minStack.peek()
    }
}