package POJO;

import java.util.Date;

public class VIEW_SUPPLY {
    private int id_supply;
    private String name_prod;
    private  String name_sup;
    private int ammount_sup;
    private float price_in_sup;
    private Date date_sup;
    private int processed;

    public VIEW_SUPPLY() {
    }

    public VIEW_SUPPLY( String name_prod, String name_sup, int ammount_sup, float price_in_sup, Date date_sup, int processed) {
        this.name_prod = name_prod;
        this.name_sup = name_sup;
        this.ammount_sup = ammount_sup;
        this.price_in_sup = price_in_sup;
        this.date_sup = date_sup;
        this.processed = processed;
    }

    public int getId_supply() {
        return id_supply;
    }

    public void setId_supply(int id_supply) {
        this.id_supply = id_supply;
    }

    public String getName_prod() {
        return name_prod;
    }

    public void setName_prod(String name_prod) {
        this.name_prod = name_prod;
    }

    public String getName_sup() {
        return name_sup;
    }

    public void setName_sup(String name_sup) {
        this.name_sup = name_sup;
    }

    public int getAmmount_sup() {
        return ammount_sup;
    }

    public void setAmmount_sup(int ammount_sup) {
        this.ammount_sup = ammount_sup;
    }

    public float getPrice_in_sup() {
        return price_in_sup;
    }

    public void setPrice_in_sup(float price_in_sup) {
        this.price_in_sup = price_in_sup;
    }

    public Date getDate_sup() {
        return date_sup;
    }

    public void setDate_sup(Date date_sup) {
        this.date_sup = date_sup;
    }

    public int getProcessed() {
        return processed;
    }

    public void setProcessed(int processed) {
        this.processed = processed;
    }
}
