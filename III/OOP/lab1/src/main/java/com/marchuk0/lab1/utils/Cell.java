package com.marchuk0.lab1.utils;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.HashMultiset;

public class Cell implements Serializable {
    private transient SimpleStringProperty showValue;
    private String value;
    private String calculatedValue;
    private int column;
    private int row;
    private boolean isEditing = false;

    private HashMultiset<Cell> childCells = HashMultiset.create();
    private HashMultiset<Cell> parentCells = HashMultiset.create();

    public Cell() {
        this.value = "";
        this.showValue = new SimpleStringProperty(value);
        this.calculateValue();
    }

    public Cell(int column, int row) {
        this();
        this.column = column;
        this.row = row;
    }


    public String getValue() {
        return value;
    }

    public String getRowNumber() {
        return SpreadSheetHelper.intToRowNumber(row);
    }
    public String getCalculatedValue() {
        return calculatedValue;
    }

    public void setValue(String value) {
        this.value = value;
        this.calculateValue();
    }

    public void calculateValue() {
        try {
            this.updateChildCells(SpreadSheetHelper.getCellsFromExpression(value));
            checkCycleDfs(this, this);
            calculatedValue = SpreadSheetHelper.evalExpression(value);
            this.updateParentCells();
        } catch (Exception e) {
            calculatedValue = "Error";
            this.updateChildCells(List.of());
        }
        this.updateShowValue();
    }

    private void updateChildCells(List<Cell> cellsFromExpression) {
        childCells.forEach(cell -> cell.removeFromParentSet(this));
        cellsFromExpression.forEach(cell -> cell.addToParentSet(this));

        childCells.clear();
        childCells.addAll(cellsFromExpression);
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
        if (showValue == null) {
            showValue = new SimpleStringProperty(value);
            this.updateShowValue();
        }
        return showValue;
    }

    public void removeFromParentSet(Cell cell) {
        this.parentCells.remove(cell);
    }

    public void addToParentSet(Cell cell) {
        this.parentCells.add(cell);
    }

    private void updateParentCells() {
        parentCells.forEach(Cell::calculateValue);
    }

    private void checkCycleDfs(Cell startCell, Cell curCell) throws Exception {
        for(var cell : curCell.childCells) {
            if(cell == startCell) {
                throw new Exception();
            }
            cell.checkCycleDfs(startCell, cell);
        }
    }
}
