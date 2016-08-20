package com.jss.newcontactlist;


import java.io.IOException;
import java.util.regex.*;
import java.util.Scanner;


/**
 * Contact test
 */
public class ContactListTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        mainMenu();


    }

    public static void mainMenu() throws IOException, ClassNotFoundException {
        Scanner sc = getScanner();
        Contact contact0 = new Contact();
        contact0.setName("Vasa");
        contact0.setPhoneNumber("095 1232323");

        Contact contact1 = new Contact("Petya", "097 2323232");
        Contact contact2 = new Contact("Petya", "095 2323232");
        Contact contact3 = new Contact("Anna", "097 54545454");
        Contact contact4 = new Contact("Lena", "095 1111111");
        Contact contact5 = new Contact("Lada", "097 5555555");
        Contact contact6 = new Contact("Nadia", "095 1212121");
        Contact contact7 = new Contact("Inokyntiy", "097 7777777");

        ContactList list = new ContactList();
        list.addToTheContactList(contact0);
        list.addToTheContactList(contact1);
        list.addToTheContactList(contact2);
        list.addToTheContactList(contact3);
        list.addToTheContactList(contact4);
        list.addToTheContactList(contact5);
        list.addToTheContactList(contact6);
        list.addToTheContactList(contact7);

        // list.teleport();

        //list.replicate();


        System.out.println("Добро пожаловать в интерактивный контакт - лист!");
        System.out.println(">>>>>>>MAIN MENU / ГЛАВНОЕ МЕНЮ<<<<<<<:");
        System.out.println("Выберите действие");
        System.out.println("\"0\" - Show All/Вывод на экран всех исходных контактов");
        System.out.println("\"1\" - Show first 5 contacts/Показать первые 5 контактов");
        System.out.println("\"2\" - Show last 5 contacts/Показать последние 5 контактов");
        System.out.println("\"3\" - Show all MTC contacts/Показать все МТС контакты");
        System.out.println("\"4\" - File Operations/Запись контакт - листа в файл, чтение из файла");
        System.out.println("\"5\" - Remove Last Contact and show without him/Удалить последний контакт и показать без него");
        System.out.println("\"6\" - Find contact by multiparameters(name or phone)/Поиск контакта по мультипараметру(имени или номеру)");
        System.out.println("\"7\" - Add to the contactList from console/Добавление в контакт лист нового контакта из консоли");
        System.out.println("\"8\" - Remove from contactList by multiparameters(name or phone) adn show contactList without him/\n" +
                "Удаление контакта по мультипараметру(имени или номеру) и отображение контакт - листа без него");
        System.out.println("\"9\" - Updating contact info. At first we find current contact by multiparameters(name or phone) and add new data\n" +
                "from console");
        // System.out.println("\"q\" - Exit from program/Выход из программы"); will be released later
        System.out.print("Сделайте выбор пункта меню: ");

//        System.out.println("=========================");

        String selection = sc.nextLine();
        String res = menuValidator(selection);

        int sel = Integer.parseInt(res);

        switch (sel) {
            case 0: {
                System.out.println("Все исходные контакты:");
                list.contactListShow();
                subMenu();
            }
            break;
            case 1: {
                System.out.println("Первые 5 контактов:");
                list.contactListShowFirst(5);
                subMenu();
            }
            break;
            case 2: {
                System.out.println("Последние 5 контактов:");
                list.contactListShowLastFive();
                subMenu();
            }
            break;
            case 3: {
                subMenuOperator(list);
                subMenu();
            }
            break;
            case 4: {
                subMenuFileOperations(list);
                subMenu();
            }
            break;
            case 5: {
                System.out.println("Удаление последнего контакта и отображение без него:");
                list.removeLastContact();
                list.contactListShow();
                subMenu();
            }
            break;
            case 6: {
                list.findByFindParam("Vasa");
                subMenu();
            }
            break;
            case 7: {
                list.addToTheContactList(new Contact().contactAddFromConsole());
                list.contactListShow();
                subMenu();
            }
            break;
            case 8: {
                list.removeByDelParam("Vasa");
                list.contactListShow();
                subMenu();
            }
            break;
            case 9: {
                list.updateByParam("Vasa");
                list.contactListShow();
                subMenu();
            }
            break;
        }
    }

    /**
     * Подменю для возврата в главное меню по вводу 0
     */
    public static void subMenu() throws IOException, ClassNotFoundException {
        Scanner sc = getScanner();

        System.out.println("Возврат в ГЛАВНОЕ МЕНЮ, нажмите \"0\"");
        System.out.println("\"0\" - Return to the MAIN MENU");

        int subSelect = sc.nextInt();
        while (subSelect != 0) {
            System.out.println("Incorrect Selection");
            subSelect = sc.nextInt();

        }
        mainMenu();
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void subMenuOperator(ContactList list) throws IOException, ClassNotFoundException {
        Scanner sc = getScanner();
        System.out.println("Выберете оператора для отображения контактов:");
        System.out.println("\"1\" - Оператор МТС");
        System.out.println("\"2\" - Оператор Киевстар");
        System.out.println("\"0\" - Возврат в ГЛАВНОЕ МЕНЮ");
        String selection = sc.nextLine();
        String res = OperatopMenuValidator(selection);

        int sel = Integer.parseInt(res);

        switch (sel) {
            case 0: {
                mainMenu();
            }
            break;
            case 1: {
                list.contactListShowOperator("MTC");
                subMenu();
            }
            case 2: {
                System.out.println("Kievstar contacts: \n");
                list.contactListShowOperator("Kievstar");
                subMenu();
            }
            case 3: {
                subMenuOperator(list);
            }
        }
    }

    public static void subMenuFileOperations(ContactList list) throws IOException, ClassNotFoundException {
        Scanner sc = getScanner();
        System.out.println("Выберете оператора для отображения контактов:");
        System.out.println("\"1\" - Сохранение контакт - листа в файл D://ContactList.txt");
        System.out.println("\"2\" - Чтение контакт - листа из файла D://ContactList.txt");
        System.out.println("\"0\" - Возврат в ГЛАВНОЕ МЕНЮ");
        String selection = sc.nextLine();
        String res = OperatopMenuValidator(selection);

        int sel = Integer.parseInt(res);

        switch (sel) {
            case 0: {
                mainMenu();
            }
            break;
            case 1: {
                System.out.println("Контакт лист записан в файл: D://ContactList.txt");
                list.teleport();
                subMenu();
            }
            case 2: {
                System.out.println("Контакт лист считан из файла: D://ContactList.txt");
                list.replicate();
                subMenu();
            }
        }
    }





    /**
     * Валидатор вібора пункта меню
     */
    public static String menuValidator(String selection) {
        Scanner sc = getScanner();
        while (!checkSelection(selection)) {
            System.out.println("Не правильно введен пункт меню. ВВедите число от 0 до 9. Пример: 7");
            selection = sc.nextLine();
        }
        return selection;
    }

    /**
     * Патерн валидации выбора пункта меню, число 0-9, один символ
     */
/*    public static boolean checkSelection(String selection) {

        Pattern p = Pattern.compile("^[0-9]{1}$");
        Matcher m = p.matcher(selection);
        return m.matches();
    }*/
    public static boolean checkSelection(String selection) {

        Pattern p = Pattern.compile("^[0-9]{1}$");
        Matcher m = p.matcher(selection);
        return m.matches();
    }

    public static String OperatopMenuValidator(String selection) {
        Scanner sc = getScanner();
        while (!checkOperatopMenuSelection(selection)) {
            System.out.println("Не правильно введен пункт меню. ВВедите число от 0 до 2. Пример: 2");
            selection = sc.nextLine();
        }
        return selection;
    }

    public static boolean checkOperatopMenuSelection(String selection) {

        Pattern p = Pattern.compile("^[0-2]{1}$");
        Matcher m = p.matcher(selection);
        return m.matches();
    }



}