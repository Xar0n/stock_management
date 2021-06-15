package POJO;

public class VIEW_STORAGE_NUM {
    private int id_product;
    private String name_prod;
    private int amount;
    private float price_in_sup;
    private float price_in_sale;

    public VIEW_STORAGE_NUM() {
    }

    public VIEW_STORAGE_NUM(String name_prod, int amount, float price_in_sup, float price_in_sale) {
        this.name_prod = name_prod;
        this.amount = amount;
        this.price_in_sup = price_in_sup;
        this.price_in_sale = price_in_sale;
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
