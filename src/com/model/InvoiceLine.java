
package com.model;


public class InvoiceLine {
    private InvoiceHeader header;
    private String ItemName;
    private double TtemPrice;
    private int Itemcoun;
   

        public InvoiceLine(InvoiceHeader header, String ItemName, double TtemPrice, int Itemcoun) {
        this.header = header;
        this.ItemName = ItemName;
        this.TtemPrice = TtemPrice;
        this.Itemcoun = Itemcoun;
    }

   
    public int getItemcoun() {
        return Itemcoun;
    }

    public void setItemcoun(int Itemcoun) {
        this.Itemcoun = Itemcoun;
    }

    public InvoiceHeader getInvoice() {
        return header;
    }

    public void setInvoice(InvoiceHeader invoice) {
        this.header = invoice;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public double getTtemPrice() {
        return TtemPrice;
    }
    
    public void setTtemPrice(double TtemPrice) {
        this.TtemPrice = TtemPrice;
    }
    public double getLineTotal() {
        return TtemPrice * Itemcoun;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" + "invoice=" + header.getNum()+ ", ItemName=" + ItemName +"line total=" + getLineTotal()+", TtemPrice=" + TtemPrice + ", Itemcoun=" + Itemcoun + '}';
    }
      
    
    
    
}
