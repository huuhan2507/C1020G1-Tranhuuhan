package bean;

public class Product {
    private Integer id;
    private String code;
    private String product_name;
    private String price;

    public Product(Integer product_id, String code, String product_name, String price) {
        this.id = product_id;
        this.code = code;
        this.product_name = product_name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setProduct_id(Integer product_id) {
        this.id = product_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
