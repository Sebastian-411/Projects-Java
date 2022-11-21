package model;

import java.util.Date;

public class Purchase {
    private Date datePurchase;
    private Sellable purchase;

    public Purchase(Date datePurchase, Sellable purchase) {
        this.datePurchase = datePurchase;
        this.purchase = purchase;
    }

    public Date getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }

    public Sellable getPurchase() {
        return purchase;
    }

    public void setPurchase(Sellable purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "Purchase\n" +
                " DatePurchase: " + datePurchase +
                "\n Purchase: " + purchase.toString();
    }
}
