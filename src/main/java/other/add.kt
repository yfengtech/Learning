package other

class add {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var result = intArrayOf()
            val target = 9
            val nums = listOf<Int>(1, 2, 3, 4, 5)
            val map = HashMap<Int, Int>()
            nums.forEachIndexed { key, value ->
                if (map.containsKey(target - value)) {
                    result = intArrayOf(map.getValue(target - value), key)
                    print(result.toString())
                } else {
                    map[value] = key
                }
            }
        }
    }
}