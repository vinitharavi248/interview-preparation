package com.textile.billing.servicce;
import com.textile.billing.entity.*;
import com.textile.billing.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ProductRepository productRepo;

    // Create Billing
    public Billing createBill(int customerId, List<Integer> productIds) {

        Customer customer = customerRepo.findById(customerId).orElseThrow();

        List<Product> products = productRepo.findAllById(productIds);

        Billing billing = new Billing();
        billing.setCustomer(customer);
        billing.setProducts(products);

        billing.setNoOfProduct(products.size());

        double total = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        billing.setTotalAmount(total);

        return billingRepo.save(billing);
    }

    // Get All Bills
    public List<Billing> getAllBills() {
        return billingRepo.findAll();
    }

    // Delete Bill
    public void deleteBill(int id) {
        billingRepo.deleteById(id);
    }
}