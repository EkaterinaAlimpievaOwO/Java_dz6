import java.util.*;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
//  что 1 человек может иметь несколько телефонов.
//  Нужны методы добавления новой записи в книгу и метод поиска записей в телефонной книге

public class Java_dz6 {
    private Map<String, List<String>> contacts;

    public Java_dz6() {
        contacts = new HashMap<>();
    }

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя контакта: ");
        String name = scanner.nextLine();
        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.nextLine();

        List<String> phoneNumbers = contacts.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        contacts.put(name, phoneNumbers);

        System.out.println("Контакт успешно добавлен в телефонную книгу.");
    }

    public void updateContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя контакта для обновления: ");
        String name = scanner.nextLine();
        System.out.print("Введите старый номер телефона: ");
        String oldPhoneNumber = scanner.nextLine();
        System.out.print("Введите новый номер телефона: ");
        String newPhoneNumber = scanner.nextLine();

        List<String> phoneNumbers = contacts.get(name);
        if (phoneNumbers != null) {
            if (phoneNumbers.contains(oldPhoneNumber)) {
                phoneNumbers.remove(oldPhoneNumber);
                phoneNumbers.add(newPhoneNumber);
                System.out.println("Контакт успешно обновлен.");
            } else {
                System.out.println("Старый номер телефона не найден для контакта: " + name);
            }
        } else {
            System.out.println("Контакт не найден: " + name);
        }
    }

    public void searchContacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя контакта для поиска: ");
        String name = scanner.nextLine();

        List<String> phoneNumbers = contacts.get(name);
        if (phoneNumbers != null) {
            System.out.println("Контакт: " + name);
            for (String phoneNumber : phoneNumbers) {
                System.out.println("Номер телефона: " + phoneNumber);
            }
        } else {
            System.out.println("Контакт не найден: " + name);
        }
    }

    public static void main(String[] args) {
        Java_dz6 phoneBook = new Java_dz6();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить новую запись");
            System.out.println("2. Обновить существующую запись");
            System.out.println("3. Поиск записей");
            System.out.println("4. Выход");
            System.out.print("Введите номер действия: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем символ новой строки после ввода числа

            switch (choice) {
                case 1:
                    phoneBook.addContact();
                    break;
                case 2:
                    phoneBook.updateContact();
                    break;
                case 3:
                    phoneBook.searchContacts();
                    break;
                case 4:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный номер действия. Попробуйте еще раз.");
            }

            System.out.println();
        }
    }
}
