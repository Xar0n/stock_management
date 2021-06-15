package POJO;

import javafx.util.StringConverter;

import javax.persistence.*;

@Entity
@Table(name = "storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_storage;
    @Column (name = "name")
    private String name;
    @Column (name = "address")
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
