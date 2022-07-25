
package com.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    int num;
    private String customerN;
    private Date date;
    private ArrayList<InvoiceLine> lines;

    public InvoiceHeader(int num, String customerN, Date date) {
        this.num = num;
        this.customerN = customerN;
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerN() {
        return customerN;
    }

    public void setCustomerN(String customerN) {
        this.customerN = customerN;
    }

    public ArrayList<InvoiceLine> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }
        
        return lines;
    }

    public void setLines(ArrayList<InvoiceLine> lines) {
        this.lines = lines;
    } 
    
     public double getInvoiceTotal(){
         double total = 0;
         for(InvoiceLine line : getLines()){
             total+= line.getLineTotal();
       }
        return total;
    
     }


    @Override
    public String toString() {
        return "InvoiceHeader{" + "number=" + num + ", customerN=" + customerN + ", date=" + date + ", lines=" + lines + '}';
    }
               
    
}
