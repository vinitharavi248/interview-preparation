package com.textile.billing.repository;

import com.textile.billing.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, Integer> {
}