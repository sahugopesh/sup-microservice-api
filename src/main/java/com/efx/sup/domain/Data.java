package com.efx.sup.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/*
 * a simple domain entity doubling as a DTO
 */
@Entity
@Table(name = "data")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {

    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private String billingData;

    @Column()
    private int invoicePrice;

    public Data() {
    }

    public Data(String Word, int Count) {
        this.billingData = Word;
        this.invoicePrice = Count;
    }

    public long getId() {
        return this.id;
    }

    // for tests ONLY
    public void setId(long id) {
        this.id = id;
    }

    public String getBillingData() {
        return billingData;
    }

    public void setBillingData(String billingData) {
        this.billingData = billingData;
    }

    public int getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(int invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    @Override
    public String toString() {
        return "Data {" +
                "id=" + id +
                ", billingData='" + billingData + '\'' +
                ", invoicePrice=" + invoicePrice +
                '}';
    }
}
