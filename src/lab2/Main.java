package lab2;

import lab2.exceptions.ArrayLengthException;
import lab2.exceptions.CharacterNotFoundException;
import lab2.exceptions.LettersFoundException;

public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        try {
            validator.validateStringContainsChar(args);
        } catch (CharacterNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            validator.validateStringContainsLetters(args);
        } catch (LettersFoundException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            validator.validateArrayLength(args);
        } catch (ArrayLengthException ex) {
            System.out.println(ex.getMessage());
        }

        if (validator.ex) {
            return;
        }

        int a = 0;
        int b = 10;

        int[] numbers = new int[args.length];
        for (int i = 0; i < args.length; i++){
            try {
                numbers[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Аргумент " + args[i] + " не целое число.");
                i++;
            }
        }
        int flag = 0;
        for (int number : numbers) {
            if (number < b && number > a) {
                System.out.println(number);
                flag = 1;
            }
        }

        if (flag == 0) {
            System.out.printf("Чисел принадлежащих отрезку[%d, %d] нет.", a, b);
        }
    }
}
