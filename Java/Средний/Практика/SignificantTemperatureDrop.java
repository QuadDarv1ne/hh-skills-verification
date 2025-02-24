/*
 * [  ]
 *
 * Эта программа на Java определяет значительные падения температуры в массиве значений температур по дням.
 * Значительным падением считается уменьшение температуры на 3 и более градуса по сравнению с предыдущим днем.
 *
 * Формат ввода:
 * Одна строка, содержащая целые числа, разделенные пробелами. Числа могут быть положительными, отрицательными или нулем.
 * Длина списка — не больше 100 элементов.
 *
 * Формат вывода:
 * Одна строка, содержащая индексы дней, в которые произошло значительное падение температуры, разделенные пробелами.
 * Если таких дней нет, выводится "Нет".
 *
 * Пример 1:
 * Входные данные: "0 5 2 7 4 1"
 * Выходные данные: "2 4 5"
 *
 * Пример 2:
 * Входные данные: "10 8 6 4 2 0 -2 -4"
 * Выходные данные: "Нет"
 */

import java.util.ArrayList;
import java.util.List;

public class SignificantTemperatureDrop {

    public String findDrops(String input) {
        // Разбиваем строку на массив целых чисел
        String[] tempStrings = input.split("\\s+");
        int[] temperatures = new int[tempStrings.length];

        for (int i = 0; i < tempStrings.length; i++) {
            temperatures[i] = Integer.parseInt(tempStrings[i]);
        }

        // Список для хранения индексов значительных падений
        List<Integer> dropIndices = new ArrayList<>();

        // Проходим по массиву, начиная со второго элемента
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[i - 1] - 3) {
                dropIndices.add(i);
            }
        }

        // Если нет значительных падений, возвращаем "Нет"
        if (dropIndices.isEmpty()) {
            return "Нет";
        }

        // Формируем строку с индексами значительных падений
        StringBuilder result = new StringBuilder();
        for (int index : dropIndices) {
            result.append(index).append(" ");
        }

        // Убираем последний пробел и возвращаем результат
        return result.toString().trim();
    }

    public static void main(String[] args) {
        SignificantTemperatureDrop finder = new SignificantTemperatureDrop();

        // Примеры использования
        System.out.println(finder.findDrops("0 5 2 7 4 1")); // 2 4 5
        System.out.println(finder.findDrops("10 8 6 4 2 0 -2 -4")); // Нет
    }
}
 