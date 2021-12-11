package sort

import heap.MaxHeap
import java.util.*
import kotlin.random.Random

object SortApp {

    @JvmStatic
    fun main(args: Array<String>) {

        val sort = Sort()
        val arr = genRandomArray(50, 1000)
        println("start" + arr.size)
//        sort.bubbleSort(arr) // 冒泡
//        sort.mergeSort(arr) // 归并
//        sort.insertSort(arr) // 插入
//        sort.selectSort(arr) // 选择
//        MaxHeap.heapSort(arr) // 大根堆排序
        sort.heapSort(arr) // 小根堆排序
        arr.forEach {
            println(it)
        }
        println("end")
    }

    fun genRandomArray(maxSize: Int, maxValue: Int): IntArray {
        val size = Random.nextInt(maxSize)
        val arr = IntArray(size)
        for (index in 0 until size) {
            val randomValue = Random.nextInt(maxValue) - Random.nextInt(maxValue)
            arr[index] = randomValue
        }
        return arr
    }
}