package lab3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу Журнала");
        String logPath = scanner.nextLine();

        if (logPath.isEmpty()) {
            logPath = "default_log.txt";
        }

        ResourceObserver observer = new ResourceObserver(logPath);

        ArrayProcessor arrayProcessor = new ArrayProcessor();
        ConsoleWriter consoleWriter = new ConsoleWriter();
        FileReaderObservable fileReaderObservable = new FileReaderObservable();

        arrayProcessor.addObserver(observer);
        consoleWriter.addObserver(observer);
        fileReaderObservable.addObserver(observer);

        try {
            consoleWriter.write("Введите путь к файлу с данными или 0 для ввода с консоли: ");
            String dataPath = scanner.nextLine();
            int[] numbers;

            if (dataPath.equals("0") || dataPath.isEmpty()) {
                consoleWriter.write("Введите целые числа разделенные пробелом: ");
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                numbers = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    numbers[i] = Integer.parseInt(parts[i]);
                }
            } else {
                numbers = fileReaderObservable.readNumbers(dataPath);
            }

            arrayProcessor.setArray(numbers);
            int[] currentArray = arrayProcessor.getArray();

            int a = 0;
            int b = 10;

            boolean found = false;
            for (int num : currentArray) {
                if (num >= a && num <= b) {
                    consoleWriter.write("Число в диапазоне: " + num);
                    found = true;
                }
            }

            if (!found) {
                consoleWriter.write("Нет чисел в диапазоне [" + a + ", " + b + "]");
            }
        } catch (FileNotFoundException e) {
            consoleWriter.write("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            consoleWriter.write("Error: Invalid input format");
        }

        scanner.close();
    }
}
