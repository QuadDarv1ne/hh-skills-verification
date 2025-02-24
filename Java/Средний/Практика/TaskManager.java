/**
 * [ Список задач по приоритету ]
 * Средний - Классы и методы - Цепочка вызовов - Односвязный список - Сортировка
 * 
 * Эта программа на Java управляет списком задач с приоритетами.
 * Каждая задача имеет название и приоритет.
 * 
 * Программа поддерживает следующие операции:
 * 1. ADD,название_задачи,приоритет_задачи — добавление новой задачи в список;
 * 2. REMOVE — удаление наиболее приоритетной задачи из списка. Если несколько задач имеют одинаковый приоритет, удаляется первая по алфавиту задача. Если задач в списке нет, ничего не происходит.
 * 3. GET — выводит все задачи, которые остались в списке, по порядку приоритета.
 *
 * Формат ввода:
 * Одна строка, содержащая команды и их параметры (если есть). Команды разделены через точку с запятой, параметры — через запятую.
 *
 * Формат вывода:
 * Одна строка — все задачи, которые остались в списке, через точку с запятой.
 * Задачи отсортированы от наиболее к наименее приоритетным (от 1 до 5), задачи с одним приоритетом отсортированы в алфавитном порядке.
 * Если в списке не осталось задач, выводится «Список пуст».
 *
 * Пример №1:
 * Входные данные: "ADD,НаписатьКод,2;ADD,ТестироватьКод,3;ADD,ОтветитьНаСообщения,1;REMOVE;GET"
 * Выходные данные: "НаписатьКод,2;ТестироватьКод,3"
 *
 * Пример №2:
 * Входные данные: "REMOVE;ADD,КупитьПродукты,3;REMOVE;ADD,СделатьУборку,2;ADD,Постирать,5;ADD,Погладить,5;GET"
 * Выходные данные: "СделатьУборку,2;Погладить,5;Постирать,5"
 *
 * Пример №3:
 * Входные данные: "ADD,ПосетитьВстречу,2;REMOVE;ADD,ПрочитатьГазету,1;REMOVE;GET"
 * Выходные данные: "Список пуст"
 */

import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

class Task {
    String name;
    int priority;

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + "," + priority;
    }
}

public class TaskManager {

    private LinkedList<Task> taskList;

    public TaskManager() {
        taskList = new LinkedList<>();
    }

    public void addTask(String name, int priority) {
        taskList.add(new Task(name, priority));
    }

    public void removeTask() {
        if (!taskList.isEmpty()) {
            // Сортируем список задач по приоритету и алфавиту
            Collections.sort(taskList, new Comparator<Task>() {
                @Override
                public int compare(Task t1, Task t2) {
                    if (t1.priority != t2.priority) {
                        return Integer.compare(t1.priority, t2.priority);
                    } else {
                        return t1.name.compareTo(t2.name);
                    }
                }
            });
            // Удаляем первую задачу (наиболее приоритетную)
            taskList.remove(0);
        }
    }

    public String getTasks() {
        if (taskList.isEmpty()) {
            return "Список пуст";
        }

        // Сортируем список задач по приоритету и алфавиту
        Collections.sort(taskList, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                if (t1.priority != t2.priority) {
                    return Integer.compare(t1.priority, t2.priority);
                } else {
                    return t1.name.compareTo(t2.name);
                }
            }
        });

        // Формируем строку с задачами
        StringBuilder result = new StringBuilder();
        for (Task task : taskList) {
            result.append(task.toString()).append(";");
        }
        // Убираем последнюю точку с запятой
        return result.substring(0, result.length() - 1);
    }

    public String manageTasks(String input) {
        String[] commands = input.split(";");

        for (String command : commands) {
            if (command.startsWith("ADD")) {
                String[] parts = command.split(",");
                String name = parts[1];
                int priority = Integer.parseInt(parts[2]);
                addTask(name, priority);
            } else if (command.equals("REMOVE")) {
                removeTask();
            } else if (command.equals("GET")) {
                return getTasks();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Примеры использования
        System.out.println(manager.manageTasks("ADD,НаписатьКод,2;ADD,ТестироватьКод,3;ADD,ОтветитьНаСообщения,1;REMOVE;GET"));
        // НаписатьКод,2;ТестироватьКод,3

        System.out.println(manager.manageTasks("REMOVE;ADD,КупитьПродукты,3;REMOVE;ADD,СделатьУборку,2;ADD,Постирать,5;ADD,Погладить,5;GET"));
        // СделатьУборку,2;Погладить,5;Постирать,5

        System.out.println(manager.manageTasks("ADD,ПосетитьВстречу,2;REMOVE;ADD,ПрочитатьГазету,1;REMOVE;GET"));
        // Список пуст
    }
}
