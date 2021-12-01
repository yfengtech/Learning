package binary

class Calc {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            val param = "11111111111111111111111111111101".toLong(2)
//            println(hammingWeight(param.toInt()))
            var base = 1
            while (base <= 0x10000000) {
                println(base.to32Binary() + "--0x" + Integer.toHexString(base) + "--" + base)
                base *= 2
            }
        }

        fun Int.to32Binary(): String {
            var result = Integer.toBinaryString(this)
            while (result.length < 32) {
                result = "0$result"
            }
            return result
        }

//        fun hammingWeight(n: Int): Int {
//            var count = 0
//            for (i in 0..31) {
//                if ((n shr i) and 1 == 1) {
//                    count++
//                }
//            }
//            return count
//        }

        fun hammingWeight(n: Int): Int {
            var count = 0
            for (i in 0..31) {
                if ((1 shl i) and n != 0) count++
            }
            return count
        }
    }
}