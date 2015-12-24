/*
    Подготовить XML-документ с данными о студентах академической группы.
    С помощью технологии DOM осуществить чтение данных из XML-документа,
    модификацию данных и запись их в новый документ.
 */

package com.telesens.afanasiev.module_2_05;

import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by oleg on 12/24/15.
 */
public class Main {
    public static void main(String[] args)  {
        System.out.println("------------Xml parse using DOM---------");

        outputXML("./resources/group.xml");
        modifyXML("./resources/group.xml", "./resources/groupModified.xml");
        outputXML("./resources/groupModified.xml");
    }

    private static void outputXML(String fPath) {
        int nStudents = 0;

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(new File(fPath));
            Node rootNode = doc.getDocumentElement();
            System.out.printf("\nГруппа \"%s\" %n", rootNode.getAttributes().item(0).getNodeValue());

            System.out.println("+----------+-----------+---------------------------+");
            System.out.println("|    Имя   |   Возраст |            Email          |");
            System.out.println("+----------+-----------+---------------------------+");

            for (int i = 0; i < rootNode.getChildNodes().getLength();i++) {
                Node childNode = rootNode.getChildNodes().item(i);
                switch (childNode.getNodeName()) {
                    case "nstudents":
                        nStudents = Integer.parseInt(childNode.getTextContent());
                        break;

                    case "student":
                        outputStudentInfo(childNode);
                        break;
                }
            }

            System.out.println("+----------+-----------+---------------------------+");
            System.out.println("Общее кол-во: " + nStudents);

        } catch(ParserConfigurationException | IOException |SAXException exc) {
            exc.printStackTrace();
        }
    }

    private static void modifyXML(String fPathSrc, String fPathDst) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(new File(fPathSrc));
            Node rootNode = doc.getDocumentElement();

            deleteStudent(rootNode, "Mikle");
            modifyStudent(rootNode, "Oleg", "Olegjan", "35", "oleg.kh81@mail.ru");
            modifyStudent(rootNode, "Katya", "Katya", "20", "kate@gmail.com");
            addStudent(doc, rootNode, "Olya", "25", "olya@gmail.com");
            addStudent(doc, rootNode, "Polina", "15", "polka@gmail.com");

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(doc),
                    new StreamResult(new FileOutputStream(new File(fPathDst))));
        } catch(ParserConfigurationException | IOException | SAXException |
                TransformerException exc) {
            exc.printStackTrace();
        }
    }

    private static void outputStudentInfo(Node studentNode) {
        Node childNode;
        for (int i = 0; i < studentNode.getChildNodes().getLength(); i++) {
            childNode = studentNode.getChildNodes().item(i);

            switch(childNode.getNodeName()) {
                case "name":
                    System.out.printf("| %-8s ", childNode.getTextContent());
                    break;

                case "age":
                    System.out.printf("|   %-7s ", childNode.getTextContent());
                    break;

                case "email":
                    System.out.printf("| %-25s |%n", childNode.getTextContent());
                    break;
            }
        }
    }

    private static void deleteStudent(Node rootNode, String name) {
        Node nStudentNode = null;
        Node childNode;
        Node removedNode = null;

        for (int i = 0; i < rootNode.getChildNodes().getLength(); i++) {
            childNode = rootNode.getChildNodes().item(i);
            if (childNode.getNodeName().equals("nstudents"))
                nStudentNode = childNode;
            else if (childNode.getNodeName().equals("student"))
                if (isTargetStudent(childNode, name)) {
                    removedNode = childNode;
                }
        }

        if (removedNode != null) {
            int n = Integer.parseInt(nStudentNode.getTextContent());
            rootNode.removeChild(removedNode);
            n--;
            nStudentNode.setTextContent(Integer.toString(n));
        }
    }

    private static void modifyStudent(Node rootNode, String oldName, String newName, String newAge, String newEmail) {
        Node childNode;
        for (int i = 0; i < rootNode.getChildNodes().getLength(); i++) {
            childNode = rootNode.getChildNodes().item(i);
            if (childNode.getNodeName().equals("student"))
                if (isTargetStudent(childNode, oldName)) {
                    for (int j = 0; j < childNode.getChildNodes().getLength(); j++)
                        switch (childNode.getChildNodes().item(j).getNodeName()) {
                            case "name":
                                childNode.getChildNodes().item(j).setTextContent(newName);
                                break;

                            case "age":
                                childNode.getChildNodes().item(j).setTextContent(newAge);
                                break;

                            case "email":
                                childNode.getChildNodes().item(j).setTextContent(newEmail);
                                break;
                        }
                }
        }
    }

    private static void addStudent(Document doc, Node rootNode, String name, String age, String email) {
        Node studentNode = doc.createElement("student");
        Node nameNode = doc.createElement("name");
        Node ageNode = doc.createElement("age");
        Node emailNode = doc.createElement("email");

        nameNode.setTextContent(name);
        ageNode.setTextContent(age);
        emailNode.setTextContent(email);

        studentNode.appendChild(nameNode);
        studentNode.appendChild(ageNode);
        studentNode.appendChild(emailNode);

        rootNode.appendChild(studentNode);

        Node childNode;
        for (int i = 0; i < rootNode.getChildNodes().getLength(); i++) {
            childNode = rootNode.getChildNodes().item(i);
            if (childNode.getNodeName().equals("nstudents")) {
                int n = Integer.parseInt(childNode.getTextContent());
                n++;
                childNode.setTextContent(Integer.toString(n));
            }
        }
    }

    private static boolean isTargetStudent(Node nodeStudent, String name) {
        Node childNode;
        for (int i = 0; i < nodeStudent.getChildNodes().getLength(); i++) {
            childNode = nodeStudent.getChildNodes().item(i);
            if (childNode.getNodeName().equals("name"))
                if (childNode.getTextContent().equals(name))
                    return true;
        }

        return false;
    }
}
