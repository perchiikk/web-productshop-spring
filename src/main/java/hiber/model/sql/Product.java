package hiber.model.sql;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity")
    private Integer count;

    @Column
    private boolean alco;

    @Column
    private String name;

    @Column
    private Integer price;

    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private Set<ListOfOrder> listOfOrder;

    public Product() {
    }

    public Product(Integer count, boolean alco, String name, Integer price) {
        this.count = count;
        this.alco = alco;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public boolean isAlco() {
        return alco;
    }

    public void setAlco(boolean alco) {
        this.alco = alco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Set<ListOfOrder> getListOfOrder() {
        return listOfOrder;
    }

    public void setListOfOrder(Set<ListOfOrder> listOfOrder) {
        this.listOfOrder = listOfOrder;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", count=" + count +
                ", alco=" + alco +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return alco == product.alco && Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alco, name, price);
    }
}
