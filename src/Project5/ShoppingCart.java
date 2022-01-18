package Project5;


import java.util.Arrays;

public class ShoppingCart {

    private Product[] products;

    public ShoppingCart() {

        this.products = new Product[0];
        this.products = new Product[0];
    }

    public void addProduct(Product product) { // ������
        Product[] addProduct = new Product[products.length + 1];
        for (int i = 0; i < this.products.length; i++) {
            addProduct[i] = product;

        }
    }

    public String toString() {
        return "ShoppingCart{" +
                "products=" + Arrays.toString(products) +
                '}';
    }
//public String toSt


}
