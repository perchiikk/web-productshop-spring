package hiber.controller;

import hiber.model.other.CurrentOrder;
import hiber.model.sql.ListOfOrder;
import hiber.model.sql.Order;
import hiber.service.customer.CustomerService;
import hiber.service.listoforder.ListOfOrderService;
import hiber.service.order.OrderService;
import hiber.service.product.ProductService;
import hiber.service.shopmanager.ShopManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("shop")
public class HelloController {

    private ProductService productService;
    private ListOfOrderService listOfOrderService;
    private CustomerService customerService;
    private OrderService orderService;
    private ShopManagerService shopManagerService;

    @Autowired
    public HelloController(ProductService productService, ListOfOrderService listOfOrderService, CustomerService customerService, OrderService orderService,
                           ShopManagerService shopManagerService) {
        this.productService = productService;
        this.listOfOrderService = listOfOrderService;
        this.customerService = customerService;
        this.orderService = orderService;
        this.shopManagerService = shopManagerService;
    }

    @GetMapping()
    public String sayHello(){
        return "hi";
    }

    @GetMapping("/catalog")
    public String getCatalog(Model model){
        model.addAttribute("products", productService.getAll());
        return "catalog";
    }

    @GetMapping("/{id}/order")
    public String getProductDescription(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getById(id));
        model.addAttribute("order", new CurrentOrder());
        return "order";
    }

    @PostMapping()
    public String createOrder(@ModelAttribute("order") CurrentOrder currentOrder){
        shopManagerService.addToItem(productService.searchByName(currentOrder.getNameProduct()), currentOrder.getCount());
        return "redirect:/shop/catalog";
    }

    @GetMapping("bag")
    public String getBag(Model model){
        model.addAttribute("bag", shopManagerService.getOrder());
        return "bag";
    }

    @DeleteMapping("bag/{item}")
    public String deleteItem(@PathVariable("item") String name){
        shopManagerService.deleteByName(productService.searchByName(name));
        return "redirect:/shop/bag";
    }

    @GetMapping("/table")
    public String getTable(Model model){
        model.addAttribute("buyers", customerService.getAll());
        return "table";
    }

    @GetMapping("/table/{id}")
    public String getInfoAboutCustomer(@PathVariable("id") int id, Model model){
        model.addAttribute("buyer", customerService.getById(id));
        return "show";
    }

    @GetMapping("/order/{id}")
    public String orderInfo(@PathVariable("id") int id, Model model){
        List<Order> orderList = orderService.getByCustomerId(id);
        List<ListOfOrder> resultList = new ArrayList<>();

        for(Order order : orderList){
            resultList.addAll(listOfOrderService.getListByOrderId(order.getId()));
        }

        model.addAttribute("orders", resultList);
        return "order-info";
    }
}
