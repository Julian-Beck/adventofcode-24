package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class solutions {
    private String readInput() {
        try(BufferedReader br = new BufferedReader(new FileReader("./src/day3/input.txt"))) {
            String line = br.readLine();
            return line;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private boolean checkCharForDigit(char c) {
        return (int)c < 58 && (int)c > 47;
    }

    public long solution1(){
        String input = readInput();
        long sum = 0;
        int index = 0;
        boolean enabled = true;
        while (index < input.length()-7) {
            if (input.substring(index, index+7).equals("don't()")) {
                enabled = false;
            }
            if (input.substring(index, index+4).equals("do()")) {
                enabled = true;
            }
            if (input.substring(index, ++index+3).equals("mul(") && enabled) {
                index+=3;
                String firstNum = "";
                String secondNum = "";
                while (checkCharForDigit(input.charAt(index)) && firstNum.length() < 3) {
                    if (checkCharForDigit(input.charAt(index))) {
                        firstNum += input.charAt(index++);
                    }
                }
                if (input.charAt(index++) == ',') {
                    while (checkCharForDigit(input.charAt(index)) && secondNum.length() < 3) {
                        if (checkCharForDigit(input.charAt(index))) {
                            secondNum += input.charAt(index++);
                        }
                    }
                    if (input.charAt(index) == ')') {
                        sum += Long.parseLong(firstNum) * Long.parseLong(secondNum);
                        System.out.format("%s * %s = %d\n", firstNum, secondNum, sum);
                    }
                }
            }
        }
        return sum;
    }

    public long solution2() {
        String input = readInput();
        long sum = 0;
        int index = 0;
        while (index < input.length()-7) {
            if (input.substring(index, ++index+3).equals("mul(")) {
                index+=3;
                String firstNum = "";
                String secondNum = "";
                while (checkCharForDigit(input.charAt(index)) && firstNum.length() < 3) {
                    if (checkCharForDigit(input.charAt(index))) {
                        firstNum += input.charAt(index++);
                    }
                }
                if (input.charAt(index++) == ',') {
                    while (checkCharForDigit(input.charAt(index)) && secondNum.length() < 3) {
                        if (checkCharForDigit(input.charAt(index))) {
                            secondNum += input.charAt(index++);
                        }
                    }
                    if (input.charAt(index) == ')') {
                        sum += Long.parseLong(firstNum) * Long.parseLong(secondNum);
                        System.out.format("%s * %s = %d\n", firstNum, secondNum, sum);
                    }
                }
            }
        }
        return sum;
    }
}
