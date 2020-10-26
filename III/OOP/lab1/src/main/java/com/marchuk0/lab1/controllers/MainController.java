package com.marchuk0.lab1.controllers;

import com.marchuk0.lab1.utils.Cell;
import com.marchuk0.lab1.utils.SpreadSheetHelper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainController implements Initializable {

    private static final int START_COLUMNS = 40;
    private static final int START_ROWS = 40;
    private static final int MIN_CELL_WIDTH = 70;
    private static final String FILE_TEXT = "My files files (*.marchuk)";
    private static final String FILE_EXTENSION = "*.marchuk";
    private static ObservableList<HashMap<String, Cell>> table = SpreadSheetHelper.table;


    @FXML
    public Button saveFile;
    @FXML
    public Button openFile;
    @FXML
    private TableView<HashMap<String, Cell>> tableView;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.setEditable(true);
        initTable(START_COLUMNS, START_ROWS);
        tableView.setItems(table);

        saveFile.setOnAction(this::saveFileAction);
        openFile.setOnAction(this::openFileAction);
    }

    private void openFileAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(FILE_TEXT, FILE_EXTENSION);
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            try (FileInputStream fin = new FileInputStream(file);
                 ObjectInputStream oos = new ObjectInputStream(fin)) {
                ArrayList<HashMap<String, Cell>> toReadObject;
                toReadObject = (ArrayList<HashMap<String, Cell>>) oos.readObject();
                table = FXCollections.observableList(toReadObject);
                SpreadSheetHelper.table = table;
                tableView.getColumns().clear();
                tableView.setItems(FXCollections.observableArrayList());
                initTable(table.size(), table.get(0).size());
                tableView.setItems(table);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveFileAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(FILE_TEXT, FILE_EXTENSION);
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (FileOutputStream fout = new FileOutputStream(file);
                 ObjectOutputStream oos = new ObjectOutputStream(fout)) {
                ArrayList<HashMap<String, Cell>> toWriteObject = new ArrayList<>(table);
                oos.writeObject(toWriteObject);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    private void initTable(int columnNumber, int rowNumber) {
        addColumns(columnNumber);
        if (table.size() == 0) {
            addRows(columnNumber, rowNumber);
        }
    }

    private void addRows(int columnNumber, int rowNumber) {
        for (int i = 0; i <= rowNumber; i++) {
            final int row = i;
            table.add(
                    (HashMap<String, Cell>) IntStream
                            .rangeClosed(-1, columnNumber)
                            .boxed()
                            .collect(Collectors.toMap(
                                    SpreadSheetHelper::intToColumnNumber,
                                    column -> new Cell(column, row
                                    ))));
        }
    }

    private void addColumns(int columnNumber) {
        addZeroColumn();
        for (int i = 0; i <= columnNumber; i++) {
            addColumn(i);
        }
    }

    private void addZeroColumn() {
        String columnName = SpreadSheetHelper.intToColumnNumber(-1);
        TableColumn<HashMap<String, Cell>, String> column = new TableColumn<>(columnName);

        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().get(columnName).getRowNumber()));
        column.setMinWidth(55);
        column.setEditable(false);
        column.setSortable(false);

        tableView.getColumns().add(column);
    }

    private void addColumn(int columnNumber) {
        String columnName = SpreadSheetHelper.intToColumnNumber(columnNumber);
        TableColumn<HashMap<String, Cell>, String> column = new TableColumn<>(columnName);

        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setCellValueFactory(cell -> cell.getValue().getOrDefault(columnName, new Cell()).getShowValue());

        column.setMinWidth(MIN_CELL_WIDTH);
        column.setSortable(false);

        column.setOnEditStart(event -> {
            int row = event.getTablePosition().getRow();
            startEditingCell(row, columnNumber);
        });

        column.setOnEditCommit(event -> {
            int row = event.getTablePosition().getRow();
            String newValue = event.getNewValue();
            finishEditingCell(row, columnNumber, newValue);

        });

        tableView.getColumns().add(column);
    }

    private void startEditingCell(int row, int column) {
        Cell cell = tableView.getItems().get(row).get(SpreadSheetHelper.intToColumnNumber(column));
        cell.setEditing(true);
    }


    private void finishEditingCell(int row, int column, String newValue) {
        Cell cell = tableView.getItems().get(row).get(SpreadSheetHelper.intToColumnNumber(column));
        cell.setValue(newValue);
        cell.setEditing(false);
    }

}
