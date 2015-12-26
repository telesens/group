/*
    Подготовить XML-документ с данными о студентах академической группы.
    С помощью технологии SAX осуществить чтение данных из XML-документа и вывод данных на консоль
 */

package com.telesens.afanasiev.module_2_05;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by oleg on 12/23/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---------Read from xml using sax------");

        SAXParser parser = null;
        try {
            parser = SAXParserFactory.newInstance().newSAXParser();
        } catch(ParserConfigurationException | SAXException exc) {
            exc.printStackTrace();
        }

        if (parser != null) {
            InputSource input = new InputSource("./resources/group.xml");
            try {
                parser.parse(input, new GroupSAX());
            } catch(SAXException | IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}
