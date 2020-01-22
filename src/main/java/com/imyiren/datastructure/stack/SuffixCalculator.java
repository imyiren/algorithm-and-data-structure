package com.imyiren.datastructure.stack;

import java.util.ArrayList;
import java.util.List;

import static com.imyiren.datastructure.stack.CalculatorUtils.*;

/**
 * @author yiren
 */
public class SuffixCalculator {
    public static void main(String[] args) {
        String[] infixExprArr = transferToInfixExpr("1+20+3+(3+3)*4");
        String[] suffixExprArr = transferToSuffixExpr(infixExprArr);
        suffixCalculator(suffixExprArr);

    }

    // 表达式转换成中缀表达式
    public static String[] transferToInfixExpr(String expr) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < expr.length(); i++) {
            char temp = expr.charAt(i);
            // 处理为数字的情况
            if (isNum(temp)) {
                // 没到结尾
                StringBuilder builder = new StringBuilder(String.valueOf(temp));
                while (true) {
                    // 多位数处理
                    if (i != expr.length() - 1 && isNum(expr.charAt(i + 1))) {
                        i++;
                        builder.append(expr.charAt(i));
                    } else {
                        break;
                    }
                }
                result.add(builder.toString());
                continue;
            }
            // 处理字符的情况
            result.add(String.valueOf(temp));
        }
        return result.toArray(new String[0]);
    }

    public static String[] transferToSuffixExpr(String[] infixArr) {
        Stack operatorStack = new LinkedStack();
        List<String> result = new ArrayList<>();

        for (String item : infixArr) {
            // 数字
            if (item.matches("\\d+")) {
                result.add(item);
                continue;
            }
            // 左括号
            if ("(".equals(item)) {
                operatorStack.push(item.charAt(0));
                continue;
            }
            // 右括号 （先算括号里的，所以前面放进去的数字需要计算，此时就需要把符号栈里面的运算符放到数字后面）
            if (")".equals(item)) {
                // 如果是右括号需要pop出符号，放入result 直到遇到左括号
                while (operatorStack.peek() != '(') {
                    result.add(String.valueOf((char) operatorStack.pop()));
                }
                // 然后把左括号 pop出来
                operatorStack.pop();
                continue;
            }
            // 其他符号
            while (!operatorStack.isEmpty() && priority(operatorStack.peek()) >= priority(item.charAt(0))) {
                result.add(String.valueOf((char) operatorStack.pop()));
            }
            operatorStack.push(item.charAt(0));
        }
        // 最后把所有符号栈的符号放入result
        while (!operatorStack.isEmpty()) {
            result.add(String.valueOf((char) operatorStack.pop()));
        }

        return result.toArray(new String[0]);
    }

    public static void suffixCalculator(String[] strArr) {
        Stack stack = new LinkedStack();

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
        System.out.println("result: " + stack.pop());

    }

}
