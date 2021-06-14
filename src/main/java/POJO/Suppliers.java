package POJO;

public class Suppliers {
    private int id_suppliers;
    private String name_sup;
    private String address_sup;

    public Suppliers() {
    }

    public Suppliers(String name_sup, String address_sup) {
        this.name_sup = name_sup;
        this.address_sup = address_sup;
    }

    public int getId_suppliers() {
        return id_suppliers;
    }

    public void setId_suppliers(int id_suppliers) {
        this.id_suppliers = id_suppliers;
    }

    public String getName_sup() {
        return name_sup;
    }

    public void setName_sup(String name_sup) {
        this.name_sup = name_sup;
    }

    public String getAddress_sup() {
        return address_sup;
    }

    public void setAddress_sup(String address_sup) {
        this.address_sup = address_sup;
    }
}
