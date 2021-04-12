package hiber.model.sql;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer age;

    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Order> order;

    @Column
    private Integer budget;

    public Customer() {
    }

    public Customer(String name, Integer age, Integer budget) {
        this.name = name;
        this.age = age;
        this.budget = budget;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public Integer getBudget() {
        return budget;
    }


}
