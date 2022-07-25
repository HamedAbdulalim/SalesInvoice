
package com.Controller;

import com.model.InvoiceHeader;
import com.model.InvoiceLine;
import com.model.InvoiceLineTable;
import com.view.SalesFrame;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author HAH17
 */
public class TableSelectListener implements ListSelectionListener {
    private SalesFrame frame;

    public TableSelectListener(SalesFrame frame) {
        this.frame = frame;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedData = frame.getHeaderTabl().getSelectedRow();
        System.out.println("Invoice selected" + selectedData );
        if(selectedData != -1){
            InvoiceHeader selectdInv = frame.getInvoicesArray().get(selectedData);
            ArrayList<InvoiceLine> lines = selectdInv.getLines();
            InvoiceLineTable laineTableM = new InvoiceLineTable(lines);
            frame.setLinesArr(lines);
            frame.getLineTable().setModel(laineTableM);
            frame.getCustomerLb().setText(selectdInv.getCustomerN());
            frame.getNumLb().setText(""+selectdInv.getNum());
            frame.getTotalLb().setText(""+selectdInv.getInvoiceTotal());
            frame.getDateLb().setText(SalesFrame.Dformate.format(selectdInv.getDate()));
        
     
    }   
    }
}
