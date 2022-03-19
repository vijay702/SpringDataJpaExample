package com.fastxpo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastxpo.bean.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
