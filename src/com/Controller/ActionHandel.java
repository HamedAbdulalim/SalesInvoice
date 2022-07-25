
package com.Controller;

import com.model.InvoiceHeader;
import com.model.InvoiceHeaderTable;
import com.model.InvoiceLine;
import com.model.InvoiceLineTable;
import com.view.InvHeaderDialog;
import com.view.InvLineDialog;
import com.view.SalesFrame;
import static com.view.SalesFrame.Dformate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ActionHandel implements ActionListener, ListSelectionListener {
    private SalesFrame frame;
    private InvHeaderDialog hDialog;
    private InvLineDialog lineDialog;


    public ActionHandel(SalesFrame frame){
       this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      switch (e.getActionCommand()){
          case "New Invoice":
                newInv();
              break;
              case "Delet Invoice":
                deleteInv();
              break;
              case "New Item":
                newItem();
              break;
              case " Delete Item":
                deleteItem();
              break;
               case "Load File":
                loadFile();
              break;
               case "Save files":
                saveFile();
              break;
               case "newLineCancel":
                   newLineDCancel();
                   break;

               case "newLineOK":
                   newlineDOK();
                   break;

                 case "newInvoiceOK":
                newInvoiceDialogOK();
                break;

            case "newInvoiceCancel":
                newInvoiceDialogCancel();
                break;



      }
    }


    private void newInv() {
        hDialog = new InvHeaderDialog(frame);
        hDialog.setVisible(true);
    }

    private void deleteInv() {
        int selectedData = frame.getHeaderTabl().getSelectedRow();
        if (selectedData != -1){
            frame.getInvoicesArray().remove(selectedData);
            frame.getHeaderTableModel().fireTableDataChanged();
            frame.getLineTable().setModel(new InvoiceLineTable(null));
            frame.setLinesArr(null);
            frame.getCustomerLb().setText("");
            frame.getNumLb().setText("");
            frame.getTotalLb().setText("");
            frame.getDateLb().setText("");


        }


    }

    private void newItem() {
        lineDialog = new  InvLineDialog(frame);
        lineDialog.setVisible(true);
    }

    private void deleteItem() {
         int selectedLineIndex = frame.getLineTable().getSelectedRow();
        int selectedInvoiceIndex = frame.getHeaderTabl().getSelectedRow();
        if (selectedLineIndex != -1) {
            frame.getLinesArr().remove(selectedLineIndex);
            InvoiceLineTable lineTableM = (InvoiceLineTable) frame.getLineTable().getModel();
            lineTableM.fireTableDataChanged();
            frame.getHeaderTableModel().fireTableDataChanged();
            frame.getHeaderTabl().setRowSelectionInterval(selectedInvoiceIndex, selectedInvoiceIndex);
        }


    }

    private void loadFile() {
        JFileChooser fileChooser =new JFileChooser();

     try {
        int result = fileChooser.showOpenDialog(frame);
        if(result == JFileChooser.APPROVE_OPTION ){
          File headerFile = fileChooser.getSelectedFile();
          Path headerPath = Paths.get(headerFile.getAbsolutePath());
          List<String> headerLines = Files.readAllLines(headerPath);
          ArrayList <InvoiceHeader> invoiceHeaders = new ArrayList<>();
          for (String headerLine : headerLines){
             String[] cut = headerLine.split(",");
             String first = cut[0];
             String sec = cut[1];
             String third = cut[2];
             int code = Integer.parseInt(first);
             Date SalesDate = Dformate.parse(sec);
             InvoiceHeader header = new InvoiceHeader (code,third,SalesDate);
             invoiceHeaders.add(header);

          }
              frame.setInvoicesArray(invoiceHeaders);
              result = fileChooser.showOpenDialog(frame);
              if (result == JFileChooser.APPROVE_OPTION){
                    File LineFile = fileChooser.getSelectedFile();
                    Path LinePathe = Paths.get(LineFile.getAbsolutePath());
                    List<String> lineLines = Files.readAllLines(LinePathe);
                    ArrayList <InvoiceLine> invoiceLines = new ArrayList<>();
                    for ( String lineLine : lineLines){
                        String[] cut = lineLine.split(",");
                        String Fr1 = cut[0]; // invoice num (int)
                        String Fr2 = cut[1]; // item name   (String)
                        String Fr3 = cut[2]; // price       (double)
                        String Fr4 = cut[3]; // count       (int)
                        int invCode = Integer.parseInt(Fr1);
                        double price = Double.parseDouble(Fr3);
                        int count = Integer.parseInt(Fr4);
                        InvoiceHeader inv = frame.getInvObject(invCode);
                        InvoiceLine line = new InvoiceLine(inv, Fr2, price, count);
                        inv.getLines().add(line);
                     }
                }
              InvoiceHeaderTable headerTb = new InvoiceHeaderTable(invoiceHeaders);
                frame.setInvoiceHeaderTableModel(headerTb);
                frame.getHeaderTabl().setModel(headerTb);
                System.out.println("files read");
        }
     }  catch(IOException ex){
             JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
      } catch (ParseException ex){
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);

      }
    }


    private void saveFile() {
        ArrayList<InvoiceHeader> invoicesArray = frame.getInvoicesArray();
        JFileChooser fc = new JFileChooser();
        try {
            int result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                String headers = "";
                String lines = "";
                for (InvoiceHeader invoice : invoicesArray) {
                    headers += invoice.toString();
                    headers += "\n";
                    for (InvoiceLine line : invoice.getLines()) {
                        lines += line.toString();
                        lines += "\n";
                    }
                }

                headers = headers.substring(0, headers.length() - 1);
                lines = lines.substring(0, lines.length() - 1);
                result = fc.showSaveDialog(frame);
                File lineFile = fc.getSelectedFile();
                FileWriter lfw = new FileWriter(lineFile);
                hfw.write(headers);
                lfw.write(lines);
                hfw.close();
                lfw.close();

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void newInvoiceDialogOK() {
        hDialog.setVisible(false);
        String custName = hDialog.getCustNameField().getText();
        String txt = hDialog.getInvDateField().getText();
        Date vDate = new Date();
        try{
        vDate = SalesFrame.Dformate.parse(txt);
            
        
        } catch (ParseException ex){
            JOptionPane.showMessageDialog(frame, "Cannot parse date, reset to today date.", "Invalid date format", JOptionPane.ERROR_MESSAGE);
        }
         int invNumber = 0;
        for (InvoiceHeader inv : frame.getInvoicesArray()) {
            if (inv.getNum() > invNumber) {
                invNumber = inv.getNum();
            }
        }
        invNumber++;
        InvoiceHeader inv = new InvoiceHeader(invNumber, custName, vDate);
        frame.getInvoicesArray().add(inv);
        frame.getHeaderTableModel().fireTableDataChanged();
        hDialog.dispose();
        hDialog = null;
    }

    private void newInvoiceDialogCancel() {
        hDialog.setVisible(false);
        hDialog.dispose();
        hDialog = null;
    }

    private void newLineDCancel() {
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;
    }

    private void newlineDOK() {
        lineDialog.setVisible(false);
        String name = lineDialog.getItemNameField().getText();
        String iCount = lineDialog.getItemCountField().getText();
        String iPrice = lineDialog.getItemPriceField().getText();
        int count = 1;
        double price = 1;
        try {
            count = Integer.parseInt(iCount);
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Cannot convert number", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }
        try {
            price = Double.parseDouble(iPrice);
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Cannot convert price", "Invalid number format", JOptionPane.ERROR_MESSAGE);
        }
        int selectedInvoicesH =frame.getHeaderTabl().getSelectedRow();
         if (selectedInvoicesH != -1) {
            InvoiceHeader invHeader = frame.getInvoicesArray().get(selectedInvoicesH);
             InvoiceLine Line = new InvoiceLine(invHeader, name, price, count);
           // invHeader.getLines().add(Line);
            frame.getLinesArr().add(Line);
            InvoiceLineTable lineTableM = (InvoiceLineTable) frame.getLineTable().getModel();
            lineTableM.fireTableDataChanged();
            frame.getHeaderTableModel().fireTableDataChanged();
        }
            frame.getHeaderTabl().setRowSelectionInterval(selectedInvoicesH, selectedInvoicesH);
      
        lineDialog.dispose();
        lineDialog = null;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
