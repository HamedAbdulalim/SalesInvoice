 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HAH17
 */
public class InvoiceLineTable extends AbstractTableModel {
    
     private ArrayList<InvoiceLine> linesArray;
     private String[] columns = {"Item Name", " Price", "Count", "Line Total"};

    public InvoiceLineTable(ArrayList<InvoiceLine> linesArray) {
        this.linesArray = linesArray;
    }
     

    @Override
    public int getRowCount() {
       return linesArray == null ? 0 : linesArray.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (linesArray == null) {
            return "";
        }else{
        InvoiceLine line = linesArray.get(rowIndex);
        switch (columnIndex){
            case 0 : return line.getItemName();
            case 1 : return line.getTtemPrice();
            case 2 : return line.getItemcoun();
            case 3 : return line.getLineTotal();
            default:
            return "";
        }
     }
    }
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
}
