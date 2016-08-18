package com.jss.newcontactlist;

import java.util.Scanner;
import java.util.regex.*;
/**Меня замахал NullPointerException и поэтому было решено применить ArrayList т.к. он может хранить в себе даже Null.
 * Весь головняк по расширению и прочим телодвижениям по массиву тоже перешел к ArrayList-у. Слава JDK.
 *Фиксы:
 * -все классы отдельно, все методы отдельно, не статик методы;
 * -более глубоко изучено применение модификаторов доступа, так так же геттеров и сеттеров;
 * -применено наследование чтобы покрутить protected поля;
 * -в методы добавлены проверки отрицательного резултата;
 * -сделано еще больше открытий;
 */
/**
 * @autor   Jack:
 * email:   jackkobec@gmail.com
 * Skype:   skypejs77
 * @version 3.0
 */
/**
 * Contact class
 */
public class Contact {
    protected String name;
    private String phoneNumber;
    /**
     * Constructors
     */
    public Contact() {
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    /**
     * Getters \ setters
     */
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * Format contact info to template and show
     */
    public String contactShow() {
        System.out.println(String.format("\nname: %s\nphoneNamber: %s ", name, phoneNumber
                + "\n------------------------"));
        return "";
    }
    /**
     * Input contact name from console
     */
    public  void nameInput(Scanner sc) {

        System.out.print("\n>>>Enter contact name: ");
        this.name = sc.nextLine();
    }

    /**
     * Input contact phone from console
     */
    public void inputPhoneNamber(Scanner sc) {
        System.out.print("\n>>>Enter contact phone: ");
        setPhoneNumber(sc.nextLine());
    }

    /**
     * Валидатор имени символы a-z, A-Z, 0-9, длина 3-15
     */
    public void validatorName(String name) {
        Scanner sc = new Scanner(System.in);
        while (!checkName()) {
            System.out.println("Не правильно введено имя. Для записи имени используйте символы a-z, A-Z, 0-9, _\n" +
                    "Длина имени от 3 до 15 символов с учетом пробелов. Пример: Vasa Pyatochkin");
             nameInput(sc);
        }

    }

    /**
     * Валидатор иномера телефона символы -9, длина 7-14
     */
    public void validatorPhone(String phoneNamber) {
        Scanner sc = new Scanner(System.in);
        while (!checkPhoneNamber()) {
            System.out.println("Не правильно введен номер телефона. Для записи номера используйте цифры 0-9.\n" +
                    "Длина номера от 7 до 14 символов с учетом пробелов. Допускаются проблелы. Пример: 093 772 17 49");
            inputPhoneNamber(sc);
        }


    } /**
     * Патерн валидации имени
     */
    public boolean checkName() {
        Pattern p = Pattern.compile("^[\\sA-Za-z0-9_]{3,15}$");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    /**
     * Патерн валидации номера телефона
     */
    public boolean checkPhoneNamber() {

        Pattern p = Pattern.compile("^[\\s0-9\\s]{7,14}$");
        Matcher m = p.matcher(getPhoneNumber());
        return m.matches();
    }

}


