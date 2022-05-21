package interviewguide;

/**
 * @author XuBowen
 * @date 2022/4/3 16:48
 */

import java.util.Scanner;
import java.util.Stack;

public class IG3_ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        while (size != 0) {
            stack.push(scanner.nextInt());
            size--;
        }

        reverseStack(stack);
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) {
            res.append(stack.pop()).append(" ");
        }
        System.out.println(res.toString().trim());
    }

    // 不使用额外空间获取栈底部元素，仅获取值不弹出
    public static void peekBottomOfStack(Stack<Integer> stack) {
        if (stack.size() == 1) {
            System.out.println(stack.peek());
            return;
        }

        int item = stack.pop();
        peekBottomOfStack(stack);
        stack.push(item);
    }

    // 不使用额外空间弹出栈底部元素
    public static Integer popBottomOfStack(Stack<Integer> stack) {
        int result;
        if (stack.size() == 1) {
            return stack.pop();
        }
        int item = stack.pop();
        result = popBottomOfStack(stack);
        stack.push(item);
        return result;
    }

    // 不使用额外空间逆序栈
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int bottom = popBottomOfStack(stack);
        reverseStack(stack);
        stack.push(bottom);
    }
}