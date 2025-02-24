/**
 * [  ]
 *
 * Эта программа на Java проверяет набор паролей на безопасность.
 * 
 * Пароль считается безопасным, если он удовлетворяет следующим условиям:
 * 1. Содержит хотя бы одну заглавную букву;
 * 2. Содержит хотя бы одну строчную букву;
 * 3. Содержит хотя бы одну цифру;
 * 4. Содержит хотя бы один специальный символ (допустимый набор символов: !@#$%^&*()-+);
 * 5. Длина пароля больше или равна 8 символам.
 *
 * Формат ввода:
 * Одна строка, в которой чередуются пароли, разделенные пробелами.
 * Длина строки — не более 100 символов.
 *
 * Формат вывода:
 * Одна строка, содержащая только безопасные пароли, разделенные пробелами.
 * Если таких паролей нет, выводится "Не найдено".
 *
 * Пример 1:
 * Входные данные: "Password1 Pass@word 12345 pass!word Passw@rd Password1!"
 * Выходные данные: "Password1!"
 *
 * Пример 2:
 * Входные данные: "Password1 Pass@word 12345 pass!word"
 * Выходные данные: "Не найдено"
 */

import java.util.ArrayList;
import java.util.List;

public class SafePasswordChecker {

    // Набор спецсимволов
    private static final String specialChars = "!@#$%^&*()-+";

    public String findSafePasswords(String input) {
        // Разбиваем строку на массив паролей
        String[] passwords = input.split("\\s+");

        // Список для хранения безопасных паролей
        List<String> safePasswords = new ArrayList<>();

        // Проходим по каждому паролю и проверяем его
        for (String password : passwords) {
            if (isSafePassword(password)) {
                safePasswords.add(password);
            }
        }

        // Если нет безопасных паролей, возвращаем "Не найдено"
        if (safePasswords.isEmpty()) {
            return "Не найдено";
        }

        // Формируем строку с безопасными паролями
        StringBuilder result = new StringBuilder();
        for (String safePassword : safePasswords) {
            result.append(safePassword).append(" ");
        }

        // Убираем последний пробел и возвращаем результат
        return result.toString().trim();
    }

    // Метод для проверки безопасности пароля
    private boolean isSafePassword(String password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        if (password.length() < 8) {
            return false;
        }

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (specialChars.indexOf(ch) >= 0) {
                hasSpecialChar = true;
            }
        }

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    public static void main(String[] args) {
        SafePasswordChecker checker = new SafePasswordChecker();

        // Примеры использования
        System.out.println(checker.findSafePasswords("Password1 Pass@word 12345 pass!word Passw@rd Password1!")); // Password1!
        System.out.println(checker.findSafePasswords("Password1 Pass@word 12345 pass!word")); // Не найдено
    }
}
