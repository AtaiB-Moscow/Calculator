import java.util.Scanner;

class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение (например, 2 + 3):");
        String input = scanner.nextLine();

        try {
            // Разделяем ввод по пробелам
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Введите выражение в формате 'число операция число'.");
            }

            // Парсим цифры и операцию
            int a = Integer.parseInt(parts[0]);
            String operation = parts[1];
            int b = Integer.parseInt(parts[2]);

            // Проверяем, что числа находятся в диапазоне от 1 до 10
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно.");
            }

            // Выполняем операцию
            int result = 0;
            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b == 0) {
                        throw new ArithmeticException("Деление на ноль.");
                    }
                    result = a / b; // Деление с отбрасыванием остатка
                    break;
                default:
                    throw new IllegalArgumentException("Некорректная операция. Используйте +, -, * или /.");
            }

            // Вывод результата
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода: необходимо ввести целые числа.");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
