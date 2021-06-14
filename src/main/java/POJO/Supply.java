package POJO;

import java.sql.Date;

public class Supply {
    private int id_supply;
    private int id_suppliers;
    private int id_sj;
    private int ammount_sup;
    private Date date_sup;
    private int processed;

    public Supply() {
    }

    public Supply(int id_suppliers, int id_sj, int ammount_sup, Date date_sup, int processed) {
        this.id_suppliers = id_suppliers;
        this.id_sj = id_sj;
        this.ammount_sup = ammount_sup;
        this.date_sup = date_sup;
        this.processed = processed;
    }

    public int getId_supply() {
        return id_supply;
    }

    public void setId_supply(int id_supply) {
        this.id_supply = id_supply;
    }

    public int getId_suppliers() {
        return id_suppliers;
    }

    public void setId_suppliers(int id_suppliers) {
        this.id_suppliers = id_suppliers;
    }

    public int getId_sj() {
        return id_sj;
    }

    public void setId_sj(int id_sj) {
        this.id_sj = id_sj;
    }

    public int getAmmount_sup() {
        return ammount_sup;
    }

    public void setAmmount_sup(int ammount_sup) {
        this.ammount_sup = ammount_sup;
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
