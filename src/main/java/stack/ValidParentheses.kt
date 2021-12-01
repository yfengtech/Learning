package stack

import java.util.*

/**
 * 题号：20
 * 有效的括号
 */
class ValidParentheses {

    companion object {
        /**
         * 判断括号是否有效，需要括号成对出现
         */
        fun isValid(s: String): Boolean {
            if (s.length % 2 != 0) return false
            val stack = Stack<Char>()
            val pairs: Map<Char, Char> = hashMapOf('(' to ')', '[' to ']', '{' to '}')
            s.forEach {
                if (pairs.containsKey(it)) {
                    // 左括号
                    stack.push(it)
                } else {
                    if (stack.empty()) return false
                    // 右括号
                    if (pairs[stack.peek()] != it) return false
                    stack.pop()
                }
            }
            return stack.empty()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            print(isValid("[]{}{}(()){{}}{()}{[()]}"))

        }
    }
}