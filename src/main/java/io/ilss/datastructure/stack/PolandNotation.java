package io.ilss.datastructure.stack;

import static io.ilss.datastructure.stack.CalculatorUtils.*;

/**
 * @author feng
 */
public class PolandNotation {
    public static void main(String[] args) {
        // 数和符号用空格隔开
        String suffixExpress = "30 4 + 5 * 6 - ";
        Stack stack = new LinkedStack();

        String[] strArr = suffixExpress.split(" ");
        for (String item : strArr) {
            // 处理数字
            if (item.matches("\\d+")) {
                stack.push(Integer.parseInt(item));
                continue;
            }
            // 符号 就计算
            int num2 = stack.pop();
            int num1 = stack.pop();
            int result = calculator(num1, num2, item.charAt(0));
            stack.push(result);
        }
        // 164
        System.out.println("expr: " + suffixExpress + ", result: " + stack.pop());

    }
}
