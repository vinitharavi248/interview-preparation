package com.textile.billing.controller;
import com.textile.billing.entity.Billing;
import com.textile.billing.servicce.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService service;

    // Create Bill
    @PostMapping("/create")
    public Billing createBill(
            @RequestParam int customerId,
            @RequestBody List<Integer> productIds) {

        return service.createBill(customerId, productIds);
    }

    @GetMapping
    public List<Billing> getAllBills() {
        return service.getAllBills();
    }

    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable int id) {
        service.deleteBill(id);
        return "Bill deleted successfully";
    }
}