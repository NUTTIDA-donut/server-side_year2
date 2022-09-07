package sit.int204.classicmodelsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.dtos.SimpleCustomerDTO;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.repositories.CustomerRepository;
import sit.int204.classicmodelsservice.services.CustomerService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
//    public Page<Customer> getAllCustomers(
    public List<Customer> getAllCustomers(
          @RequestParam(defaultValue = "id") String sortBy,
          @RequestParam(defaultValue = "0") Integer page,
          @RequestParam(defaultValue = "10") Integer pageSize){
        Sort sort = Sort.by(sortBy);
//        return repository.findAll(PageRequest.of(page,pageSize,sort));
        return repository.findAll(PageRequest.of(page,pageSize,sort)).getContent();
    }

    @GetMapping("/credit/{lower}/{upper}")
    public List<Customer> getCustomerByCredit(
            @PathVariable BigDecimal lower,
            @PathVariable BigDecimal upper){
        return repository.findAllByCreditLimitBetween(lower, upper);
    }

    @RequestMapping("/{id}")
    public SimpleCustomerDTO getCustomerById(@PathVariable Integer id){
        return customerService.getSimpleCustomerById(id);
    }
}
