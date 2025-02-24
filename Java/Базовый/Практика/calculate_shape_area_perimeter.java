/**
 * Задача: Вычисление площади и периметра фигур
 *
 * Вы разрабатываете программу для обработки информации о фигурах на плоскости.
 * Программа работает с двумя типами фигур — круг и квадрат.
 *
 * Формат ввода:
 * Одна строка, состоящая из типа фигуры ("круг" или "квадрат") и опционально — измерения
 * (радиус для круга или длина стороны для квадрата). Они разделены пробелом.
 * Измерение может быть как целым, так и вещественным числом. Если измерение не указано,
 * оно должно приниматься по умолчанию за 1.
 *
 * Формат вывода:
 * Два числа: сначала площадь, затем периметр фигуры, разделенные пробелом.
 * Оба числа отформатированы с точностью до двух знаков после точки, например: 8.00 12.01.
 *
 * Пример 1:
 * Входные данные: круг 3
 * Выходные данные: 28.27 18.85
 *
 * Пример 2:
 * Входные данные: квадрат
 * Выходные данные: 1.00 4.00
 */

public class ShapeCalculator {

    public String calculate(String input) {
        String[] parts = input.split(" ");
        String shapeType = parts[0];
        double dimension = parts.length > 1 ? Double.parseDouble(parts[1]) : 1.0;

        double area = 0.0;
        double perimeter = 0.0;

        if ("круг".equals(shapeType)) {
            area = Math.PI * Math.pow(dimension, 2);
            perimeter = 2 * Math.PI * dimension;
        } else if ("квадрат".equals(shapeType)) {
            area = Math.pow(dimension, 2);
            perimeter = 4 * dimension;
        }

        return String.format("%.2f %.2f", area, perimeter);
    }

    public static void main(String[] args) {
        ShapeCalculator calculator = new ShapeCalculator();
        System.out.println(calculator.calculate("круг 3")); // 28.27 18.85
        System.out.println(calculator.calculate("квадрат")); // 1.00 4.00
    }
}

/*
    Преподаватель: Дуплей Максим Игоревич
    Дата: 24.02.2025
*/
