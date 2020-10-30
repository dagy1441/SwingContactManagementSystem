/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.tablesmodels;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dagy
 * 
 * Create a contact table model to display the contact to jtable
 * 
 */
public class TableModel extends AbstractTableModel{
    
    private String[] columns;
    private Object[][] rows;

    public TableModel() {
    }

    public TableModel(Object[][] data, String[] columnName) {
        this.columns = columnName;
        this.rows = data;
    }
    
    public Class getColomnClass(int col){
        
        // the index of the image colomn is 8
        if( col == 8){
            return Icon.class;
        }else{
            return getValueAt(0, col).getClass();
        }
    }
    
    @Override
    public String getColumnName(int col){
        return this.columns[col];
    }

    @Override
    public int getRowCount() {
        return this.rows.length;
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows[rowIndex][columnIndex];
    }
    
}
