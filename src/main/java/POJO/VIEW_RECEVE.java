package POJO;

import java.util.Date;

public class VIEW_RECEVE {
    private int id_receve;
    private String name_prod;
    private  String name_recev;
    private int ammount_rec;
    private float price_in_sale;
    private Date date_rec;
    private int processed;

    public VIEW_RECEVE() {
    }

    public VIEW_RECEVE(String name_prod, String name_recev, int ammount_rec, float price_in_sale, Date date_rec, int processed) {
        this.name_prod = name_prod;
        this.name_recev = name_recev;
        this.ammount_rec = ammount_rec;
        this.price_in_sale = price_in_sale;
        this.date_rec = date_rec;
        this.processed = processed;
    }

    public int getId_receve() {
        return id_receve;
    }

    public void setId_receve(int id_receve) {
        this.id_receve = id_receve;
    }

    public String getName_prod() {
        return name_prod;
    }

    public void setName_prod(String name_prod) {
        this.name_prod = name_prod;
    }

    public String getName_recev() {
        return name_recev;
    }

    public void setName_recev(String name_recev) {
        this.name_recev = name_recev;
    }

    public int getAmmount_rec() {
        return ammount_rec;
    }

    public void setAmmount_rec(int ammount_rec) {
        this.ammount_rec = ammount_rec;
    }

    public float getPrice_in_sale() {
        return price_in_sale;
    }

    public void setPrice_in_sale(float price_in_sale) {
        this.price_in_sale = price_in_sale;
    }

    public Date getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(Date date_rec) {
        this.date_rec = date_rec;
    }

    public int getProcessed() {
        return processed;
    }

    public void setProcessed(int processed) {
        this.processed = processed;
    }
}
