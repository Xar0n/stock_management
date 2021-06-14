package POJO;

public class Recevier {
    private int id_recevier;
    private String name_recev;
    private String address_recev;

    public Recevier() {
    }

    public Recevier(String name_recev, String address_recev) {
        this.name_recev = name_recev;
        this.address_recev = address_recev;
    }

    public int getId_recevier() {
        return id_recevier;
    }

    public void setId_recevier(int id_recevier) {
        this.id_recevier = id_recevier;
    }

    public String getName_recev() {
        return name_recev;
    }

    public void setName_recev(String name_recev) {
        this.name_recev = name_recev;
    }

    public String getAddress_recev() {
        return address_recev;
    }

    public void setAddress_recev(String address_recev) {
        this.address_recev = address_recev;
    }
}
