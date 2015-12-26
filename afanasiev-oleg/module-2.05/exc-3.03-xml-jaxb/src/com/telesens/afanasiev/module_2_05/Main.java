/*
    Подготовить XML-документ, который описывает данные о городе.
    Сгенерировать классы с помощью технологии связывания данных (JAXB).
    Осуществить чтение данных из XML-документа, модификацию данных и запись их в новый документ.
 */

package com.telesens.afanasiev.module_2_05;

import com.telesens.afanasiev.module_2_05.scheme.City;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileWriter;
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

            modifyDistrict(city, "Журавлевка", "Журавлевка", 25000);
            addDistrict(city, "Павлово Поле", 120000);
            deleteDistrict(city, "ХТЗ");

            outputCity(city);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(city, new FileWriter("./resources/cityCorrected.xml"));

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

        for (City.Districts.District district : city.getDistricts().getDistrict()) {
            System.out.printf("|  %-14s |   %-8s | %n",
                    district.getValue(), district.getPopulation() == null ? "" : district.getPopulation());
        }
        System.out.println("+-----------------+------------+");
    }

    private static void addDistrict(City city, String name, int population) {
        City.Districts.District district = new City.Districts.District();
        district.setValue(name);
        district.setPopulation(population);

        city.getDistricts().getDistrict().add(district);
    }

    private static void modifyDistrict(City city, String oldName, String newName, int population) {
        for (City.Districts.District district : city.getDistricts().getDistrict()) {
            if (district.getValue().equals(oldName)) {
                district.setValue(newName);
                district.setPopulation(population);
                break;
            }
        }
    }

    private static void deleteDistrict(City city, String name) {
        City.Districts.District districtTarget = null;

        for (City.Districts.District district : city.getDistricts().getDistrict()) {
            if (district.getValue().equals(name)) {
                districtTarget = district;
                break;
            }
        }

        city.getDistricts().getDistrict().remove(districtTarget);
    }
}
