package tacos.web;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import tacos.Order;
import tacos.User;
import tacos.data.OrderRepository;
import tacos.data.UserRepository;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

  private OrderRepository orderRepo;
  private UserRepository userRepository; 

  public OrderController(OrderRepository orderRepo, UserRepository userRepository) {
    this.orderRepo = orderRepo;
    this.userRepository = userRepository; 
  }

  
  @GetMapping("/current")
  public String orderForm() {
    return "orderForm";
  }

  
  @PostMapping
  public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus) {
    if (errors.hasErrors()) {
      return "orderForm";
    }
    
    User user = userRepository.findByUsername(principal.getName());

    order.setUser(user);
    
    orderRepo.save(order);
    sessionStatus.setComplete();

    return "redirect:/";
  }	

}