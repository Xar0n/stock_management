package POJO;
import javax.persistence.*;

@Entity
@Table(name = "storage")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_product;
    @Column (name = "name")
    private String name_prod;

    public Product() {
    }

    public Product(String name_prod) {
        this.name_prod = name_prod;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_prod() {
        return name_prod;
    }

    public void setName_prod(String name_prod) {
        this.name_prod = name_prod;
    }
}
