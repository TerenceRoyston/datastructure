package interviewguide

import scala.collection.mutable
import scala.io.StdIn

/**
 * @author XuBowen
 * @date 2022/3/25 12:23
 */
object IG2_TwoStacksQueue {
    def main(args: Array[String]): Unit = {
        val queue = new MyQueue()
        var index = StdIn.readInt()
        while (index != 0) {
            val arr = StdIn.readLine().split(" ")
            if (arr.length == 2) {
                queue.add(arr(1).toInt)
            } else if (arr(0) == "poll") {
                queue.poll()
            } else {
                println(queue.peek())
            }
            index -= 1
        }

    }
}

class MyQueue {
    val pushStack = new mutable.ArrayStack[Int]()
    val popStack = new mutable.ArrayStack[Int]()

    // 队列添加元素全部加入pushStack中
    def add(item: Int) = {
        pushStack.push(item)
    }

    // 队列取出元素先判断pop栈中有没有元素，如果有直接弹出，没有将push栈中的元素全部弹到pop栈中再弹出栈顶元素
    def poll() = {
        if (popStack.nonEmpty) {
            popStack.pop()
        } else if (pushStack.nonEmpty) {
            while (pushStack.nonEmpty) {
                popStack.push(pushStack.pop())
            }
            popStack.pop()
        } else {
            new Exception
        }
    }

    // 看一下栈顶元素的话如果pop栈有元素则直接peek，没有的话则先将push栈全部弹到pop栈，然后peek，再把pop栈元素弹回
    def peek() = {
        var topValue = 0
        if (popStack.nonEmpty) {
            popStack.top
        } else if (pushStack.nonEmpty) {
            while (pushStack.nonEmpty) {
                popStack.push(pushStack.pop())
            }
            topValue = popStack.top
            while (popStack.nonEmpty) {
                pushStack.push(popStack.pop())
            }
            topValue
        } else {
            new Exception
        }


    }
}
