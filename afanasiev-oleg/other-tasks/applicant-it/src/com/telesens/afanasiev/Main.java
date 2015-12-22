/*
Разработать класс для представления претендента на работу в IT - компании.

Должны  быть  представлены  фамилия,  имя, электронный  адрес  и  множество языков программирования,
которыми владеет претендент.

Создать  класс  "Сведения  о  претендентах",  содержащий  ассоциативный массив (Map) с ключами - индивидуальными кодами
претендентов и значениями - данными о претендентах. При добавлении данных проверять, не добавился ли претендент дважды.

Занести  данные в  XML-файл,  затем  прочитать данные и занести в текстовый файл. Вывести данные по алфавиту фамилий.
 */

package com.telesens.afanasiev;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

/**
 * Created by oleg on 12/22/15.
 */
public class Main {
    private static ListApplicants listApplicants;

    public static void main(String[] args) {
        System.out.println("------------ApplicantIT for a job------------");

        ApplicantIT afanasiev = new ApplicantIT(1, "Olegjan", "Afanasiev", "oleg.kh81@gmail.com", "Java", "C++", "C#", "PHP", "Scheme", "JavaScript");
        ApplicantIT petrov = new ApplicantIT(2, "Kolya", "Petrov", "kolya@gmail.com", "Java", "C++", "Rubby", "Assembler");
        ApplicantIT sidorov = new ApplicantIT(3, "Peter", "Sidorov", "peter@gmail.com", "C#", "F#", "Perl", "PHP");
        ApplicantIT ivanova = new ApplicantIT(4, "Liza", "Ivanova", "liza@gmail.com", "Java", "C++", "Python", "PHP");
        ApplicantIT bulbin = new ApplicantIT(5, "Alexandr", "Bulbin", "alex@gmail.com", "Java", "C++", "Delphi", "php", "Lisp", "JavaScript");
        ApplicantIT panina = new ApplicantIT(6, "Helen", "Panina", "helen@gmail.com", "Java", "C++", "Objective C", "php", "Rubby", "JavaScript");

        listApplicants = new ListApplicants(afanasiev, petrov, sidorov, ivanova, bulbin, panina);
        serialization();
        deserialization();
    }

    private static void serialization() {
        try (XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("./resources/list.xml"))) {
            xmlEncoder.writeObject(listApplicants);
            xmlEncoder.flush();
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void deserialization() {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("./resources/list.xml"))) {
            ListApplicants list = (ListApplicants)xmlDecoder.readObject();
            System.out.println(list);
            saveToTxtFile(list);
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void saveToTxtFile(ListApplicants list) {
        try (FileWriter fw = new FileWriter("./resources/list.txt");
                PrintWriter pw = new PrintWriter(fw)) {
            pw.println(list);
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }
}
