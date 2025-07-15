package com.tnsif.restapi.controller;

import com.tnsif.restapi.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private Map<Integer, Customer> customerDB = new HashMap<>();

    @PostMapping
    public String addCustomer(@RequestBody Customer customer) {
        customerDB.put(customer.getId(), customer);
        return "Customer added!";
    }

    @GetMapping
    public Collection<Customer> getAllCustomers() {
        return customerDB.values();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customerDB.get(id);
    }

    @PutMapping("/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customerDB.put(id, customer);
        return "Customer updated!";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerDB.remove(id);
        return "Customer deleted!";
    }
}
