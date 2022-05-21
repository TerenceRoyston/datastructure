package interviewguide
import scala.collection.mutable
import scala.io.StdIn

object IG1_MyStack {
    def main(args: Array[String]): Unit = {
        val stack = new MyStack()

        var arr=new Array[String](2)
        var i = readInt()
        while (i!=0){
            arr = StdIn.readLine().split(" ")
            if (arr.length==2){
                stack.push(arr(1).toInt)
            }else if (arr(0)=="pop"){
                stack.pop()
            }else{
                println(stack.getMinValue())
            }
            i-=1
        }
    }

}

class MyStack {
    val dataStack = new mutable.ArrayStack[Int]()
    val minStack = new mutable.ArrayStack[Int]()

    def push(item: Int) = {
        dataStack.push(item)
        if (minStack.isEmpty || item < minStack.top) {
            minStack.push(item)
        }
    }

    def pop() = {
        if (dataStack.isEmpty){
            new RuntimeException
        }else{
            val p = dataStack.pop()
            if (p == minStack.top) {
                minStack.pop()
            }
        }
    }

    def getMinValue() = {
        minStack.top
    }

}