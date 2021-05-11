package ss17_io_binary_file.exercise.manage_product;

import java.io.Serializable;

public class Product implements Serializable {
    String idProduct;
    String nameProduct;
    String codeProduct;
    int priceProduct;
    String typeOfProduct;

    public Product(String idProduct, String nameProduct, String codeProduct, int priceProduct, String typeOfProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.codeProduct = codeProduct;
        this.priceProduct = priceProduct;
        this.typeOfProduct = typeOfProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    @Override
    public String toString() {
        return "idProduct: " + idProduct + '\t' +
                "nameProduct: " + nameProduct + '\t' +
                "codeProduct: " + codeProduct + '\t' +
                "priceProduct: " + priceProduct + '\t' +
                "typeOfProduct: " + typeOfProduct + '\t';
    }
}
