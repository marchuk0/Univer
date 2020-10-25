package com.marchuk0.lab1;

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

    private static final int START_COLUMNS = 50;
    private static final int START_ROWS = 50;
    private static final int MIN_CELL_WIDTH = 70;
    private static ObservableList<HashMap<String, Cell>> table = SpreadSheetHelper.table;

    @FXML
    public Button addColumn;
    @FXML
    public Button deleteColumn;
    @FXML
    public Button addRow;
    @FXML
    public Button deleteRow;
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
        initTable();
        tableView.setItems(table);

        saveFile.setOnAction(this::saveFileAction);
        openFile.setOnAction(this::openFileAction);
    }

    private void openFileAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            try (FileInputStream fin = new FileInputStream(file);
                 ObjectInputStream oos = new ObjectInputStream(fin);) {
                ArrayList<HashMap<String, Cell>> toReadObject;
                toReadObject = (ArrayList<HashMap<String, Cell>>) oos.readObject();
                table = FXCollections.observableList(toReadObject);
                tableView.setItems(table);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveFileAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (FileOutputStream fout = new FileOutputStream(file);
                 ObjectOutputStream oos = new ObjectOutputStream(fout);) {
                ArrayList<HashMap<String, Cell>> toWriteObject = new ArrayList<>(table);
                oos.writeObject(toWriteObject);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    private void initTable() {
        addColumns();
        addRows();
    }

    private void addRows() {
        for (int i = 0; i <= START_ROWS; i++) {
            final int row = i;
            table.add(
                    (HashMap<String, Cell>) IntStream
                            .rangeClosed(0, START_COLUMNS)
                            .boxed()
                            .collect(Collectors.toMap(
                                    SpreadSheetHelper::intToColumnNumber,
                                    column -> new Cell(column, row
                                    ))));
        }
    }

    private void addColumns() {
        addZeroColumn();
        for (int i = 1; i <= START_COLUMNS; i++) {
            addColumn(i);
        }
    }

    private void addZeroColumn() {
        TableColumn<HashMap<String, Cell>, String> column = new TableColumn<>("");

        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().get("").getCalculatedValue()));
        column.setMinWidth(55);
        column.setSortable(false);

        tableView.getColumns().add(column);
    }

    private void addColumn(int columnNumber) {
        String columnName = SpreadSheetHelper.intToColumnNumber(columnNumber);
        TableColumn<HashMap<String, Cell>, String> column = new TableColumn<>(columnName);

        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setCellValueFactory(cell -> cell.getValue().get(columnName).getShowValue());

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
