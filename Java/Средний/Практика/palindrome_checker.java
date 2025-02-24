/**
 * [ Проверка Палиндрома ]
 *
 * Эта программа на Java проверяет, является ли заданная строка палиндромом.
 * Палиндромом называется строка, которая читается одинаково как с начала, так и с конца.
 * Программа игнорирует пробелы и нечувствительна к регистру букв.
 *
 * Формат ввода:
 * Одна строка, содержащая заглавные и/или строчные буквы русского алфавита,
 * а также возможные пробелы. Длина строки от 2 до 100 символов включительно.
 *
 * Формат вывода:
 * Одна из двух фраз (без кавычек): "Палиндром" или "Не палиндром".
 *
 * Пример 1:
 * Входные данные: "Тут как тут"
 * Выходные данные: "Палиндром"
 *
 * Пример 2:
 * Входные данные: "Программист"
 * Выходные данные: "Не палиндром"
 */

 public class palindrome_checker {

    public String checkPalindrome(String input) {
        // Удаляем пробелы и приводим к нижнему регистру
        String cleanedInput = input.replaceAll("\\s+", "").toLowerCase();

        // Сравниваем строку с её перевёрнутой версией
        String reversedInput = new StringBuilder(cleanedInput).reverse().toString();

        if (cleanedInput.equals(reversedInput)) {
            return "Палиндром";
        } else {
            return "Не палиндром";
        }
    }

    public static void main(String[] args) {
        palindrome_checker checker = new palindrome_checker();

        // Примеры использования
        System.out.println(checker.checkPalindrome("Тут как тут")); // Палиндром
        System.out.println(checker.checkPalindrome("Программист")); // Не палиндром
    }
}
