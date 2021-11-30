package sort

import kotlin.random.Random

object SortApp {

    @JvmStatic
    fun main(args: Array<String>) {
        val sort = Sort()
        val arr = genRandomArray(8,10)
        println("start")
        sort.mergeSort(arr)
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