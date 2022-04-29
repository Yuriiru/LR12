package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите строку с корректным IP-адресом ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Pattern P = Pattern.compile("\\b([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\b");
        Matcher m = P.matcher(str);
        if (m.find()) {
            try (FileWriter fw = new FileWriter("IP.txt")) {
                System.out.println("Корректный IP-адрес: " + m.group());
                fw.write("Корректный IP-адрес: " + m.group());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            try (FileWriter fw = new FileWriter("IP.txt")) {
                System.out.println("IP-адрес не корректен");
                fw.write("Не найден корректный IP-адрес");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}