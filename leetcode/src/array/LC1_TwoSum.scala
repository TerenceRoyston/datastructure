package array

/**
 * @author XuBowen
 * @date 2022/3/13 0:06
 */
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.control.Breaks

object LC1_TwoSum {
    def main(args: Array[String]): Unit = {
        twoSum(Array(1, 2, 3, 4, 5), 4)
    }

    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val numsBuffer = new ArrayBuffer[Int]()
        var numsListBuffer =  ListBuffer[(Int, Int)]()

        for (index <- nums.indices) {
            numsListBuffer += ((nums(index),index))
        }

        val loop = new Breaks

        var m = 0
        var n = 0
        loop.breakable{
            for ( i <- numsBuffer.indices) {
                m = i
                for (j <- i+1 until numsBuffer.length){
                    n =j
                    if (numsBuffer(i) + numsBuffer(j) ==target){
                        loop.break()
                    }
                }
            }
        }

        println(Array(m, n).mkString(","))
        Array(m,n)
    }
}
