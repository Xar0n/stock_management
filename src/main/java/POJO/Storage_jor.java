package POJO;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Storage_jor.NAMED_QUERY_GET_BY_ID_STORAGE, query = "Select e from storage_jor e where e.id_storage =:id_storage")
})
@Entity
@Table(name = "storage_jor")
public class Storage_jor {
    public static final String NAMED_QUERY_GET_BY_ID_STORAGE = "Storage.getByStatus";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sj;
    @Column (name = "id_product")
    private int id_product;
    @Column (name = "id_storage")
    private  int id_storage;
    @Column (name = "amount")
    private int amount;
    @Column (name = "price_in_sup")
    private float price_in_sup;
    @Column (name = "price_in_sale")
    private float price_in_sale;

    public Storage_jor() {
    }

    public Storage_jor(int id_product, int id_storage, int amount, float price_in_sup, float price_in_sale) {
        this.id_product = id_product;
        this.id_storage = id_storage;
        this.amount = amount;
        this.price_in_sup = price_in_sup;
        this.price_in_sale = price_in_sale;
    }

    public int getId_sj() {
        return id_sj;
    }

    public String getId_sj_str() {
        return String.valueOf(id_sj);
    }

    public void setId_sj(int id_sj) {
        this.id_sj = id_sj;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_storage() {
        return id_storage;
    }

    public void setId_storage(int id_storage) {
        this.id_storage = id_storage;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice_in_sup() {
        return price_in_sup;
    }

    public void setPrice_in_sup(float price_in_sup) {
        this.price_in_sup = price_in_sup;
    }

    public float getPrice_in_sale() {
        return price_in_sale;
    }

    public void setPrice_in_sale(float price_in_sale) {
        this.price_in_sale = price_in_sale;
    }
}
