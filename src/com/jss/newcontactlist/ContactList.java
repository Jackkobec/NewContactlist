package com.jss.newcontactlist;

import java.util.*;


/**
 * ContactList class
 */
public class ContactList extends Contact {
    ArrayList<Contact> contactList = new ArrayList<Contact>();

    public ArrayList<Contact> addToTheContactList(ArrayList<Contact> contactList, Contact contact) {
        contactList.add(contact);
        return contactList;
    }

    /**
     * Show all list
     */
    public void contactListShow(ArrayList<Contact> contactList) {
        for (int i = 0; i < contactList.size(); i++) {
            contactList.get(i).contactShow();
        }
    }

    /**
     * Show first five
     */
    public void contactListShowFirstFive(ArrayList<Contact> contactList) {
        for (int i = 0; i < 5; i++) {
            contactList.get(i).contactShow();
        }
    }

    /**
     * Show last five
     */
    public void contactListShowLastFive(ArrayList<Contact> contactList) {
        for (int i = contactList.size() - 5; i < contactList.size(); i++) {
            contactList.get(i).contactShow();
        }
    }

    /**
     * Show all MTC. If not found show special message
     */
    public String contactListShowMTC(ArrayList<Contact> contactList) {
        int resultCounter = 0;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getPhoneNumber().substring(0, 3).contains("095")) {
                contactList.get(i).contactShow();

            } else resultCounter++;
        }
        if (resultCounter == contactList.size()) {
            System.out.println("MTS contacts not found.");
        }
        return null;
    }

    /**
     * Show all Kievstar. If not found show special message
     */
    public String contactListShowKievstar(ArrayList<Contact> contactList) {
        int resultCounter = 0;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getPhoneNumber().substring(0, 3).contains("097")) {
                contactList.get(i).contactShow();

            } else resultCounter++;
        }
        if (resultCounter == contactList.size()) {
            System.out.println("Kievstar contacts not found.");
        }
        return null;
    }

    /**
     * Remove last contact from list
     */
    public ArrayList<Contact> removeLastContact(ArrayList<Contact> contactList) {
        contactList.remove(contactList.size() - 1);
        return contactList;
    }

    /**
     * Find by multiparameters. If not found show special message
     */
    public ArrayList<Contact> findByFindParam(ArrayList<Contact> contactList, String findParam) {
        int resultCounter = 0;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().contains(findParam) || contactList.get(i).getPhoneNumber().contains(findParam)) {
                System.out.println("По критерию " + findParam + " найден контакт:");
                contactList.get(i).contactShow();
            } else resultCounter++;
        }
        if (resultCounter == contactList.size()) {
            System.out.println("По параметру " + findParam + " контакты не найдены.");
        }
        return contactList;
    }

    /**
     * Remove by delParam. If not found show special message
     */
    public ArrayList<Contact> removeByDelParam(ArrayList<Contact> contactList, String delParam) {
        int resultCounter = contactList.size();
        for (int i = 0; i < contactList.size(); i++) {
            while (contactList.get(i).getName().contains(delParam) || contactList.get(i).getPhoneNumber().contains(delParam)) {
                contactList.remove(i);
            }
        }
        if (resultCounter == contactList.size()) {
            System.out.println("По параметру " + delParam + " контакты не найдены.");
        }
        return contactList;
    }

    /**
     * Update data by updateParam. If not found show special message
     */
    public ArrayList<Contact> updateByParam(ArrayList<Contact> contactList, String updateParam) {
        Scanner sc = new Scanner(System.in);
        int resultCounter = 0;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().contains(updateParam) || contactList.get(i).getPhoneNumber().contains(updateParam)) {
                System.out.println("Введите новое имя для  " + contactList.get(i).name + ":");
                contactList.get(i).nameInput(sc);
                contactList.get(i).validatorName(contactList.get(i).name);

                System.out.println("ВВедите новый номер вместо " + contactList.get(i).getPhoneNumber() + ":");
                contactList.get(i).inputPhoneNamber(sc);
                contactList.get(i).validatorPhone(contactList.get(i).getPhoneNumber());
            } else resultCounter++;
        }
        if (resultCounter == contactList.size()) {
            System.out.println("По параметру " + updateParam + " контакты не найдены.");
        }
        return contactList;
    }

    /**
     * Метод для ввода имени контакта с консоли
     */

    public Contact contactAddFromConsole() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nДля записи имени используйте символы a-z, A-Z, 0-9, _\n" +
                "Длина имени от 3 до 15 символов с учетом пробелов. Пример: Vasa Pyatochkin");
        nameInput(sc);
        validatorName(getName());

        System.out.println("\nДля записи номера используйте цифры 0-9.\n" +
                "Длина номера от 7 до 14 символов с учетом пробелов. Допускаются проблелы. Пример: 097 777 77 77");
        inputPhoneNamber(sc);
        validatorPhone(getPhoneNumber());

        return new Contact(getName(), getPhoneNumber());
    }

}
