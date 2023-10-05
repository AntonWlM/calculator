import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите операцию");
        Scanner sc = new Scanner(System.in);
        String scline = sc.nextLine();
        Calculator calculator = new Calculator();
        calculator.calculate(scline);
    }
}
