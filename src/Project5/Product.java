package Project5;

public class Product {
    private int numberProduct;
    private String nameProduct;
    private int price;

    public Product(int numberProduct, String nameProduct, int price) {
        this.numberProduct = numberProduct;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public int getNumberProduct() {
        return numberProduct;
    }

    public void setNumberProduct(int numberProduct) {
        this.numberProduct = numberProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "Product{" +
                "numberProduct=" + numberProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                '}';
    }
}
