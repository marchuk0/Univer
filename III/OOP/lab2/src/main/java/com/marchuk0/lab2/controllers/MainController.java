package com.marchuk0.lab2.controllers;

import com.marchuk0.lab2.Car;
import com.marchuk0.lab2.parser.DOMParser;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.marchuk0.lab2.parser.Parser;

import java.io.File;
import java.util.List;

public class MainController {

    public Button searchButton;
    public Button clearButton;
    public Button transformButton;
    public CheckBox titleCheckBox;
    public CheckBox genreCheckBox;
    public CheckBox yearCheckBox;
    public CheckBox countryCheckBox;
    public CheckBox directorCheckBox;
    public TextField nameTextField;
    public TextField genreTextField;
    public TextField yearTextField;
    public TextField countryTextField;
    public TextField directorTextField;
    public TextArea fileTextField;
    public RadioButton radioButton;
    public RadioButton radioButton2;

    //    private Transformer transformer = new Transformer();
    private Parser parser = new DOMParser();
    File file = new File("/home/olexander/important/cyb/university/III/OOP/lab2/src/main/resources/carsDatabase.xml");
    List<Car> carsList = parser.parse(file);


    private String title = null;
    private String genre = null;
    private int year = -1;
    private String country = null;
    private String director = null;

    @FXML
    public void initialize() {
        printCars(carsList);
        searchButton.setOnAction(actionEvent ->
        {
            List<Car> filteredList = filter(carsList);
            printCars(filteredList);
        });

        clearButton.setOnAction(actionEvent ->
        {
            clear();
        });

        transformButton.setOnAction(actionEvent ->
        {
            transform();
        });
    }

    private List<Car> filter(List<Car> carsList) {
        return carsList;
    }

    private void printCars(List<Car> cars) {
        StringBuilder builder = new StringBuilder();
        for (Car car : cars) {
            builder.append(car.toString());
            builder.append("\n=======\n");
        }
        fileTextField.setText(builder.toString());
    }


    private void transform() {
//        transformer.transform();
//        File htmlFile = new File("D:\\Programming\\XmlToHtmlParserApp\\src\\app\\filmLibrary.html");
//        try {
//            Desktop.getDesktop().browse(htmlFile.toURI());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void clear() {
        titleCheckBox.setSelected(false);
        genreCheckBox.setSelected(false);
        yearCheckBox.setSelected(false);
        countryCheckBox.setSelected(false);
        directorCheckBox.setSelected(false);
        nameTextField.clear();
        genreTextField.clear();
        yearTextField.clear();
        countryTextField.clear();
        directorTextField.clear();
        fileTextField.clear();
        title = null;
        genre = null;
        year = -1;
        country = null;
        director = null;
    }

}
