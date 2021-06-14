package POJO;


public class Storage {
    private int id_storage;
    private String name;
    private String address;

    public Storage() {
    }

    public Storage(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public int getId_storage() {
        return id_storage;
    }

    public void setId_storage(int id_storage) {
        this.id_storage = id_storage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
