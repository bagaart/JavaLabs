package lab1;

public class task {
    public static void main(String[] args){
        int a = 0;
        int b = 10;

        int[] numbers = new int[args.length];
        for (int i = 0; i < args.length; i++){
            try {
                numbers[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Аргумент " + args[i] + " не целое число.");
                return;
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
