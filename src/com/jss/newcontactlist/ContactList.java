package com.jss.newcontactlist;

import java.util.*;


/**
 * ContactList class атикпате
 */
public class ContactList {

    public static final String MTS = "095";
    public static final String KievStar = "097";

    //ArrayList<Contact> contactList = new ArrayList<Contact>();
    List<Contact> contactList = new ArrayList<>(); // ромбовидная запись из JDK 7

    public boolean addToTheContactList(Contact contact) {
        return contactList.add(contact);
    }

    /**
     * Show all list
     */
   /* public void contactListShow(ArrayList<Contact> contactList) {
        for (int i = 0; i < contactList.size(); i++) {
            contactList.get(i).contactShow();
        }
    }*/
    public void contactListShow() {
        for (int i = 0; i < contactList.size(); i++) {
            contactList.get(i).contactShow();
        }
    }
    /**
     * Show first five
     */
   /* public void contactListShowFirstFive(ArrayList<Contact> contactList) {
        for (int i = 0; i < 5; i++) {
            contactList.get(i).contactShow();
        }
    }*/

    /**
     * Show contacts by count
     */
    public void contactListShowFirst(int count) {
        if (count <= 0 || count > contactList.size()) {
            System.out.println("incorrect count");
            return;
        }

        for (int i = 0; i < count; i++) {
            contactList.get(i).contactShow();
        }
    }

    /**
     * Show last five
     */
    public void contactListShowLastFive() {
        for (int i = contactList.size() - 5; i < contactList.size(); i++) {
            contactList.get(i).contactShow();
        }
    }

    /**
     * Joined method for show operators contact by incoming code
     */
    public void contactListShowOperator(String operator) { //todo можно объединить в один метод
        if (!((operator != null) && (operator.equals("MTC") || operator.equals("Kievstar")))){
            System.out.println("unknown operator");;
        }
        String code = "";
        if (operator.equals("MTC")) code = MTS; else code = KievStar;
        int resultCounter = 0;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getPhoneNumber().substring(0, 3).contains(code)) {
                contactList.get(i).contactShow();

            } else resultCounter++;
        }
        if (resultCounter == contactList.size()) {
            System.out.println("operator's contacts not found.");
        }
    }
    /**
     * Show all MTC. If not found show special message
     */
    public String contactListShowMTC(ArrayList<Contact> contactList) {
        int resultCounter = 0;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getPhoneNumber().substring(0, 3).contains("MTS")) {
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
            if (contactList.get(i).getPhoneNumber().substring(0, 3).contains("KievStar")) {
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
    /*public ArrayList<Contact> removeLastContact(ArrayList<Contact> contactList) {
        contactList.remove(contactList.size() - 1);
        return contactList;
    }*/
    public boolean removeLastContact() {
        return contactList.remove(contactList.size() - 1) != null;
    }
    /**
     * Find by multiparameters. If not found show special message
     */
  /*  public ArrayList<Contact> findByFindParam(ArrayList<Contact> contactList, String findParam) {
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
    }*/
    public List<Contact> findByFindParam(String findParam) { //todo List<Contact> вместо ArrayList<Contact>
        int resultCounter = 0;
        List<Contact> find = new ArrayList<>();
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().contains(findParam) || contactList.get(i).getPhoneNumber().contains(findParam)) {
                find.add(contactList.get(i));
                find.get(i).contactShow();
            } else resultCounter++;
        }
        if (resultCounter == contactList.size()) {
            System.out.println("По параметру " + findParam + " контакты не найдены.");
        }

        return find;
    }
    /**
     * Remove by delParam. If not found show special message.//
     */
  /*  public ArrayList<Contact> removeByDelParam(ArrayList<Contact> contactList, String delParam) {//todo while instead if
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
    }*/
    public boolean removeByDelParam(String delParam) {
        int resultCounter = contactList.size();
        for (int i = 0; i < contactList.size(); i++) {
            while (contactList.get(i).getName().contains(delParam) || contactList.get(i).getPhoneNumber().contains(delParam)) {
                contactList.remove(i);
            }
        }

        if (resultCounter == contactList.size()) {
            System.out.println("По параметру " + delParam + " контакты не найдены.");
            return false;
        }
        return true;
    }

    /**
     * Update data by updateParam. If not found show special message
     */
   /* public ArrayList<Contact> updateByParam(ArrayList<Contact> contactList, String updateParam) {
        Scanner sc = new Scanner(System.in);
        int resultCounter = 0;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().contains(updateParam) || contactList.get(i).getPhoneNumber().contains(updateParam)) {
                System.out.println("Введите новое имя для  " + contactList.get(i).getName() + ":");
                contactList.get(i).nameInput(sc);
                contactList.get(i).validatorName(contactList.get(i).getName());

                System.out.println("ВВедите новый номер вместо " + contactList.get(i).getPhoneNumber() + ":");
                contactList.get(i).inputPhoneNamber(sc);
                contactList.get(i).validatorPhone(contactList.get(i).getPhoneNumber());
            } else resultCounter++;
        }
        if (resultCounter == contactList.size()) {
            System.out.println("По параметру " + updateParam + " контакты не найдены.");
        }
        return contactList;
    }*/
    public boolean updateByParam( String updateParam) {
        Scanner sc = new Scanner(System.in);
        int resultCounter = 0;
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getName().contains(updateParam) || contactList.get(i).getPhoneNumber().contains(updateParam)) {
                System.out.println("Введите новое имя для  " + contactList.get(i).getName() + ":");
                contactList.get(i).nameInput(sc);
                contactList.get(i).validatorName(contactList.get(i).getName());

                System.out.println("ВВедите новый номер вместо " + contactList.get(i).getPhoneNumber() + ":");
                contactList.get(i).inputPhoneNamber(sc);
                contactList.get(i).validatorPhone(contactList.get(i).getPhoneNumber());
            } else resultCounter++;
        }
        if (resultCounter == contactList.size()) {
            System.out.println("По параметру " + updateParam + " контакты не найдены.");
            return false;
        }
        return true;
    }

    /**
     * Метод для ввода имени контакта с консоли
     */

//    public Contact contactAddFromConsole() {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("\nДля записи имени используйте символы a-z, A-Z, 0-9, _\n" +
//                "Длина имени от 3 до 15 символов с учетом пробелов. Пример: Vasa Pyatochkin");
//        new Contact().nameInput(sc);
//        new Contact().validatorName(new Contact().getName());
//
//        System.out.println("\nДля записи номера используйте цифры 0-9.\n" +
//                "Длина номера от 7 до 14 символов с учетом пробелов. Допускаются проблелы. Пример: 097 777 77 77");
//        new Contact().inputPhoneNamber(sc);
//        new Contact().validatorPhone(getPhoneNumber());
//
//        return new Contact(getName(), getPhoneNumber());
//    }

}
