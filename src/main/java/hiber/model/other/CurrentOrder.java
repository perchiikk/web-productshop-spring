package hiber.model.other;


public class CurrentOrder {
    private String nameProduct;
    private int count;

    public CurrentOrder() {
    }

    public CurrentOrder(String nameProduct, int count) {
        this.nameProduct = nameProduct;
        this.count = count;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
