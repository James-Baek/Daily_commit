package com.ssafy.ws;

import java.util.Stack;

class PostfixEvaluation {
    public static void main(String[] args) {
    	
        String strArr = "11+7+32*+1+37*8*+96*+1+83*7*+85*7*7*+43*7*4*+7+3+22*+7+88*6*+66*7*+71*5*7*+3+15*+18*4*+9+6+75*+3+18*8*9*+4+7+";

        System.out.println(calculator(strArr.toCharArray()));
    }

    public static double calculator(char[] strArr) {
        Stack<Double> operands = new Stack<Double>();

        for(char str : strArr) {

            switch (str) {
                case '+':
                case '-':
                case '*':
                case '/':
                    double right = operands.pop();
                    double left = operands.pop();
                    double value = 0;
                    switch(str) {
                        case '+':
                            value = left + right;
                            break;
                        case '-':
                            value = left - right;
                            break;
                        case '*':
                            value = left * right;
                            break;
                        case '/':
                            value = left / right;
                            break;
                        default:
                            break;
                    }
                    operands.push(value);
                    break;
                default:
                    operands.push(Double.parseDouble(Character.toString(str)));
                    break;  
            }
        }
        return operands.pop();
    }
}