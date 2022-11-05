package com.obed.example.rest.Controller;

import com.obed.example.rest.Models.Customer;
import com.obed.example.rest.Models.Item;
import com.obed.example.rest.Repo.CustomerRepo;
import com.obed.example.rest.Repo.ItemRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Label class as REST Controller; it would have some endpoints
@RestController
public class ApiControllers {
    //customer repository/model
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ItemRepo itemRepo; //item repository/model

    @GetMapping(value = "/")
    public String getPage() {
        return "Hello World";
    }

    @GetMapping(value = "/customers")
    public List<Customer> getUsers() {
        return customerRepo.findAll();
    }

    @GetMapping(value = "/customer/{id}")
    public Customer getUser(@PathVariable("id") long id) {
        return customerRepo.findById(id).get();
    }

    @PostMapping(value = "/save-customer")
    public String saveCustomer(@RequestBody Customer customer) {
        customerRepo.save(customer);
        return "Customer saved";
    }

    @PutMapping(value = "/update-customer/{id}")
    public String updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        Customer updated_customer = customerRepo.findById(id).get();
        updated_customer.setFirstName(customer.getFirstName());
        updated_customer.setLastName(customer.getLastName());
        updated_customer.setEmail(customer.getEmail());
        updated_customer.setPassword(customer.getPassword());
        customerRepo.save(updated_customer);
        return "Customer updated";
    }

    @PatchMapping(value = "/update-customer-detail/{id}")
    public ResponseEntity <?> updateCustomerDetail(@PathVariable long id, @RequestBody @NotNull Customer customer) {
        Customer updated_customer = customerRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        updated_customer.setPassword(customer.getPassword());
        customerRepo.save(updated_customer);
        return ResponseEntity.ok("Customer updated");
    }

    @DeleteMapping(value = "/delete-customer/{id}")
    public String deleteCustomer(@PathVariable long id) {
        customerRepo.deleteById(id);
        return "Customer deleted";
    }

    //    item routes
    @GetMapping(value = "/items")
    public List<Item> getItems() {
        return itemRepo.findAll();
    }
}
