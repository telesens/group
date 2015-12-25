/*
    Подготовить XML-документ, который описывает данные о городе.
    Сгенерировать классы с помощью технологии связывания данных (JAXB).
    Осуществить чтение данных из XML-документа, модификацию данных и запись их в новый документ.
 */

package com.telesens.afanasiev.module_2_05;

import com.telesens.afanasiev.module_2_05.scheme.City;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by oleg on 12/24/15.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("---------xml parse using JAXB---------");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("com.telesens.afanasiev.module_2_05.scheme");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            City city = (City)unmarshaller.unmarshal(new FileInputStream("./resources/city.xml"));

            outputCity(city);

        } catch(JAXBException | IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void outputCity(City city) {
        System.out.printf("%s (%s) %n", city.getName(), city.getCountry());
        System.out.printf("Население: %d чел.%n%n", city.getPopulation());
        System.out.println("+-----------------+------------+");
        System.out.println("|      Район      |  Население |");
        System.out.println("+-----------------+------------+");

        City.Districts districts = city.getDistricts();
        City.Districts.District district = districts.getDistrict();

            System.out.printf("|  %-14s |   %-8s | %n",
                    district.getValue(), district.getPopulation() == null ? "" : district.getPopulation());

    }
}
