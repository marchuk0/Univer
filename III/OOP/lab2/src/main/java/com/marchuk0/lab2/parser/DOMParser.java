package com.marchuk0.lab2.parser;

import com.marchuk0.lab2.Car;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DOMParser implements Parser {

    @Override
    public List<Car> parse(File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document document;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(file);
        } catch (Exception e) {
            return Collections.emptyList();
        }

        List<Car> carList = new ArrayList<>();
        NodeList carsListDOM = document.getElementsByTagName("car");
        parseCarList(carsListDOM, carList);
        return carList;
    }

    private void parseCarList(NodeList carsListDOM, List<Car> carList) {
        for (int i = 0; i < carsListDOM.getLength(); i++) {
            if (carsListDOM.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element carElement = (Element) carsListDOM.item(i);
                Car car = new Car();
                NodeList carFields = carElement.getChildNodes();

                for (int j = 0; j < carFields.getLength(); j++) {
                    if (carFields.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) carFields.item(j);
                        setCarFields(car, element);
                    }
                }
                carList.add(car);
            }
        }
    }

    private void setCarFields(Car car, Element element) {
        switch (element.getNodeName()) {
            case "brand": {
                car.setBrand(element.getTextContent());
                break;
            }
            case "model": {
                car.setModel(element.getTextContent());
                break;
            }
            case "color": {
                car.setColor(element.getTextContent());
                break;
            }
            case "price": {
                car.setPrice(Integer.parseInt(element.getTextContent()));
                break;
            }
            case "year": {
                car.setYear(Integer.parseInt(element.getTextContent()));
                break;
            }
        }
    }

}
