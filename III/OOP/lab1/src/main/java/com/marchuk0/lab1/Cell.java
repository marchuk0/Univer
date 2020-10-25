package com.marchuk0.lab1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.io.Serializable;

public class Cell implements Serializable {
    private transient SimpleStringProperty showValue;
    private String value;
    private String calculatedValue;
    private int row;
    private int column;
    private boolean isEditing = false;

    public Cell(int column, int row) {
        this.column = column;
        this.row = row;
        this.value = "";
        this.showValue = new SimpleStringProperty(value);
        this.calculateValue();
    }


    public String getValue() {
        return value;
    }

    public String getCalculatedValue() {
        if (column == 0) {
            return SpreadSheetHelper.intToRowNumber(row);
        }
        return calculatedValue;
    }

    public void setValue(String value) {
        this.value = value;
        this.calculateValue();
    }

    private void calculateValue() {
        try {
            calculatedValue = SpreadSheetHelper.evalExpression(value);
        } catch (Exception e) {
            calculatedValue = "Error";
        }
        this.updateShowValue();
    }

    public void setEditing(Boolean editing) {
        isEditing = editing;
        this.updateShowValue();
    }

    private void updateShowValue() {
        if (isEditing) {
            showValue.setValue(value);
        } else {
            showValue.setValue(calculatedValue);
        }
    }

    public SimpleStringProperty getShowValue() {
        if(showValue == null) {
            showValue = new SimpleStringProperty(value);
            this.updateShowValue();
        }
        return showValue;
    }
}
