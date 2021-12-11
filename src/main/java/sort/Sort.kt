package sort

import java.util.*

/**
 * 2021年12月11日
 */
class Sort {

    /**
     * 插入排序
     */
    fun insertSort(arr: IntArray) {
        for (i in 1 until arr.size) {
            for (j in i - 1 downTo 0) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1)
                }
            }
        }
    }

    /**
     * 选择排序
     */
    fun selectSort(arr: IntArray) {
        if (arr.size <= 1) return
        for (i in arr.indices) {
            var minIndex = i
            for (j in i + 1 until arr.size) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
            }
            if (i != minIndex) {
                swap(arr, i, minIndex)
            }
        }
    }

    /**
     * 冒泡排序
     */
    fun bubbleSort(arr: IntArray) {
        for (i in arr.size - 1 downTo 0) {
            for (j in 0 until i) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1)
                }
            }
        }
    }

    fun mergeSort(arr: IntArray, l: Int = 0, r: Int = arr.size-1) {
        if (l == r) return
        val mid = l + ((r - l) shr 1)
        mergeSort(arr, l, mid)
        mergeSort(arr, mid + 1, r)
        merge(arr, l, mid, r)
    }

    private fun merge(arr: IntArray, l: Int, m: Int, r: Int) {
        val help = IntArray(r - l + 1)
        var i = 0
        var p1 = l
        var p2 = m + 1
        while (p1 < m && p2 <= r) {
            help[i++] = if (arr[p1] <= arr[p2])
                arr[p1++]
            else
                arr[p2++]
        }
        while (p1 <= m)
            help[i++] = arr[p1++]
        while (p2 <= r)
            help[i++] = arr[p2++]
        help.indices.forEach {
            arr[l + it] = help[it]
        }
    }

    fun heapSort(arr:IntArray){
        val heap = PriorityQueue<Int>()
        arr.forEach {
            heap.offer(it)
        }
        var i = 0;
        while (heap.isNotEmpty()){
            arr[i++]=heap.poll()
        }
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        arr[i] = arr[i] xor arr[j]
        arr[j] = arr[i] xor arr[j]
        arr[i] = arr[i] xor arr[j]
    }
}