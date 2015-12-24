package com.telesens.afanasiev.module_2_05;

import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by oleg on 12/23/15.
 */
public class GroupSAX extends DefaultHandler {

    private int nTotal;
    private boolean isNTotal = false;
    private boolean isName = false;
    private boolean isAge = false;
    private boolean isEmail = false;

    @Override
    public void startDocument() {

    }

    @Override
    public void endDocument() {
        System.out.println("+-----------+------------+----------------------+");
        System.out.println("Общее кол-во: " + nTotal);
    }

    @Override
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes) throws SAXException {
        switch(qName) {
            case "group":
                System.out.println("Группа: " + attributes.getValue(0));
                System.out.println("+-----------+------------+----------------------+");
                System.out.println("|    Имя    |   Возраст  |         email        |");
                System.out.println("+-----------+------------+----------------------+");
                break;

            case "student":
               // System.out.println("\n****");
                break;

            case "name":
               // System.out.print("Имя: ");
                isName = true;
                break;

            case "age":
              //  System.out.print("Возраст: ");
                isAge = true;
                break;

            case "email":
              //  System.out.print("Email: ");
                isEmail = true;
                break;

            case "nstudents":
                isNTotal = true;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (isEmail)
            System.out.println();

        isNTotal = false;
        isName = false;
        isAge = false;
        isEmail = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch).substring(start, start + length).trim();

        if (isNTotal)
            nTotal = Integer.parseInt(s);
        else if (isName)
            System.out.printf("| %-9s ",  s);
        else if (isAge)
            System.out.printf("|    %-7s ", s);
        else if (isEmail)
            System.out.printf("|  %-19s |", s);
        else if (s.length() > 0) {
                System.out.println(s);
            }
    }
}
