package hiber.controller;

import hiber.model.sql.Customer;
import hiber.model.sql.ListOfOrder;
import hiber.model.sql.Order;
import hiber.model.sql.Product;
import hiber.service.customer.CustomerService;
import hiber.service.listoforder.ListOfOrderService;
import hiber.service.order.OrderService;
import hiber.service.shopmanager.ShopManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("customers")
public class CustomerController {
    private CustomerService customerService;
    private ShopManagerService shopManagerService;
    private OrderService orderService;
    private ListOfOrderService listOfOrderService;

    @Autowired
    public CustomerController(CustomerService customerService, ShopManagerService shopManagerService,
                              OrderService orderService, ListOfOrderService listOfOrderService) {
        this.customerService = customerService;
        this.shopManagerService = shopManagerService;
        this.orderService = orderService;
        this.listOfOrderService = listOfOrderService;
    }

    @GetMapping()
    public String getAllCustomers(Model model){
        model.addAttribute("customers", customerService.getAll());
        return "customer/customers";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/show-customer";
    }

    @GetMapping("/sign_in")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/sign-in";
    }


    @PostMapping()
    public String createCustomer(@ModelAttribute("customer") Customer customer){
        customerService.add(customer);
        return "redirect:/customers/go";
    }

    @GetMapping("/go")
    public String goToShop(){
        return "customer/go-shop";
    }

    @GetMapping("payment")
    public String getPayment(Model model){
        Customer customer = customerService.getLast();
        int reduce = customer.getBudget() - shopManagerService.getPayment();
        if(reduce<0){
            return "error-payment";
        }

        Order order = new Order(shopManagerService.getPayment(), new Date());
        order.setCustomer(customer);
        Set<ListOfOrder> setOrder = new HashSet<>();
        for(Map.Entry<Product, Integer> entry : shopManagerService.getOrder().entrySet()){
            ListOfOrder listOfOrder = new ListOfOrder();
            listOfOrder.setOrder(order);
            listOfOrder.setProduct(entry.getKey());
            listOfOrder.setCount(entry.getValue());
            setOrder.add(listOfOrder);
        }
        order.setListOfOrder(setOrder);
        orderService.add(order);
        model.addAttribute("payment", shopManagerService.getPayment());

        customer.setBudget(reduce);
        customerService.update(customer);

        shopManagerService.cleanOrderCart();
        return "payment";
    }

}
