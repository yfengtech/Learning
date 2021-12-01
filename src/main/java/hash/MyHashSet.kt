package hash

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class MyHashSet {

    private val mData = Array<LinkedList<Int>>(7) { LinkedList() }


    fun add(key: Int) {
        val iterator = mData[hash(key)].iterator()
        while (iterator.hasNext()) {
            if (key == iterator.next()) return
        }
        mData[hash(key)].offerLast(key)
    }

    fun remove(key: Int) {
        val iterator = mData[hash(key)].iterator()
        while (iterator.hasNext()) {
            if (key == iterator.next()) {
                mData[hash(key)].remove(key)
                return
            }
        }
    }

    fun contains(key: Int): Boolean {
        val iterator = mData[hash(key)].iterator()
        while (iterator.hasNext()) {
            if (key == iterator.next()) {
                return true
            }
        }
        return false
    }

    private fun hash(key: Int): Int = key % mData.size
}


/**
 * 设计hashmap
 */
class MyHashMap() {

    private val mData = Array<LinkedList<Entry>>(71) { LinkedList() }

    fun put(key: Int, value: Int) {
        val iterator = mData[hash(key)].iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            if (key == entry.key) {
                entry.value = value
                return
            }
        }
        mData[hash(key)].offerLast(Entry(key, value))
    }

    fun get(key: Int): Int {
        val iterator = mData[hash(key)].iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            if (key == entry.key) {
                return entry.value
            }
        }
        return -1
    }

    fun remove(key: Int) {
        val iterator = mData[hash(key)].iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            if (key == entry.key) {
                mData[hash(key)].remove(entry)
                return
            }
        }
    }

    private fun hash(key: Int): Int = key % mData.size

    inner class Entry(val key: Int, var value: Int)

}

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val hashSet = hashSetOf<Int>()
        nums.forEach {
            if (hashSet.contains(it)) return true
            hashSet.add(it)
        }
        return false
    }

    fun singleNumber(nums: IntArray): Int {
        val hashSet = hashSetOf<Int>()
        nums.forEach {
            if (hashSet.contains(it)) {
                hashSet.remove(it)
            } else {
                hashSet.add(it)
            }
        }
        return hashSet.first()
    }

    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set1 = nums1.toHashSet()
        val set2 = nums2.toHashSet()

        val result = hashSetOf<Int>()
        set1.forEach {
            if (set2.contains(it)) {
                result.add(it)
            }
        }
        return result.toIntArray()
    }

    private val set = hashSetOf<Int>()

    fun isHappy(n: Int): Boolean {
        var input = n
        while (input != 0) {
            input = calcSum(input)
            if (input == 1) return true
            if (set.contains(input)) return false
            set.add(input)
        }
        return false
    }

    private fun calcSum(n: Int): Int {
        var temp = n
        var sum = 0
        while (temp > 0) {
            val i = temp % 10
            sum += i * i
            temp /= 10
        }
        return sum
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
            if (hashMap.containsKey(target - i)) {
                return intArrayOf(hashMap.getValue(target - i), index)
            } else {
                hashMap[i] = index
            }
        }
        return intArrayOf()
    }


    /**
     *
     * 给定两个字符串s和t，判断它们是否是同构的。
     * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
     * 每个出现的字符都应当映射到另一个字符, 同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     *
     * 示例 1:
     * 输入：s = "egg", t = "add"
     * 输出：true
     *
     * 示例 2：
     * 输入：s = "foo", t = "bar"
     * 输出：false
     *
     * 示例 3：
     * 输入：s = "paper", t = "title"
     * 输出：true
     */
    fun isIsomorphic(s: String, t: String): Boolean {
        val arrayS = s.toCharArray()
        val arrayT = t.toCharArray()
        if (arrayS.size != arrayT.size) return false

        val hashMap1 = hashMapOf<Char, Char>()
        arrayS.forEachIndexed { index, c ->
            if (!hashMap1.containsKey(c)) {
                hashMap1[c] = arrayT[index]
            } else if (hashMap1[c] != arrayT[index]) {
                return false
            }
        }

        val hashMap2 = hashMapOf<Char, Char>()
        arrayT.forEachIndexed { index, c ->
            if (!hashMap2.containsKey(c)) {
                hashMap2[c] = arrayS[index]
            } else if (hashMap2[c] != arrayS[index]) {
                return false
            }
        }
        return true
    }

    fun isIsomorphic2(s: String, t: String): Boolean {
        val map = hashMapOf<Any, Int>()
        s.forEachIndexed { index, c ->
            val previousIndexInS = map.put(c.toString(), index)
            val previousIndexInT = map.put(t[index], index)
            if (previousIndexInS != previousIndexInT) {
                return false
            }
        }
        return true
    }

    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        return list1.filter {
            list2.contains(it)
        }.toTypedArray()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val s = Solution()
//            print(s.isIsomorphic2("paper", "title"))
            val l1 = arrayOf("Shogun", "Tapioca Express", "Burger King", "KFC")
            val l2 = arrayOf("KFC", "Shogun", "Burger King")
            s.findRestaurant(l1, l2)
        }
    }
}
