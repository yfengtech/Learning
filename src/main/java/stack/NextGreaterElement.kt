package stack

/**
 * 题号496：下一个更大的元素
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 */
class NextGreaterElement {

    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val resultArr = IntArray(nums1.size)
        nums1.forEachIndexed { index, value ->
            var temp = -1
            var found = false
            for (i2 in nums2.indices) {
                if (nums2[i2] == value) {
                    found = true
                } else if (found && nums2[i2] > value) {
                    temp = nums2[i2]
                    break
                }
            }
            resultArr[index] = temp
        }
        return resultArr
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                NextGreaterElement().nextGreaterElement(
                    intArrayOf(4, 1, 2),
                    intArrayOf(1, 3, 4, 2)
                ).joinToString(",")
            )
        }
    }
}