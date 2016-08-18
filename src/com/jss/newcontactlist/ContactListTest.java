package com.jss.newcontactlist;

import java.util.regex.*;
import java.util.Scanner;


/**
 * Contact test
 */
public class ContactListTest {
    public static void main(String[] args) {

        mainMenu();
    }

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
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
        list.contactList.add(contact0);
        list.contactList.add(contact1);
        list.contactList.add(contact2);
        list.contactList.add(contact3);
        list.contactList.add(contact4);
        list.contactList.add(contact5);
        list.contactList.add(contact6);
        list.contactList.add(contact7);


        System.out.println("Добро пожаловать в интерактивный контакт - лист!");
        System.out.println(">>>>>>>MAIN MENU / ГЛАВНОЕ МЕНЮ<<<<<<<:");
        System.out.println("Выберите действие");
        System.out.println("\"0\" - Show All/Вывод на экран всех исходных контактов");
        System.out.println("\"1\" - Show first 5 contacts/Показать первые 5 контактов");
        System.out.println("\"2\" - Show last 5 contacts/Показать последние 5 контактов");
        System.out.println("\"3\" - Show all MTC contacts/Показать все МТС контакты");
        System.out.println("\"4\" - Show all Kievstar contacts/Показать все Киевстар контакты");
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
                list.contactListShow(list.contactList);
                subMenu();
            }
            break;
            case 1: {
                System.out.println("Первые 5 контактов:");
                list.contactListShowFirstFive(list.contactList);
                subMenu();
            }
            break;
            case 2: {
                System.out.println("Последние 5 контактов:");
                list.contactListShowLastFive(list.contactList);
                subMenu();
            }
            break;
            case 3: {
                System.out.println("MTC contacts: \n");
                list.contactListShowMTC(list.contactList);
                subMenu();
            }
            break;
            case 4: {
                System.out.println("Kievstar contacts: \n");
                list.contactListShowKievstar(list.contactList);
                subMenu();
            }
            break;
            case 5: {
                System.out.println("Удаление последнего контакта и отображение без него:");
                list.removeLastContact(list.contactList);
                list.contactListShow(list.contactList);
                subMenu();
            }
            break;
            case 6: {
                System.out.println("Поиск контакта по мультипараметру(имени или номеру):");
                list.findByFindParam(list.contactList, "Vasa");

                subMenu();
            }
            break;
            case 7: {
                System.out.println("Добавление контакта в контакт-лист c консоли:");
                list.addToTheContactList(list.contactList, list.contactAddFromConsole());
                list.contactListShow(list.contactList);
                subMenu();
            }
            break;
            case 8: {
                list.removeByDelParam(list.contactList, "Vasa");
                list.contactListShow(list.contactList);
                subMenu();
            }
            break;
            case 9: {
                list.updateByParam(list.contactList, "Vasa");
                list.contactListShow(list.contactList);
                subMenu();
            }
            break;
        }
    }

    /**
     * Подменю для возврата в главное меню по вводу 0
     */
    public static void subMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Возврат в ГЛАВНОЕ МЕНЮ, нажмите \"0\"");
        System.out.println("\"0\" - Return to the MAIN MENU");

        int subSelect = sc.nextInt();
        while (subSelect != 0) {
            System.out.println("Incorrect Selection");
            subSelect = sc.nextInt();

        }
        mainMenu();
    }

    /**
     * Валидатор вібора пункта меню
     */
    public static String menuValidator(String selection) {
        Scanner sc = new Scanner(System.in);
        while (!checkSelection(selection)) {
            System.out.println("Не правильно введен пункт меню. ВВедите число от 0 до 9. Пример: 7");
            selection = sc.nextLine();
        }
        return selection;
    }

    /**
     * Патерн валидации выбора пункта меню, число 0-9, один символ
     */
    public static boolean checkSelection(String selection) {

        Pattern p = Pattern.compile("^[0-9]{1}$");
        Matcher m = p.matcher(selection);
        return m.matches();
    }


}