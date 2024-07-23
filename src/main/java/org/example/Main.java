package org.example;

import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Test cases
        System.out.println(isPalindrome(12321)); // true
        System.out.println(isPalindrome(-12321)); // true
        System.out.println(isPalindrome(12345)); // false

        System.out.println(isPerfectNumber(6)); // true
        System.out.println(isPerfectNumber(28)); // true
        System.out.println(isPerfectNumber(12)); // false

        System.out.println(numberToWords(123)); // "bir iki üç"
        System.out.println(numberToWords(507)); // "beş sıfır yedi"
    }

    public static boolean isPalindrome(int number) {
        int mutilateNumber = Math.abs(number);

        String numberStr = Integer.toString(mutilateNumber);

        for (int i = 0; i < numberStr.length() / 2; i++) {
            if (numberStr.charAt(i) != numberStr.charAt(numberStr.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPerfectNumber(int number) {
        if (number <= 1) {
            return false;
        }

        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    public static String numberToWords(int number) {
        Locale locale = new Locale("tr", "TR");
        Locale.setDefault(locale);

        String numberStr = Integer.toString(number);
        String[] digits = numberStr.split("");

        String[] numbersInWords = {
                "sıfır", "bir", "iki", "üç", "dört",
                "beş", "altı", "yedi", "sekiz", "dokuz"
        };

        StringBuilder result = new StringBuilder();
        for (String digit : digits) {
            int digitValue = Integer.parseInt(digit);
            result.append(numbersInWords[digitValue]).append(" ");
        }

        return result.toString().trim();
    }
}
