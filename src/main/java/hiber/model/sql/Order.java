package hiber.model.sql;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int price;

    @Column(name = "order_date")
    private Date data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<ListOfOrder> listOfOrder;

    public Order() {
    }

    public Order(int price, Date data) {
        this.price = price;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<ListOfOrder> getListOfOrder() {
        return listOfOrder;
    }

    public void setListOfOrder(Set<ListOfOrder> listOfOrder) {
        this.listOfOrder = listOfOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", data=" + data +
                '}';
    }
}
