package stack

import java.util.*

/**
 * 题号：225
 * 用两个队列实现一个栈,也可以用一个队列
 *
 * 核心：要满足队列前端的元素是栈顶的元素
 */
class StackUseQueue {

    private var realQueue: Queue<Int> = LinkedList()
//    private var tempQueue: Queue<Int> = LinkedList()

    /** Push element x onto stack. */
    fun push(x: Int) {
        val n = realQueue.size
        realQueue.offer(x)
        for (i in 0 until n) {
            realQueue.offer(realQueue.poll())
        }

//        while (!realQueue.isEmpty()){
//            realQueue.offer(realQueue.poll())
//        }
//        tempQueue.offer(x)
//        while (!realQueue.isEmpty()) {
//            tempQueue.offer(realQueue.poll())
//        }
//        val temp = realQueue
//        realQueue = tempQueue;
//        tempQueue = temp
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        return realQueue.poll()
    }

    /** Get the top element. */
    fun top(): Int {
        return realQueue.peek()
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return realQueue.isEmpty()
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val stack = StackUseQueue()
            stack.push(1)
            stack.push(2)
            stack.push(3)
            stack.push(4)
            stack.push(5)
            println("pop:${stack.pop()}")
            println("pop:${stack.pop()}")
            println("pop:${stack.pop()}")
            println("pop:${stack.pop()}")
            println("pop:${stack.pop()}")
        }
    }
}