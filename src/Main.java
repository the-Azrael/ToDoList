import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    private static final int INDEX_SHIFT = 1;
    private static List<String> toDoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int item = parseInt(scanner.nextLine());
            switch (item) {
                case 0:
                    sayBye();
                    return;
                case 1:
                    addTask();
                    break;
                case 2:
                    showTasks();
                    break;
                case 3:
                    deleteTask();
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Добавить задачу");
        System.out.println("2. Вывести список задач");
        System.out.println("3. Удалить задачу");
        System.out.println("0. Выход");
        System.out.println("Выберите пункт <");
    }

    private static boolean isEmptyToDoList() {
        if (toDoList.isEmpty()) {
            System.out.println("Список задач пуст!");
        }
        return toDoList.isEmpty();
    }

    private static void sayBye() {
        System.out.println("До новых встреч!");
    }

    private static void addTask() {
        System.out.println("Введите задачу <");
        String newTask = scanner.nextLine();
        toDoList.add(newTask);
    }

    private static void showTasks() {
        if (!isEmptyToDoList()) {
            Iterator<String> toDoIterator = toDoList.iterator();
            System.out.println("\n--- Список задач --- ");
            int index = 0;
            while (toDoIterator.hasNext()) {
                String toDoTask = toDoIterator.next();
                index += INDEX_SHIFT;
                System.out.println("[" + index + "]" + " " + toDoTask);
            }
            System.out.println("--- Конец списка --- \n");
        }
    }

    private static void deleteTask() {
        try {
            if (!isEmptyToDoList()) {
                System.out.println("Введите номер задачи для удаления <");
                int index = parseInt(scanner.nextLine());
                toDoList.remove(index - INDEX_SHIFT);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Индекс задачи вне диапазона задач!\n");
        }

    }

}
