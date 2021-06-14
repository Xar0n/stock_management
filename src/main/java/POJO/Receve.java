package POJO;

import java.util.Date;

public class Receve {
    private int id_receve;
    private int id_reciver;
    private int id_js;
    private int ammount_rec;
    private Date date_rec;
    private int processed;

    public Receve() {
    }

    public Receve(int id_reciver, int id_js, int ammount_rec, Date date_rec, int processed) {
        this.id_reciver = id_reciver;
        this.id_js = id_js;
        this.ammount_rec = ammount_rec;
        this.date_rec = date_rec;
        this.processed = processed;
    }

    public int getId_receve() {
        return id_receve;
    }

    public void setId_receve(int id_receve) {
        this.id_receve = id_receve;
    }

    public int getId_reciver() {
        return id_reciver;
    }

    public void setId_reciver(int id_reciver) {
        this.id_reciver = id_reciver;
    }

    public int getId_js() {
        return id_js;
    }

    public void setId_js(int id_js) {
        this.id_js = id_js;
    }

    public int getAmmount_rec() {
        return ammount_rec;
    }

    public void setAmmount_rec(int ammount_rec) {
        this.ammount_rec = ammount_rec;
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
