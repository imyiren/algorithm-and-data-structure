package io.ilss.datastructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.ilss.datastructure.stack.CalculatorUtils.*;

/**
 * @author feng
 */
public class PolandNotation {
    public static void main(String[] args) {
        // 数和符号用空格隔开
        // String suffixExpress = "30 4 + 5 * 6 - ";
        // Stack stack = new LinkedStack();
        //
        // String[] strArr = suffixExpress.split(" ");
        // for (String item : strArr) {
        //     // 处理数字
        //     if (item.matches("\\d+")) {
        //         stack.push(Integer.parseInt(item));
        //         continue;
        //     }
        //     // 符号 就计算
        //     int num2 = stack.pop();
        //     int num1 = stack.pop();
        //     int result = calculator(num1, num2, item.charAt(0));
        //     stack.push(result);
        // }
        // // 164
        // System.out.println("expr: " + suffixExpress + ", result: " + stack.pop());


        String[] infixExprArr = transferToInfixExpr("1+20+3+(3+3)*4");


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

        }

        return null;
    }

}
